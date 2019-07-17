package com.vic.sb10.config;

import com.google.common.collect.Lists;
import com.vic.sb10.filter.JwtFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.util.List;

/**
 * 过滤器配置
 * @author 罗利华
 * date: 2019/6/27 19:05
 */
@Configuration
@ConditionalOnProperty(prefix = "filter", name = "switch", havingValue = "true")
public class FilterConfig {

    @Bean
    public FilterRegistrationBean logCostFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        //添加需要拦截的url
        List<String> urlPatterns = Lists.newArrayList();
        urlPatterns.add("/user/beam");
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
//        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("JwtFilter");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); //执行顺序
        return registrationBean;
    }

}
