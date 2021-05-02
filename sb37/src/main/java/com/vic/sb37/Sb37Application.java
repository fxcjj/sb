package com.vic.sb37;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * XXXMapper类上加 @Mapper
 * 或者
 * 启动类上加 @MapperScan("com.vic.sb37.mapper")，表示要扫描的包
 */
@MapperScan("com.vic.sb37.mapper")
@SpringBootApplication
public class Sb37Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb37Application.class, args);
    }

}
