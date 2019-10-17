package com.dolphin.log.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 日志链路追踪配置
 *
 * @author dolphin
 * @date 2019/8/13
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "dolphin.trace")
@RefreshScope
public class TraceProperties {
    /**
     * 是否开启日志链路追踪
     */
    private Boolean enable = false;
}
