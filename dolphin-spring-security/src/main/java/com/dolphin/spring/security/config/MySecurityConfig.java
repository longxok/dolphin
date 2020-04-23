package com.dolphin.spring.security.config;

import com.dolphin.spring.security.handler.MyAuthenticationFailureHandler;
import com.dolphin.spring.security.handler.MyAuthenticationSuccessHandler;
import com.dolphin.spring.security.service.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;


    @Autowired
    @Qualifier("myAuthenticationSuccessHandler")
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    @Qualifier("myAuthenticationFailureHandler")
    private MyAuthenticationFailureHandler authenticationFailureHandler;
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
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
