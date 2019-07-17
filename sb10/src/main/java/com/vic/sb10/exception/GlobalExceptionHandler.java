package com.vic.sb10.exception;

import com.vic.sb10.resp.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 罗利华
 * date: 2019/6/27 19:24
 */
@CrossOrigin
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseResult processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        if(ex instanceof BusinessException) {
            return new ResponseResult(((BusinessException)ex).getCode(), ex.getMessage());
        }

        return new ResponseResult("error", ex.getMessage());
    }
}
