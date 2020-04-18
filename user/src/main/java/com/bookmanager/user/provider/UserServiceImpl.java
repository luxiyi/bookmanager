package com.bookmanager.user.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.bookmanager.pojo.LoginUser;
import com.bookmanager.pojo.User;
import com.bookmanager.service.UserService;

import com.bookmanager.user.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Description: java类作用描述UserProvider
 * @Author: lxy
 * @time: 2020/4/7 0:35
 */
@SuppressWarnings("all")
@Component
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUser findRootByluser(LoginUser loginuser) {
        return userMapper.findRootByluser(loginuser);
    }

    @Override
    public LoginUser findLoginByluser(LoginUser loginuser) {
        return userMapper.findLoginByluser(loginuser);
    }

    @Override
    public void updateData(LoginUser loginuser) {
        userMapper.updateData(loginuser);
    }

    @Override
    public void insertUser(String luser) {
        userMapper.insertUser(luser);
    }

    @Override
    public User findUserByluser(String userinfo) {
        return userMapper.findUserByluser(userinfo);
    }

    @Override
    public void updateUser(User userinfo) {
        userMapper.updateUser(userinfo);
    }

    @Override
    public void updataUsericon(String usericon, String luser) {
        userMapper.updataUsericon(usericon, luser);
    }

    @Override
    public LoginUser testUser(String luser) {
        return userMapper.testuser(luser);
    }

}
