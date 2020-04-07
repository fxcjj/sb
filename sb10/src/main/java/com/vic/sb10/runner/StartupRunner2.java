package com.vic.sb10.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 应用启动后执行，可以用来加载一些数据或实现某些业务逻辑
 * @author Victor
 * date: 2019/6/26 11:16
 */
@Component
@Order(2)
public class StartupRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartupRunner2 run, loading data...");
    }

}
