package com.vic.sb10.controller;

import com.vic.sb10.enums.ResultEnum;
import com.vic.sb10.resp.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor
 * date: 2019/5/22 16:23
 */
@RestController
public class BaseController {

    public ResponseResult success(String data) {
        return new ResponseResult(ResultEnum.SUCCESS, data);
    }

    public ResponseResult fail(String data) {
        return new ResponseResult(ResultEnum.FAIL, data);
    }

}
