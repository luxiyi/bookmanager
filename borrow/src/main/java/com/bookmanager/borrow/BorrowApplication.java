package com.bookmanager.borrow;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:borrow-provider.xml"})
@MapperScan("com.bookmanager.borrow.dao")
public class BorrowApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(BorrowApplication.class);
        SpringApplication.run(BorrowApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
