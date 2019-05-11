package com.vic.sb07.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 罗利华
 * date: 2019/5/8 13:49
 */
@AllArgsConstructor
public enum StatusCode {

    SUCCESS("0000", "success"),
    FAIL("1", "fail"),

    ;
    String code;
    String msg;

}
