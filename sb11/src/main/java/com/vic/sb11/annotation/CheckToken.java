package com.vic.sb11.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录校验
 * 标记在类上，拦截所有的方法
 * 标记在方法上，拦截所标记的方法
 * @author 罗利华
 * date: 2019/7/21 12:00
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {

//    boolean required() default true;

}