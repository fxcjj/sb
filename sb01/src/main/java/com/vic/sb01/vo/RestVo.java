package com.vic.sb01.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

public class RestVo<T> implements Serializable {

    private static final long serialVersionUID = -5668554152671000203L;

    private String code;

    private String mesg;

    private boolean flag = true;

    private T data;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date time = new Date();

    public RestVo() {
        RestMsg result = RestMsg.SUCCESS;
        this.code = result.getCode();
        this.mesg = result.getText();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        RestMsg result = RestMsg.getByCode(code);
        this.code = code;
        this.mesg = result.getText();
        if (StringUtils.isBlank(this.code) || !RestMsg.SUCCESS.getCode().equals(this.code)) {
            this.flag = false;
        }
    }

    public void setCode(RestMsg result) {
        this.code = result.getCode();
        this.mesg = result.getText();
        if (StringUtils.isBlank(this.code) || !RestMsg.SUCCESS.getCode().equals(this.code)) {
            this.flag = false;
        }
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getNow() {
        return time;
    }

    public static <T> RestVo<T> success() {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        return restVo;
    }

    public static <T> RestVo<T> success(T obj) {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        restVo.setData(obj);
        return restVo;
    }

    public static <T> RestVo<T> success(T obj, String msg) {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setCode(result.getCode());
        restVo.setMesg(msg);
        restVo.setData(obj);
        return restVo;
    }


    public static <T> RestVo<T> FAIL() {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(String msg) {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setCode(result.getCode());
        restVo.setMesg(msg);
        restVo.setFlag(false);
        return restVo;
    }


    public static <T> RestVo<T> FAIL(RestMsg result) {
        RestVo<T> restVo = new RestVo<>();
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(String code, String msg) {
        RestVo<T> restVo = new RestVo<>();
        if (StringUtils.isBlank(code)) {
            code = RestMsg.FAIL.getCode();
        }
        restVo.code = code;
        restVo.mesg = msg;
        restVo.flag = false;
        return restVo;
    }

    public static <T> RestVo<T> FAIL(RestMsg result, String msg) {
        RestVo<T> restVo = new RestVo<>();
        restVo.setCode(result.getCode());
        restVo.setMesg(msg);
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(T obj) {
        RestVo<T> restVo = new RestVo<>();
        restVo.setData(obj);
        RestMsg result = RestMsg.FAIL;
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(T obj, RestMsg result) {
        RestVo<T> restVo = new RestVo<>();
        restVo.setCode(result.getCode());
        restVo.setMesg(result.getText());
        restVo.setData(obj);
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(T obj, String msg) {
        RestVo<T> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setCode(result.getCode());
        restVo.setMesg(msg);
        restVo.setData(obj);
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> FAIL(RestMsg result, Object... arguments) {
        RestVo<T> restVo = new RestVo<>();
        restVo.setCode(result.getCode());
        restVo.setMesg(MessageFormat.format(result.getText(), arguments));
        restVo.setFlag(false);
        return restVo;
    }

    public static <T> RestVo<T> ERROR() {
        RestVo<T> restVo = new RestVo<>();
        restVo.setCode(RestMsg.ERROR.getCode());
        restVo.setMesg(RestMsg.ERROR.getText());
        return restVo;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isSuccess() {
        return flag;
    }

    public static boolean checkSuccess(RestVo restVo) {
        return restVo != null && RestMsg.SUCCESS.getCode().equals(restVo.getCode());
    }
}
