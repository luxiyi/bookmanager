package com.bookmanager.web.controller;

import com.bookmanager.pojo.Book;
import com.bookmanager.pojo.Comment;
import com.bookmanager.pojo.LoginUser;
import com.bookmanager.service.BookService;
import com.bookmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述CommentController
 * @Author: lxy
 * @time: 2020/4/16 0:47
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BookService bookService;

    //展现评论,list不能作为参数
    @RequestMapping("/findComments")
    @ResponseBody
    public List<Comment> findComments(LoginUser user, Book book, HttpSession session){
        List<Comment> comments = commentService.allCommentsById(book.getBid());
        System.out.println(comments);
        return comments;
    }
    //插入评论
    @RequestMapping("/insertComment")
    @ResponseBody
    public String insertComment(String info,LoginUser user,Book book,Comment comment,HttpSession session){
        user=(LoginUser)session.getAttribute("user");
        System.out.println(user);
        if (user == null) {
            info="评价失败，请先登录";
            System.out.println(info);
            return info;
        }else {
            System.out.println(comment.getCcont()+"========================");
            if (comment.getCcont()=="") {
                info="请输入评价";
                return info;
            }else {
                commentService.insertCommentByid(user.getLuser(), book.getBid(), comment.getCcont());
                bookService.updateComcount(book.getBid());
                info="评价成功";
                System.out.println(info);
                return info;
            }

        }



    }
}
