package com.vic.sb24.aspect;

import com.vic.sb24.annotation.ChargingApi;
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
public class Aop11 {

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

//    @Before("pointCut()")
//    public void before() {
//        System.out.println("Aop11 before...");
//    }

//    @After("pointCut()")
//    public void after(){
//        System.out.println("Aop11 after...");
//    }

    @Around("pointCut() && @annotation(chargingApi)")
    public Object around(ProceedingJoinPoint joinPoint, ChargingApi chargingApi) throws Throwable {
        System.out.println("Aop11 around before..." + chargingApi);
        // 执行完成目标方法
        Object result = joinPoint.proceed();
        System.out.println("Aop11 around after...");
        try {
//            int a = 34/0;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

}
