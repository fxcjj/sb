package com.vic.sb06.config;

import com.vic.sb06.filter.LogCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 * @author 罗利华
 * date: 2019/5/6 16:05
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean logCostFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LogCostFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("LogCostFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
