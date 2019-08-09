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
 * @author 罗利华
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
            log.error("error:{}", e);
        }
        return "ok";
    }


}
