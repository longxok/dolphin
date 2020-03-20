package com.dolphin.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuang.kou
 */
@SpringBootApplication
@MapperScan("com.dolphin.security.system.repository")
public class SpringSecurityJwtGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtGuideApplication.class, args);
    }

}
