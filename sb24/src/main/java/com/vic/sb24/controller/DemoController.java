package com.vic.sb24.controller;

import com.vic.sb24.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2019/8/19 14:57
 */
@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {

    /**
     * 简单方法示例
     * @param hello
     * @return
     */
    @RequestMapping("aop")
    @Log(value="请求了aopDemo方法")
    public String aopDemo(String hello) {
        return "请求参数为：" + hello;
    }

    /**
     * 不拦截日志示例
     * @param hello
     * @return
     */
    @RequestMapping("notaop")
    @Log(ignore=true)
    public String notAopDemo(String hello) {
        return "此方法不记录日志，请求参数为：" + hello;
    }

}
