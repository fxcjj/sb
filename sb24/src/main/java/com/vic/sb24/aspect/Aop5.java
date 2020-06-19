package com.vic.sb24.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 目标方法的参数信息
 *
 * @author 罗利华
 * date: 2020/6/19 10:35
 */
@Slf4j
@Aspect
@Component
public class Aop5 {

    /**
     * json格式打印
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 公用point cut
     */
    @Pointcut("execution(* com.vic.sb24.controller.Aop5*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("Aop5 before start...");

        // 获取目标方法参数信息
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> {
            // json格式打印
            try {
                // {"name":"victor","age":21,"address":"china"}
                log.info(OBJECT_MAPPER.writeValueAsString(arg));
            } catch (JsonProcessingException e) {
                log.info(arg.toString());
            }
        });

        // aop代理对象
        Object aThis = joinPoint.getThis();
        // com.vic.sb24.controller.Aop5Controller@b548f51
        log.info(aThis.toString());

        // 被代理对象
        Object target = joinPoint.getTarget();
        // com.vic.sb24.controller.Aop5Controller@b548f51
        log.info(target.toString());

        // 获取连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
        // public java.lang.String com.vic.sb24.controller.Aop5Controller.saveUser(com.vic.sb24.domain.bo.UserBo)
        log.info(signature.toLongString());
        // Aop5Controller.saveUser(..)
        log.info(signature.toShortString());
        // String com.vic.sb24.controller.Aop5Controller.saveUser(UserBo)
        log.info(signature.toString());

        // 获取方法名
        log.info(signature.getName()); // saveUser
        // 获取声明类型名
        log.info(signature.getDeclaringTypeName()); //com.vic.sb24.controller.Aop5Controller
        // 获取声明类型 方法所在类的class对象
        log.info(signature.getDeclaringType().toString()); //class com.vic.sb24.controller.Aop5Controller
        // 和getDeclaringTypeName()一样
        log.info(signature.getDeclaringType().getName()); //com.vic.sb24.controller.Aop5Controller

        //连接点类型
        String kind = joinPoint.getKind();
        log.info(kind); // method-execution

        // 返回连接点方法所在类文件中的位置
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        // org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@b206d57
        log.info(sourceLocation.toString());
        //log.info(sourceLocation.getFileName());
        //log.info(sourceLocation.getLine()+"");
        //log.info(sourceLocation.getWithinType().toString()); //class com.xhx.springboot.controller.HelloController

        // 返回连接点静态部分
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        // execution(public java.lang.String com.vic.sb24.controller.Aop5Controller.saveUser(com.vic.sb24.domain.bo.UserBo))
        log.info(staticPart.toLongString()); //execution(public java.lang.String com.xhx.springboot.controller.HelloController.getName(java.lang.String))

        // attributes可以获取request信息 session信息等
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // http://localhost:1267/aop5/saveUser
        log.info(request.getRequestURL().toString());
        // 0:0:0:0:0:0:0:1
        log.info(request.getRemoteAddr());
        // POST
        log.info(request.getMethod());

        log.info("Aop5 before end...");
    }

}
