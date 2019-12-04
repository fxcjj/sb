package com.vic.sb22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Sb22Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb22Application.class, args);
    }

}
