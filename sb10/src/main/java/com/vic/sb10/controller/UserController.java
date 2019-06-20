package com.vic.sb10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2019/5/22 16:23
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("hi")
    public String test() {
        return "ok";
    }

}
