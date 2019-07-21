package com.vic.sb11.exception;


import com.vic.sb11.enums.ResultEnum;

/**
 * @author 罗利华
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
