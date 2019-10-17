package com.dolphin.zuul.gateway.config;

import com.dolphin.common.config.DefaultAsycTaskConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author dolphin
 * 线程池配置、启用异步
 * @Async quartz 需要使用
 */
@Configuration
public class AsycTaskExecutorConfig extends DefaultAsycTaskConfig {

}
