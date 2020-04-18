package com.bookmanager.book;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:book-provider.xml"})
@MapperScan("com.bookmanager.book.dao")
public class BookApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(BookApplication.class);
        SpringApplication.run(BookApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
