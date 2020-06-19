package com.vic.sb24.controller;

import com.vic.sb24.annotation.Aop2Inter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop2")
public class Aop2Controller {

    @GetMapping("test1")
    public String test1() {
        System.out.println("Aop2Controller 执行结果...test1");
        return "ok";
    }

    /**
     * 添加了@AopInter注解，对应advice会处理这个方法
     * @return
     */
    @Aop2Inter
    @GetMapping("test2")
    public String test2() {
        System.out.println("Aop2Controller 执行结果...test2");
        return "ok";
    }

}
