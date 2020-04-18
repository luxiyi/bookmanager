package com.bookmanager.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.bookmanager.user.dao")
@ImportResource({"classpath:user-provide.xml"})
public class UserApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(UserApplication.class);
        SpringApplication.run(UserApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
