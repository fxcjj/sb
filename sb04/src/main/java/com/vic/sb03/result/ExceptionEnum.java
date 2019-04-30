package com.vic.sb03.result;

import lombok.AllArgsConstructor;

/**
 * @author 罗利华
 * date: 2019/4/28 15:47
 */
@AllArgsConstructor
public enum ExceptionEnum {

    WRONG_PERMISSIONS("no auth");

    private String value;

}
