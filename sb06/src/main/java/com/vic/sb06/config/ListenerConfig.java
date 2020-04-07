package com.vic.sb06.config;

import com.vic.sb06.listener.AmplyListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 监听器配置
 * @author Victor
 * date: 2019/5/6 17:20
 */
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<AmplyListener> amplyListenerRegistration() {
        ServletListenerRegistrationBean<AmplyListener> registration = new ServletListenerRegistrationBean<AmplyListener>();
        registration.setListener(new AmplyListener());
        return registration;
    }

}
