package com.vic.sb38;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 这里 @MapperScan 有两个，一个是org.mybatis包，一个是tk.mybatis包.
 * 当使用到通用mapper时，这里引入要引入 tk.mybatis，否则报错：java.lang.NoSuchMethodException: tk.mybatis.mapper.provider.base.BaseSelectProvider
 */
@MapperScan("com.vic.sb38.mapper")
@SpringBootApplication
public class Sb38Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb38Application.class, args);
    }

}
