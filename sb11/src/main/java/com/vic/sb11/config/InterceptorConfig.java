package com.vic.sb11.config;

import com.vic.sb11.interceptor.CheckTokenInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * @author 罗利华
 * date: 2019/5/6 16:58
 */
@Configuration
@ConditionalOnProperty(prefix = "interceptor", name = "switch", havingValue = "true")
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 使用此方式，在拦截中@Value才可用
     * @return
     */
    @Bean
    CheckTokenInterceptor checkTokenInterceptor() {
        return new CheckTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 执行顺序按添加顺序为准
        registry.addInterceptor(checkTokenInterceptor()).addPathPatterns("/**");

        //父类中，这个方法什么都没做
//        super.addInterceptors(registry);
    }

}
