package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 测试 @Before,@After,@Around
 * 测试 @AfterReturning, @AfterThrowing
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
@Component
public class Aop3 {

    /**
     * 公用point cut
     */
    @Pointcut("execution(* com.vic.sb24.controller.Aop3*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Aop3 before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Aop3 after...");
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
         * 打印结果：
         * Aop3 afterReturning --> methodName: test1, args: [], result: aop3 ok
         */
        System.out.println("Aop3 afterReturning --> methodName: " + name + ", args: " + args + ", result: " + result);
    }

    /**
     * 当方法发生异常时执行，注意：如果@Around，在方法中不要catch，要抛出去，否则这里接收不到
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        String name = jp.getSignature().getName();
        List<Object> args = Arrays.asList(jp.getArgs());
        /**
         * 打印结果：
         * Aop3 afterThrowing --> methodName: test1, args: [], errorMsg: / by zero
         */
        System.out.println("Aop3 afterThrowing --> methodName: " + name + ", args: " + args + ", errorMsg: " + e.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aop3 around before...");
        // 如果这时catch异常，那么@AfterThrowing方法不会执行
        Object o = pjp.proceed();
        System.out.println("Aop3 around after...");
        return o;
    }

}
