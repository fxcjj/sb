package com.vic.sb24.controller;

import com.vic.sb24.domain.bo.UserBo;
import org.springframework.web.bind.annotation.*;

/**
 * 目标方法的参数信息
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@RestController
@RequestMapping("aop5")
public class Aop5Controller {

    @GetMapping("getUser")
    public String getUser(String name, Integer age, String address) {
        System.out.println("Aop5Controller 执行 --> name: " + name + ", age: " + age + ", address: " + address);
        return "aop5 getUser ok";
    }

    @PostMapping("saveUser")
    public String saveUser(@RequestBody UserBo userBo) {
        System.out.println("Aop5Controller 执行 --> userBo: " + userBo);
        return "aop5 saveUser ok";
    }

}
