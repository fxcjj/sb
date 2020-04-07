package com.vic.sb07.exception;

/**
 * 服务异常
 * @author Victor
 * date: 2019/5/11 14:48
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
