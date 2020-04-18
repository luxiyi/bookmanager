package com.bookmanager.web.controller;

import com.bookmanager.pojo.LoginUser;
import com.bookmanager.pojo.Orderre;
import com.bookmanager.service.ReplayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: java类作用描述ReplayController
 * @Author: lxy
 * @time: 2020/4/16 0:47
 */
@Controller
public class ReplayController {
    private Logger logger = LoggerFactory.getLogger(ReplayController.class);

    @Autowired
    private ReplayService replayService;
    @RequestMapping("showOrderre")
    @ResponseBody
    public List<Orderre> showOrderre(HttpSession session){
        LoginUser user = (LoginUser) session.getAttribute("user");
        System.out.println("查询订单");
        System.out.println(user+"4444444444444");
        System.out.println(user.getLuser());
        List<Orderre> replaies = replayService.findAllOrderre(user.getLuser());
        System.out.println(replaies);
        return replaies;
    }
}
