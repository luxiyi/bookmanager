package com.bookmanager.web.controller;

import com.bookmanager.pojo.LoginUser;
import com.bookmanager.pojo.Order;
import com.bookmanager.service.BorrowService;
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
@Controller
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @RequestMapping(value = "/showOrder")
    @ResponseBody
    public String showOrder(HttpSession session, LoginUser user, List<Order> borrows){
        System.out.println("查询订单");
        //session.put("bookCart", bookCart);
        //bookCart = (BookCart) session.get("bookCart");
        //System.out.println(bookCart+"333333333333333333333");
        user = (LoginUser) session.getAttribute("user");
        System.out.println(user+"4444444444444");
        System.out.println(user.getLuser());
        borrows=borrowService.findAllOrder(user.getLuser());
        System.out.println(borrows);
        return "success";
    }

}
