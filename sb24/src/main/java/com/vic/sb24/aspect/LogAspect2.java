package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 罗利华
 * date: 2020/3/30 16:04
 */
@Slf4j
@Aspect
//@Component
public class LogAspect2 {

    @Pointcut("execution(* com.vic.sb24.controller..*.*(..))")
    public void init(){
    }

    @Before(value="init()")
    public void before(){
        System.out.println("方法执行前执行.....");
    }

    @AfterReturning(value="init()")
    public void afterReturning(){
        System.out.println("方法执行完执行.....");
    }

    @AfterThrowing(value="init()")
    public void throwss(){
        System.out.println("方法异常时执行.....");
    }

    @After(value="init()")
    public void after(){
        System.out.println("方法最后执行.....");
    }

    @Around(value="init()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("方法环绕start.....");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("方法环绕end.....");
        return o;
    }
}
