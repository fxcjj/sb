package com.vic.sb43;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.vic.sb43.dao")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Sb43Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb43Application.class, args);
    }

}
