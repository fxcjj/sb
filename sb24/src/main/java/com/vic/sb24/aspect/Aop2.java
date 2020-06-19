package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用@annotaion指定注解，advice只作用于指定的注解
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
@Component
public class Aop2 {

    private final String POINT_CUT = "@annotation(com.vic.sb24.annotation.Aop2Inter)";

    /**
     * 公用point cut
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    /**
     * 该advice作用于有 @Aop2Inter 注释的方法
     */
//    @Before("@annotation(com.vic.sb24.annotation.Aop2Inter)")
    @Before("pointCut()")
    public void before() {
        System.out.println("before...");
    }

}
