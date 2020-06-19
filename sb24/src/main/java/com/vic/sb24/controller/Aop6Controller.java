package com.vic.sb24.controller;

import com.vic.sb24.domain.bo.UserBo;
import org.springframework.web.bind.annotation.*;

/**
 * 测试@within
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop6")
public class Aop6Controller {

    @GetMapping("test1")
    public String test1(String name, Integer age) {
        System.out.println("Aop6Controller 执行 --> name: " + name + ", age: " + age);
        return "aop6 test1 ok";
    }

    @PostMapping("test2")
    public String test2(@RequestBody UserBo userBo) {
        System.out.println("Aop6Controller 执行 --> userBo: " + userBo);
        return "aop6 test2 ok";
    }

}
