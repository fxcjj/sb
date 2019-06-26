package com.vic.sb03.controller;

import com.vic.sb03.conf.ConfigBean;
import com.vic.sb03.conf.Shaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${agnostic:xxx}")
    private String agnostic;

    @Value("${api.enable:false}")
    private Boolean apiSwitch;

    @Value("${api.version:1.0}")
    private String version;

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
        return agnostic + ", " + apiSwitch + ", " + version;
    }

    @RequestMapping("/agnostic")
    public String agnostic() {
        return agnostic;
    }

    @RequestMapping("/config")
    public String config() {
        return configBean.getName() + configBean.getWant() + ", " + configBean.getHobby() + ", " + configBean.getPriceMap();
    }

    @RequestMapping("/shaver")
    public String shaver() {
        return shaver.getName() + ", " + shaver.getSize();
    }

}
