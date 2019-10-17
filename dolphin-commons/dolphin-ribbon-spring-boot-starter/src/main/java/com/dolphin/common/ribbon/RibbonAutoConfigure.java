package com.dolphin.common.ribbon;

import com.dolphin.common.constant.ConfigConstants;
import com.dolphin.common.ribbon.config.RestTemplateProperties;
import com.dolphin.common.ribbon.config.RuleConfigure;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.DefaultPropertiesFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon扩展配置类
 *
 * @author dolphin
 * @date 2018/11/17 9:24
 */
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RibbonAutoConfigure {
    @Bean
    public DefaultPropertiesFactory defaultPropertiesFactory() {
        return new DefaultPropertiesFactory();
    }

    @Configuration
    @ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
    @RibbonClients(defaultConfiguration = {RuleConfigure.class})
    public class LbIsolationConfig {
    }
}
