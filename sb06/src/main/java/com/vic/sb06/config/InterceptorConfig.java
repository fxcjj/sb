package com.vic.sb06.config;

import com.vic.sb06.interceptor.LogCostInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Victor
 * date: 2019/5/6 16:58
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //执行顺序按添加顺序为准
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**");

        //父类中，这个方法什么都没做
//        super.addInterceptors(registry);
    }

}
