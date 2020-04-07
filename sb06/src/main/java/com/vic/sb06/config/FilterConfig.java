package com.vic.sb06.config;

import com.vic.sb06.filter.LogCostFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * 过滤器配置
 * @author Victor
 * date: 2019/5/6 16:05
 */
@Configuration
//此注解可控制此配置是否生效（即是否使用过滤器），开关在application.properties中配置
@ConditionalOnProperty(prefix = "filter", name = "switch", havingValue = "true")
public class FilterConfig {

    @Bean
    public FilterRegistrationBean logCostFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LogCostFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("LogCostFilter");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); //执行顺序
        return registrationBean;
    }

}
