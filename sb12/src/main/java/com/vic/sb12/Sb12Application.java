package com.vic.sb12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 开启异步调用
@SpringBootApplication
public class Sb12Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb12Application.class, args);
    }

}
