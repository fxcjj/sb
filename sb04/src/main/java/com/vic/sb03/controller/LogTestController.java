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
public class LogTestController {

    @RequestMapping("/test")
    public ResponseResult test(@RequestParam(value="role") Integer role) throws Exception{

        log.info("访问Controller");
        int i = role;

        if(i < 0) {
            throw new PermissionException(ExceptionEnum.WRONG_PERMISSIONS.toString());
        } else{
            return new ResponseResult(ResponseMessage.OK);
        }


    }


}
