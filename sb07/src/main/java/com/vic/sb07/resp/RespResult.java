package com.vic.sb07.resp;

import lombok.Data;

/**
 * 响应结果
 * @author Victor
 * date: 2019/5/8 13:46
 */
@Data
public class RespResult<T> {

    private RespResult() {
        //nope
    }

    private String code;
    private String msg;
    private T data;

}
