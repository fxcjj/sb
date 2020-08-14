package com.vic.sb24.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * within用法
 * 用于匹配所以持有指定注解类型内的方法
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
//@Component
public class Aop6 {

    /**
     * 设置切入点：这里直接拦截被@RestController注解的类
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("Aop6 before start...");

        // 利用RequestContextHolder获取request对象
        ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String uri = requestAttr.getRequest().getRequestURI();

        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 访问目标方法的参数 可动态改变参数值
        Object[] args = joinPoint.getArgs();

        /**
         * 1. get请求url：
         * http://localhost:1267/aop6/test1?name=victor&age=21
         *
         * 打印结果：
         * Aop6 before uri:/aop6/test1, methodName:test1, args:[victor, 21]
         *
         * 2. post请求url：
         * http://localhost:1267/aop6/test2
         *
         * 打印结果：
         * Aop6 before uri:/aop6/test2, methodName:test2, args:[UserBo(name=victor, age=21, address=china)]
         */
        log.info("Aop6 before uri:{}, methodName:{}, args:{}", uri, methodName, Arrays.toString(args));

        log.info("Aop6 before end...");
    }

}
