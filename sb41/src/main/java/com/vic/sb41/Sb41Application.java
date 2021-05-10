package com.vic.sb41;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vic.sb41.dao")
@SpringBootApplication
public class Sb41Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb41Application.class, args);
    }

}
