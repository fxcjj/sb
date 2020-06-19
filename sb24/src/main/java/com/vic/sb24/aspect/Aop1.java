package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 简单使用@Before,@After,@Around
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
@Component
public class Aop1 {

    /**
     * 打印结果：
     * Aop1 around before...
     * Aop1 before...
     * Aop1Controller 执行结果...test1
     * Aop1 around after...
     * Aop1 after...
     */

    private final String POINT_CUT = "execution(* com.vic.sb24.controller.Aop1*.*(..))";

    /**
     * 公用point cut
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Aop1 before...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("Aop1 after...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aop1 around before...");
        // 执行完成目标方法
        Object result = joinPoint.proceed();
        System.out.println("Aop1 around after...");
        return result;
    }

}
