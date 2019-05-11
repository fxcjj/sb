package com.vic.sb07.advice;

import com.vic.sb07.vo.ErrorMsgVo;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
//@Component
public class ExceptionHandlerContrller {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<ErrorMsgVo> exception(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<ErrorMsgVo> errorMsgs = new ArrayList<>();

        allErrors.forEach(objectError -> {
            ErrorMsgVo errorMsg = new ErrorMsgVo();
            FieldError fieldError = (FieldError)objectError;
            errorMsg.setField(fieldError.getField());
            errorMsg.setObjectName(fieldError.getObjectName());
            errorMsg.setMessage(fieldError.getDefaultMessage());
            errorMsgs.add(errorMsg);
        });
        return errorMsgs;
    }
}