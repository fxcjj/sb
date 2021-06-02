package com.vic.sb24.aspect;

import com.vic.sb24.annotation.CheckRepeatSubmit;
import com.vic.sb24.out.ApiResult;
import com.vic.sb24.out.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 校验重复提交切面
 * @author Victor
 * date: 2020/3/30 16:18
 */
@Slf4j
@Component
@Aspect
public class CheckRepeatSubmitAspect {

    private static final String TOKEN_KEY = "token";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Around("execution(* com.vic.sb24.controller.*Controller.*(..)) && @annotation(checkRepeatSubmit)")
    public Object doAround(ProceedingJoinPoint pjp, CheckRepeatSubmit checkRepeatSubmit) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            // 先从header中取
            String token = request.getHeader(TOKEN_KEY);
            String ip = getClientIp(request).replaceAll(":", "");
            // 为空再从请求参数中取
            if(StringUtils.isEmpty(token)) {
                token = request.getParameter(TOKEN_KEY);
            }

            // 重复提交的key
            String key = token + ":" + ip + "-" + request.getServletPath();

            // 添加，指定有效时间
            Boolean add = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", checkRepeatSubmit.delaySeconds(), TimeUnit.SECONDS);
            if(!add) {
                log.error("表单重复提交， token:{}, uri:{}", token, request.getServletPath());
                return ApiResult.fail(ResultCode.REPEAT_SUBMIT_ERROR.getCode(), ResultCode.REPEAT_SUBMIT_ERROR.getDesc());
            }
            ApiResult result = (ApiResult) pjp.proceed();
            return result;
        } catch (Throwable e) {
            log.error("校验表单重复提交时异常: {}", e.getMessage());
            return ApiResult.fail("error");
        }
    }

    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (org.springframework.util.StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (org.springframework.util.StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
