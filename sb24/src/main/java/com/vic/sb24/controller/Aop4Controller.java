package com.vic.sb24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop4")
public class Aop4Controller {

    @GetMapping("test1")
    public String test1() {
        System.out.println("Aop4Controller 执行结果...test1");
        int a = 1/0;
        return "aop4 ok";
    }

}
