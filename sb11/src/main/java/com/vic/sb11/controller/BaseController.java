package com.vic.sb11.controller;

import com.vic.sb11.enums.ResultEnum;
import com.vic.sb11.resp.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
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
