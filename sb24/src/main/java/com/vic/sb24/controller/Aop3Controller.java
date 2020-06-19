package com.vic.sb24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop3")
public class Aop3Controller {

    @GetMapping("test1")
    public String test1() {
        System.out.println("Aop3Controller 执行结果...test1");
        // 当这里打开时，且@Around中未catch异常，那么@AfterThrowing方法就会执行
//        int a = 1/0;
        return "aop3 ok";
    }

}
