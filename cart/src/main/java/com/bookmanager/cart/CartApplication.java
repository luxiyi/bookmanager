package com.bookmanager.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.bookmanager.cart.dao")
@ImportResource({"classpath:cart-provider.xml"})
public class CartApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CartApplication.class);
        SpringApplication.run(CartApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
