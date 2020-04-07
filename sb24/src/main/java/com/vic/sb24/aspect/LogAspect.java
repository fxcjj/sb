package com.vic.sb24.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *
 * @author 罗利华
 * date: 2020/3/30 15:19
 */
@Slf4j
@Aspect
//@Component
public class LogAspect {

    /**
     * 切入方法表达式常量
     */
    private final String POINT_CUT = "execution(public * com.vic.sb24.controller.*.*(..))";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 切入方法
     */
    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("@Before通知执行");
        //获取目标方法参数信息
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg->{ // 大大
            try {
                log.info(OBJECT_MAPPER.writeValueAsString(arg));
            } catch (JsonProcessingException e) {
                log.info(arg.toString());
            }
        });


//aop代理对象
        Object aThis = joinPoint.getThis();
        log.info(aThis.toString()); //com.xhx.springboot.controller.HelloController@69fbbcdd

//被代理对象
        Object target = joinPoint.getTarget();
        log.info(target.toString()); //com.xhx.springboot.controller.HelloController@69fbbcdd

//获取连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
        log.info(signature.toLongString()); //public java.lang.String com.xhx.springboot.controller.HelloController.getName(java.lang.String)
        log.info(signature.toShortString()); //HelloController.getName(..)
        log.info(signature.toString()); //String com.xhx.springboot.controller.HelloController.getName(String)
//获取方法名
        log.info(signature.getName()); //getName
//获取声明类型名
        log.info(signature.getDeclaringTypeName()); //com.xhx.springboot.controller.HelloController
//获取声明类型 方法所在类的class对象
        log.info(signature.getDeclaringType().toString()); //class com.xhx.springboot.controller.HelloController
//和getDeclaringTypeName()一样
        log.info(signature.getDeclaringType().getName());//com.xhx.springboot.controller.HelloController

//连接点类型
        String kind = joinPoint.getKind();
        log.info(kind);//method-execution

//返回连接点方法所在类文件中的位置 打印报异常
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        log.info(sourceLocation.toString());
//log.info(sourceLocation.getFileName());
//log.info(sourceLocation.getLine()+"");
//log.info(sourceLocation.getWithinType().toString()); //class com.xhx.springboot.controller.HelloController

///返回连接点静态部分
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        log.info(staticPart.toLongString()); //execution(public java.lang.String com.xhx.springboot.controller.HelloController.getName(java.lang.String))


//attributes可以获取request信息 session信息等
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info(request.getRequestURL().toString()); //http://127.0.0.1:8080/hello/getName
        log.info(request.getRemoteAddr()); //127.0.0.1
        log.info(request.getMethod()); //GET

        log.info("before通知执行结束");
    }

}
