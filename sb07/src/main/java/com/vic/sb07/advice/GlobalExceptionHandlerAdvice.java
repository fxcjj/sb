package com.vic.sb07.advice;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @author 罗利华
 * date: 2019/5/9 17:50
 */
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    /**
     * 处理方法的单个参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public String resolveConstraintViolationException(ConstraintViolationException e) {
        for(ConstraintViolation<?> s : e.getConstraintViolations()){
            return s.getInvalidValue()+": "+s.getMessage();
        }
        return "请求参数不合法";
    }

    /**
     * 处理方法的bean校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String resolveMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(allErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            allErrors.forEach(error -> msgBuilder.append(error.getDefaultMessage()).append(", "));
            return msgBuilder.toString();
        }
        return "请求参数不合法";
    }

}
