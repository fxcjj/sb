package com.vic.sb17.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * 安全性配置
 * @author 罗利华
 * date: 2020/11/19 13:40
 */
@Component
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 暂时禁用安全性
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }

}
