package com.dolphin.authorization.config;

import com.dolphin.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlt
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.dolphin.authorization.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {

}
