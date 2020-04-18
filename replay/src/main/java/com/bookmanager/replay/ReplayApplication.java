package com.bookmanager.replay;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.bookmanager.replay.dao")
@ImportResource({"classpath:replay-provider.xml"})
public class ReplayApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ReplayApplication.class);
        SpringApplication.run(ReplayApplication.class, args);
        logger.info("服务端启动成功！！！");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
