package com.vic.sb07.advice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author 罗利华
 * date: 2019/5/9 17:50
 */
@ControllerAdvice
//@Component
public class GlobalExceptionHandlerAdvice {

//    @ExceptionHandler(ConstraintViolationException.class)
    public String paramException(HttpServletRequest request, ConstraintViolationException e) {

        StringBuffer sb = new StringBuffer();


        return "ok";
    }

}
