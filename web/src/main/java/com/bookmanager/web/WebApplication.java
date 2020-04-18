package com.bookmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:consumer.xml")
public class WebApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(WebApplication.class);
        SpringApplication.run(WebApplication.class, args);
        logger.info("消费端启动成功！！！");
    }

}
