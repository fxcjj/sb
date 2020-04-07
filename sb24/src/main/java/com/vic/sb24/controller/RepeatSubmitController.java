package com.vic.sb24.controller;

import com.vic.sb24.annotation.CheckRepeatSubmit;
import com.vic.sb24.out.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor
 * date: 2020/3/30 16:42
 */
@Slf4j
@RestController
@RequestMapping("repeat")
public class RepeatSubmitController {

    @CheckRepeatSubmit
    @GetMapping("test1")
    public ApiResult test1(String a) {
        System.out.println("test1 method");
        return ApiResult.ok();
    }
}
