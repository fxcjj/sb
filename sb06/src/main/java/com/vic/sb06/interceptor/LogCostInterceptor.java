package com.vic.sb06.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 耗时拦截器
 * @author 罗利华
 * date: 2019/5/6 16:56
 */
public class LogCostInterceptor implements HandlerInterceptor {

    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        start = System.currentTimeMillis();
        //返回 false 则请求中断
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        System.out.println("LogCostInterceptor Execute cost time: " + (System.currentTimeMillis() - start) + "ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
