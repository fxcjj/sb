package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 在@Around方法中catch异常后，处理返回结果
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
@Component
public class Aop4 {

    /**
     * 公用point cut
     */
    @Pointcut("execution(* com.vic.sb24.controller.Aop4*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Aop4 before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Aop4 after...");
    }

    /**
     * 在@After之后执行
     * 如果连接点方法出现异常，则@AfterReturning方法不执行
     * @param jp 连接信息
     * @param result 返回的结果
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        /**
         * 1. 当controller中方法未发生异常时，打印如下：
         * Aop4 afterReturning --> methodName: test1, args: [], result: aop4 ok
         *
         * 2. 当controller中方法发生异常时且在@Around方法中catch时，打印如下：
         * Aop4 afterReturning --> methodName: test1, args: [], result: exception
         */
        System.out.println("Aop4 afterReturning --> methodName: " + name + ", args: " + args + ", result: " + result);
    }

    /**
     * @Around方法中catch了异常，所以这个方法不会执行
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        /**
         * 打印结果：
         * Aop4 afterThrowing --> methodName: test1, args: [], errorMsg: / by zero
         */
        System.out.println("Aop4 afterThrowing --> methodName: " + name + ", args: " + args + ", errorMsg: " + e.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("Aop4 around before...");
        Object o = null;
        // 如果这时catch异常，那么@AfterThrowing方法不会执行
        try {
            // 调用实际方法
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            // 对结果包装
            o = "exception";
        }
        System.out.println("Aop4 around after...");
        return o;
    }

}
