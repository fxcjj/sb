package com.vic.sb11.resp;

import com.vic.sb11.enums.ResultEnum;
import lombok.Data;

/**
 * @author 罗利华
 * date: 2019/4/28 15:47
 */
@Data
public class ResponseResult {

    String code;
    String msg;
    Object data;

    public ResponseResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResponseResult(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResponseResult(String code, Exception ex) {
        this(code, ex.getMessage());
    }

    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
