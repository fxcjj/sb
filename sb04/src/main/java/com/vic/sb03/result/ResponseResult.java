package com.vic.sb03.result;

import lombok.Data;

/**
 * @author 罗利华
 * date: 2019/4/28 15:47
 */
@Data
public class ResponseResult {

    int code;
    String msg;
    Object data;

    public ResponseResult(ResponseMessage responseMessage) {
        this.code = responseMessage.code;
        this.msg = responseMessage.msg;
    }

    public ResponseResult(int code, Exception ex) {
        this(code, ex.getMessage());
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
