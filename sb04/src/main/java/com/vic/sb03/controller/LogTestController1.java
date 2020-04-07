package com.vic.sb03.controller;

import com.vic.sb03.exception.PermissionException;
import com.vic.sb03.result.ExceptionEnum;
import com.vic.sb03.result.ResponseMessage;
import com.vic.sb03.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor
 * date: 2019/4/28 15:48
 */
@Slf4j
@RestController
public class LogTestController1 {

    @RequestMapping("/test1")
    public String test() {

        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "ok";
    }

    @RequestMapping("/test2")
    public String test2() {
        try {
            int i = 3/0;

        } catch (Exception e) {
            /**
             * 2019-09-08 10:01:58,813 INFO (LogTestController1.java:37)------- id:1, e:{}
             * java.lang.ArithmeticException: / by zero
             * 	at com.vic.sb03.controller.LogTestController1.test2(LogTestController1.java:34)
             * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
             * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
             * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
             */
            log.info("id:{}, e:", 1, e);

            log.error("error:{}", e);
        }
        return "ok";
    }


}
