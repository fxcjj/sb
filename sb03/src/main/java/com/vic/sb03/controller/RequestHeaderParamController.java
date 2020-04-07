package com.vic.sb03.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @RequestHeader注解使用
 * @RequestParam注解使用
 *
 * note/spring/XMapping中headers和params与RequestHeader和RequestParam.txt
 *
 * @author Victor
 * date: 2019/4/16 17:23
 */
@RestController
public class RequestHeaderParamController {

    @PostMapping("t2")
    public String test2(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("name") String name,
            @RequestParam(value = "password", required = false) String password) {

        return "authorization: " + authorization + ", name:" + name + ", password: " + password;
    }

}
