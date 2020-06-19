package com.vic.sb24.controller;

import com.vic.sb24.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor
 * date: 2019/8/19 14:57
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LogController {

    /**
     * 简单方法示例
     * @param hello
     * @return
     */
    @GetMapping("test1")
    @MyLog(value = "test1方法")
    public String test1(String hello) {
        return "请求参数为：" + hello;
    }

    /**
     * 不拦截日志示例
     * @param hello
     * @return
     */
    @GetMapping("test2")
    @MyLog(ignore = true)
    public String test2(String hello) {
        return "此方法不记录日志，请求参数为：" + hello;
    }

}
