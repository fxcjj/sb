package com.vic.sb24.annotation;

import java.lang.annotation.*;

/**
 * 收费注解
 * @author 罗利华
 * date: 2020/6/18 18:05
 */
@Inherited
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ChargingApi {

    /**
     * 额外信息
     * @return
     */
    String extraInfo() default "";

    /**
     * 是否忽略
     * @return
     */
    boolean ignore() default false;

}
