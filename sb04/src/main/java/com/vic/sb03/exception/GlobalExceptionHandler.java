package com.vic.sb03.exception;

import com.vic.sb03.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Victor
 * date: 2019/4/25 19:24
 */
@CrossOrigin
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseResult processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        if(ex instanceof MissingServletRequestParameterException) {
            return new ResponseResult(400, ex);
        }

        if(ex instanceof PermissionException) {
            log.error("=======" + ex.getMessage() + "=================");
            return new ResponseResult(401, "sorry, no privilege");
        }

        /*if(ex instanceof DuplicateKeyException) {
            log.error("violation unique constrains");
        }*/

        log.error(ex.toString());
        return new ResponseResult(500, ex.getMessage());
    }
}
