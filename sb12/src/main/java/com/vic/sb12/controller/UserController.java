package com.vic.sb12.controller;

import com.vic.sb12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * 用户控制器
 * @author Victor
 * date: 2019/5/22 16:23
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 异步方式
     * @return
     */
    @RequestMapping("async")
    public String sway() {
        System.out.println("1 Start sway");

        /**
         * 可以
         */
        userService.sendSms();

        /**
         * 不可以
         */
//        hello();

        System.out.println("4 End sway");
        return "sway";
    }

    @Async
    public void hello() {
        System.out.println("2 Start hello");
        IntStream.range(0, 5).forEach(d -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("3 End hello");
    }


}
