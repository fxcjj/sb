package com.vic.sb24.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/3/30 15:22
 */
@Slf4j
@RestController
@RequestMapping("log1")
public class Log1Controller {

    @GetMapping("test1")
    public String test1(String a) {
        System.out.println("test1 method");
        if(a == null)
            throw new RuntimeException("xxxx");
        return "test1";
    }

}
