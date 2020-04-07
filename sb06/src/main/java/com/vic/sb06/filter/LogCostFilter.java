package com.vic.sb06.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 请求耗时过滤器
 * @author Victor
 * date: 2019/5/6 16:11
 */
@Slf4j
public class LogCostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //启动容器时初始化，在listener之后，在servlet之前
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LogCostFilter before chain.doFilter");

        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("LogCostFilter Execute cost time: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("LogCostFilter after chain.doFilter");
    }

    @Override
    public void destroy() {
        //容器销毁后执行，在servlet之后
    }
}
