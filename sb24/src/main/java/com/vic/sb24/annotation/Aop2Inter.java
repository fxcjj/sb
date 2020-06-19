package com.vic.sb24.annotation;

import java.lang.annotation.*;

/**
 * 注解
 * @see com.vic.sb24.aspect.Aop2
 * @author victor
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Aop2Inter {

}
