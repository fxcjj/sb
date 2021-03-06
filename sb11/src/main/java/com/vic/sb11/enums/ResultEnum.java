package com.vic.sb11.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举类
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS("000", "success"),
    FAIL("111", "fail"),
    LOGIN_ERROR("1", "登录错误"),
    USER_NOT_EXISTS("2", "用户不存在"),
    TOKEN_EMPTY("3", "token为空，请重新登录"),
    TOKEN_EXPIRE("4", "token过期，请重新登录"),
    ;

    String code;
    String msg;

}
