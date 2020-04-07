package com.vic.sb05.controller;

import com.vic.sb05.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor
 * date: 2019/5/5 15:56
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${env}")
    private String env;

    @Autowired
    private TestConfig testConfig;

    @RequestMapping("/name")
    public String name() {
        return "victor name: " + testConfig.getName();
    }

    @RequestMapping("/env")
    public String env() {
        return "profile: " + env;
    }


    @GetMapping("test1")
    public String test1() {
        return "test1";
    }


    @GetMapping("test2")
    public String test2() {
        return "test2";
    }



}
