package com.dolphin.spring.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.dolphin.spring.security.dao")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DolphinSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DolphinSpringSecurityApplication.class,args);
    }
}
