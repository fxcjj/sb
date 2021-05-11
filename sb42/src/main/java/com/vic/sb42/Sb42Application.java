package com.vic.sb42;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.vic.sb42.dao")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Sb42Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb42Application.class, args);
    }

}
