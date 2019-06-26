package com.vic.sb10.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 应用启动后执行，可以用来加载一些数据或实现某些业务逻辑
 * CommandLineRunner在执行时，Spring内部已经启动完成，可以注入Spring的Bean
 * @author 罗利华
 * date: 2019/6/26 11:16
 */
@Component
@Order(1)
public class StartupRunner1 implements CommandLineRunner {

    //这里是可以注入进来的
//    @Autowired
//    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartupRunner1 run, loading data...");
    }

}
