package com.dolphin.log.config;

import com.dolphin.log.properties.TraceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 日志自动配置
 *
 * @author dolphin
 * @date 2019/8/13
 */
@EnableConfigurationProperties(TraceProperties.class)
public class LogAutoConfigure {

}
