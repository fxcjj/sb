package com.vic.sb06.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 * @author 罗利华
 * date: 2019/5/6 15:56
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/cost")
    public String cost() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }



}
