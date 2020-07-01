package com.vic.sb24.aspect;

import com.alibaba.fastjson.JSON;
import com.vic.sb24.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志切面
 * @author Victor
 * date: 2019/8/19 14:39
 */
@Slf4j
@Aspect
@Component
public class MyLogAspect {

    /**
     * controller层所有加了@MyLog注解的方法
     * 切面方法,记录日志
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.vic.sb24.controller.*.*(..)) && @annotation(myLog)")
    public Object doAround(ProceedingJoinPoint joinPoint, MyLog myLog) throws Throwable {
        // 开始时间
        long beginTime = System.currentTimeMillis();

        // 利用RequestContextHolder获取requst对象
        ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String uri = requestAttr.getRequest().getRequestURI();

        log.info("开始计时: {}  URI: {}", new Date(), uri);

        // 访问目标方法的参数 可动态改变参数值
        // 参数值数组
        Object[] args = joinPoint.getArgs();

        // 方法签名对象
        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;
        // 最关键的一步:通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();

        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], JSON.toJSONString(args[i]));
        }

        System.out.println(paramMap);

        // 获取方法名
        String methodName = signature.getName();

        log.info("请求方法：{}, 请求参数: {}", methodName, Arrays.toString(args));

        // 可能在反向代理请求进来时，获取的IP存在不正确行 这里直接摘抄一段来自网上获取ip的代码
        log.info("请求ip：{}", getIpAddr(requestAttr.getRequest()));

        // 调用实际方法
        Object object = joinPoint.proceed();

        if(myLog.ignore()) {
            return object;
        }

        log.info("log注解描述：{}", myLog.value());

        long endTime = System.currentTimeMillis();

        log.info("结束计时: {},  URI: {}, 耗时：{}", new Date(), uri, endTime - beginTime);
        return object;
    }

    /**
     * https://my.oschina.net/u/994081/blog/185982
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        log.error("获取ip异常：{}" ,e.getMessage());
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }


}
