package com.vic.sb10.exception;

import com.vic.sb10.enums.ResultEnum;

/**
 * @author Victor
 * date: 2019/6/27 18:59
 */
public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
