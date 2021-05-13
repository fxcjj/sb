package com.vic.sb44;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.vic.sb44.dao")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Sb44Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb44Application.class, args);
    }

}
