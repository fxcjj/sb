package com.vic.sb11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 开启异步调用
@SpringBootApplication
public class Sb11Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb11Application.class, args);
    }

}
