package com.bookmanager.web.controller;

import com.alibaba.fastjson.JSON;
import com.bookmanager.pojo.Book;
import com.bookmanager.pojo.BookCart;
import com.bookmanager.pojo.Cart;
import com.bookmanager.pojo.LoginUser;
import com.bookmanager.service.BookService;
import com.bookmanager.service.BorrowService;
import com.bookmanager.service.CartService;
import com.bookmanager.service.ReplayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Description: java类作用描述CartController
 * @Author: lxy
 * @time: 2020/4/16 0:46
 */
@SuppressWarnings("all")
@Controller
public class CartController {
    private Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private ReplayService replayService;
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;
//    private Cart cart;
//    private LoginUser user;
//    private Book book;
//    private BookCart bookCart;
//    private String reinfo = "已成功借书1本";
//    private String debookinfo = "已成功还书1本";
//    public String getDebookinfo() {
//        return debookinfo;
//    }
//
//    public void setDebookinfo(String debookinfo) {
//        this.debookinfo = debookinfo;
//    }
//
//    public String getReinfo() {
//        return reinfo;
//    }
//
//    public void setReinfo(String reinfo) {
//        this.reinfo = reinfo;
//    }
//
//
//    public LoginUser getUser() {
//        return user;
//    }
//
//    public void setUser(LoginUser user) {
//        this.user = user;
//    }

    @RequestMapping(value = "/cart")
    public String Cart(HttpSession session) {
            logger.info("-------cart------");
            return "cart";
    }

    // 通过用户id查找查询书架中所有书
    @RequestMapping(value = "allCarts")
    @ResponseBody
    public Map<String, Object> allCarts(HttpSession session, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        System.out.println("11111111111111" + user);
        // 判断是否登录
        if (user == null) {
            // 没有登录，创建HashMap
            msg = "请先登录";
            result.put("msg", msg);
            return result;
        } else {
            List<Cart> carts = cartService.allCartByLuser(user);
            result.put("carts", carts);
            System.out.println(carts);
            return result;
        }
    }

    // 添加书到书架中,用map方法 直接添加到视图中是不行的,借书
    @RequestMapping(value = "/addCart")
    @ResponseBody
    public Map<String, Object> addCart(HttpSession session, Book book, LoginUser user, Cart cart, BookCart bookCart) {
        Map<String, Object> reslut = new HashMap<>();
        String msg = "请联系帅气的管理员";
                // 判断操作类型,新增还是修改
        // 通过网页中传过来的bid查看书架中是否有书
        user = (LoginUser) session.getAttribute("user");
        System.out.println("+++++++++++++++++++++++++++++" + user);
        if (user == null) {
            // 没有登录，创建HashMap
            msg = "请先登录";
            reslut.put("msg", msg);
            return reslut;
        }
        logger.info("cart.bid = {}", cart.getBid());
        logger.info("cart.bname = {}", cart.getBname());
        logger.info("cart.count = {}", cart.getCount());
        logger.info("cart.img = {}", cart.getImg());
        logger.info("cart.price = {}", cart.getPrice());
        // 将bookcart放入session中
//        session.setAttribute("bookCart", bookCart);
//        bookCart = (BookCart) session.getAttribute("bookCart");
//        logger.info("book.bid = {}", book.getBid());
        logger.info("cartService = {}", cartService);
//        book = bookService.findAllById(book);
        int count = cartService.bookcountByBid(cart.getBid());

        // 如果图书量数量大于0
        if (count > 0) {
            // 怎么添加到书架中
            cart = cartService.oneCartBybid(user.getLuser(), cart.getBid());
//            System.out.println(cart.getBid());
            if (cart == null) {
                // 新增一个书数据
                // 怎么将视图中的值传给，注意从session中取值的方法有两种
                // 如果是session.put----------session.get
                // 如果是ActionContext.getContext().getSession().put

                cartService.addCart(user.getLuser(), bookCart.getBid(), bookCart.getCcount());
                cartService.reBookCount(bookCart.getCcount(), bookCart.getBid());
                // 添加订单信息
                // 插入订单信息UUID 订单号必须唯一 随机产生单号
                Random random = new Random();
                String oname = "" + System.currentTimeMillis() + user.getLuser() + random.nextInt(99);
                borrowService.addOrder(user.getLuser(), oname, bookCart.getCcount(), bookCart.getBid());
                msg = "已成功借书1本";
                reslut.put("msg", msg);
                reslut.put("bookCart", bookCart);
                System.out.println("已成功借书1本");
                return reslut;
            }
            if (cart.getBid() == bookCart.getBid()) {
                // 在原有的商品数据修改上进行数量的修改
                if (cart.getCount() > 0) {
                    cartService.upCartCount(user.getLuser(), bookCart.getBid());
                    cartService.reBookCount(bookCart.getCcount(), bookCart.getBid());
                    // 添加订单信息
                    // 插入订单信息UUID 订单号必须唯一 随机产生单号
                    Random random = new Random();
                    String oname = "" + System.currentTimeMillis() + user.getLuser() + random.nextInt(99);
                    borrowService.addOrder(user.getLuser(), oname, bookCart.getCcount(), bookCart.getBid());
                    msg = "已成功借书1本";
                    reslut.put("msg", msg);
                    reslut.put("bookCart", bookCart);
                    System.out.println("已成功借书1本");
                    return reslut;
                }
            }
        } else {
            System.out.println("添加失败");
            msg = "库存不足，借书失败";
            reslut.put("msg", msg);
            return reslut;
        }
        reslut.put("msg", msg);
        return reslut;
    }

    // 书架中减少图书，到最后为0删除图书，还书
    @RequestMapping("reCartBook")
    @ResponseBody
    public String reCartBook(HttpSession session, Book book, BookCart bookCart) {
//        session.setAttribute("bookCart", bookCart);
//        bookCart = (BookCart) session.getAttribute("bookCart");
//        System.out.println(bookCart + "333333333333333333333");
        LoginUser user = (LoginUser) session.getAttribute("user");
        System.out.println(user + "4444444444444");
        // System.out.println("减少图书");
        String msg = "请联系帅气的管理员";
        int bid = book.getBid();
        int ccount = bookCart.getCcount();
        int count = cartService.cartccountByBid(user.getLuser(), bid);
        System.out.println(count + "555555555555555555533333333");
        // 如果书架中书数量大于0
        if (count > 1) {
            // 书架减少数量1
            cartService.recartcountById(bid);
            // 图书总数量增加1
            cartService.addbookcountById(bid);
            // 添加订单信息
            // 插入订单信息UUID 订单号必须唯一 随机产生单号
            Random random = new Random();
            String oname = "" + System.currentTimeMillis() + user.getLuser() + random.nextInt(99);
            replayService.addOrderre(user.getLuser(), oname, ccount, bid);
            msg = "已成功还书1本";
            return msg;
        }
        if (count == 1 || count < 1) {
            // 书架为1，再减少就是为0，直接删除
            System.out.println(bookCart.getBid());

            // 图书总数量增加1
            cartService.addbookcountById(bookCart.getBid());
            System.out.println("机上-----------------");
            cartService.decartById(bookCart.getBid());
            // 添加订单信息
            // 插入订单信息UUID 订单号必须唯一 随机产生单号
            Random random = new Random();
            String oname = "" + System.currentTimeMillis() + user.getLuser() + random.nextInt(99);
            replayService.addOrderre(user.getLuser(), oname, bookCart.getCcount(), bookCart.getBid());
            System.out.println("还完-----------------");
            msg = "已成功将此书还完";
            System.out.println("wwwwwwwwwwwwwwww");
            return msg;
        }
        return "success";
    }
}
