package com.vic.sb24.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 日志注解类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {

    /**
     * 描述
     * @return
     */
    @AliasFor("desc")
    String value() default "";

    @AliasFor("value")
    String desc() default "";

    /**
     * 是否忽略
     * @return
     */
    boolean ignore() default false;

}
