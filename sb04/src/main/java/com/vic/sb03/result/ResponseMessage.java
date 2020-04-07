package com.vic.sb03.result;

import lombok.AllArgsConstructor;

/**
 * @author Victor
 * date: 2019/4/28 15:47
 */
@AllArgsConstructor
public enum ResponseMessage {

    OK(0, "ok");

    int code;
    String msg;




}
