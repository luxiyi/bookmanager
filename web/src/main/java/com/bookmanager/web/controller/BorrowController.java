package com.bookmanager.web.controller;

import com.bookmanager.pojo.LoginUser;
import com.bookmanager.pojo.Order;
import com.bookmanager.service.BorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: java类作用描述BorrowController
 * @Author: lxy
 * @time: 2020/4/16 0:47
 */
@SuppressWarnings("all")
@Controller
public class BorrowController {
    private Logger logger = LoggerFactory.getLogger(BorrowController.class);
    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "/order")
    public String order() {
        logger.info("----------order----------");
        return "order";
    }
    @RequestMapping(value = "/showOrder")
    @ResponseBody
    public List<Order> showOrder(HttpSession session){
        System.out.println("查询订单");
        //session.put("bookCart", bookCart);
        //bookCart = (BookCart) session.get("bookCart");
        //System.out.println(bookCart+"333333333333333333333");
        LoginUser user = (LoginUser) session.getAttribute("user");
        System.out.println(user+"4444444444444");
        System.out.println(user.getLuser());
        List<Order> borrows = borrowService.findAllOrder(user.getLuser());
        System.out.println(borrows);
        return borrows;
    }

}
