package com.vic.sb35;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vic.sb35.mapper") //扫描的mapper
@SpringBootApplication
public class Sb35Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb35Application.class, args);
    }

}
