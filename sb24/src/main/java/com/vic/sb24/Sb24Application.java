package com.vic.sb24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Sb24Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb24Application.class, args);
    }

}
