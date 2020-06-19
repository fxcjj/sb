package com.vic.sb24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop1")
public class Aop1Controller {

    @GetMapping("test1")
    public String test1() {
        System.out.println("Aop1Controller 执行结果...test1");
        return "ok";
    }

}
