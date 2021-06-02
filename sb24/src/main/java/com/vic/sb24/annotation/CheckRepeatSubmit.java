package com.vic.sb24.annotation;

import java.lang.annotation.*;

/**
 * 校验重复提交
 * @author Victor
 * date: 2020/3/30 16:16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckRepeatSubmit {

    /**
     * N秒内判定为重复提交，默认3秒内
     */
    int delaySeconds() default 3;
}
