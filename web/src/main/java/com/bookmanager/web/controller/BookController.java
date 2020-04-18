package com.bookmanager.web.controller;

import com.bookmanager.pojo.Book;
import com.bookmanager.pojo.LoginUser;
import com.bookmanager.service.BookService;
import com.bookmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述BookController
 * @Author: lxy
 * @time: 2020/4/12 22:49
 */
@SuppressWarnings("all")
@Controller
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping("allBooks")
    @ResponseBody
    public Map<String, Object> allBooks(HttpSession session, Integer page, Integer totalPage, Book book, String bbid) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Book> books = new ArrayList<>();

        session.setAttribute("page", page);
        session.setAttribute("totalPage", totalPage);
        page = (int) session.getAttribute("page");
        System.out.println(page);
        // 获取页码
        // 获取总页码
        totalPage = bookService.findTotalPage();
        // 得到每一页所有书
        int index = (page - 1) * 12;
        books = bookService.findAllByIndex(index, 12);
        book = bookService.findAllById(book);
        System.out.println("boooooooook=========" + book);
        // 调试
        System.out.println(books);
        System.out.println(page);
        System.out.println(totalPage + "===================");
        // 将所有书放入session
        session.setAttribute("books", books);
        session.setAttribute("book", book);
        session.setAttribute("bbid", bbid);
        result.put("books", books);
        result.put("totalPage", totalPage);
        return result;
    }

    // 传入参数并跳转页面
    @RequestMapping("sendDatil")
    public ModelAndView sendDatil(Book book) {
        ModelAndView mav = new ModelAndView();
        // 要跳转的页面
        mav.setViewName("/detail");
        // 传入对象
        mav.addObject("book", book);
        System.out.println(book.getBid() + "22222222222222222222222");
        return mav;

    }


    // 采用超链接跳转传参到商品详情页面，最主要是获取传过去对象bid的值
    @RequestMapping("findOneBook")
    @ResponseBody
    public Book findOneBook(Book book, HttpSession session, HttpServletRequest request) {
        logger.info("------图书详情------");
        int bid = Integer.parseInt(request.getParameter("bid"));
        System.out.println("bid======="+ bid+"eeee"+book.getBid());
        book = bookService.findBookById(bid);
        return book;
    }

    // 搜索商品
    @RequestMapping("likeBook")
    @ResponseBody
    public List<Book> likeBook(HttpSession session, String lbname) {
        session.setAttribute("lbname", lbname);
        System.out.println(lbname);
        List<Book> books = new ArrayList<>();
        books = bookService.findlikeBook(lbname);
        System.out.println("books");
        return books;
    }

    @RequestMapping("addBooks")
    @ResponseBody
    public String addBooks(LoginUser user, Book book, HttpSession session, String info) {
        // 判断非空
        user = (LoginUser) session.getAttribute("user");
        LoginUser rootuser = userService.findRootByluser(user);
        logger.info("rootuser = {}", rootuser);
        if (rootuser == null) {
            info = "你不是管理员，无法操作";
            logger.info("你不是管理员，无法操作");
            return info;
        }
        if (book.getBname() == "" || book.getBcount() == 0 || book.getImg() == "" || book.getPrice() == 0
                || book.getAuthor() == "" || book.getPress() == "") {
            System.out.println("不能为空");
            info = "添加图书失败，字段不能为空";
            return info;
        } else {
            Book isexit = bookService.findAllById(book);// 判断是否存在
            if (isexit == null) {
                bookService.insertBook(book);
                System.out.println("添加成功");
                info = "添加成功";
                return info;
            } else {
                System.out.println("失败");
                info = "添加图书失败，请输入正确字段";
                return info;
            }
        }

    }

    // 通过找到bid删除一本书籍
    @RequestMapping("deleteBooks")
    @ResponseBody
    public String deleteBooks(HttpSession session, Book book, String info) {
        Object obj = session.getAttribute("user");
        if (obj == null) {
            info = "请先登录";
            logger.info("输出：{}", info);
            return info;
        } else {
            LoginUser rootuser = userService.findRootByluser((LoginUser) obj);
            if (rootuser == null) {
                info = "你不是管理员，无法操作";
                return info;
            } else {
                logger.info("bookid = {}", book.getBid());
                book = bookService.findAllById(book);
                bookService.deleteById(book);
                info = "删除成功";
                return info;
            }
        }
    }

    // 修改书籍首先找到书籍的内容
    @RequestMapping("queryBooks")
    @ResponseBody
    public Map<String, Object> queryBooks(HttpSession session, String info, Book book) {
        Map<String, Object> result = new HashMap<String, Object>();
        Object obj = session.getAttribute("user");
        if (obj == null) {
            info = "请先登录";
            result.put("info", info);
           logger.info("输出:{}", result.get("info"));
            return result;
        } else {
            LoginUser rootuser = userService.findRootByluser((LoginUser) obj);
            System.out.println(rootuser);
            if (rootuser == null) {
                info = "你不是管理员，无法操作";
                result.put("info", info);
                return result;
            } else {
                logger.info("bookid = {}", book.getBid());
                book= bookService.findAllById(book);
                //result.put必须和放进去的值在一起
                result.put("book", book);
                return result;
            }
        }
    }

    // 修改书籍内容
    @RequestMapping("updateBooks")
    @ResponseBody
    public String updateBooks(Book book, String info) {
        // 得到已经修改的图书
        // 判断非空
        if (book == null) {
            System.out.println("不能为空");
            info = "更新图书失败，请重新输入字段";
            return info;
        }
        // 通过传过来的bid判断需要更新的书籍是否存在
        Book isexit = bookService.findAllById(book);
        // 不存在新的书，就更新
        if (isexit != null) {
            bookService.updateById(book);
            info = "修改成功";
            return info;
        } else {
            info = "更新图书失败，请重新输入字段";
            return info;
        }
    }

    @RequestMapping(value = "/detail")
    public String bookDetail() {
        logger.info("-------------图书详情-------------");
        return "detail";
    }

}
