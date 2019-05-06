package com.vic.sb05.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2019/5/5 15:56
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${env}")
    private String env;

    @RequestMapping("/env")
    public String env() {
        return "profile: " + env;
    }



}
