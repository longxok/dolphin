package com.dolphin.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * springSecurity 拦截器自定义一连串的chain的操作
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 基础配置
        http.csrf().disable()
                // 表单认证
                .formLogin()
                // 登录页
                .loginPage("/login")
                // 登录表单提交地址
                .loginProcessingUrl("/auth/login")
                .and()
                // 身份认证
                .authorizeRequests()
                // URL路径匹配
                .antMatchers("/login").permitAll()
                // 所有请求
                .anyRequest()
                // 身份认证
                .authenticated();
    }
}
