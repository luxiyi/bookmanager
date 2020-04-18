package com.bookmanager.comment;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:comment-provider.xml"})
@MapperScan("com.bookmanager.comment.dao")
public class CommentApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CommentApplication.class);
        SpringApplication.run(CommentApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
