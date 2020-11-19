package com.vic.sb03.controller;

import com.vic.sb03.conf.ConfigBean;
import com.vic.sb03.conf.Shaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
//@Controller
@RequestMapping("test")
public class TestController {

    @Value("${agnostic:xxx}")
    private String agnostic;

    @Autowired
    ConfigBean configBean;

    @Autowired
    Shaver shaver;

    /**
     * 测试默认值
     * @return
     */
    @GetMapping("dv")
    public String dv() {
        return agnostic;
    }

    @RequestMapping("config")
    public ConfigBean config() {
        return configBean;
    }

    @RequestMapping("shaver")
    public Shaver shaver() {
        return shaver;
    }

}
