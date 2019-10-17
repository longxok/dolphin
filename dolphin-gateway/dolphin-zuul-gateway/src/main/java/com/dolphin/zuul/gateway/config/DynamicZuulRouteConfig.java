package com.dolphin.zuul.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.dolphin.zuul.gateway.route.nacos.NacosDynRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 动态路由配置
 *
 * @author dolphin
 * @date 2019/8/21
 */
@Configuration
@ConditionalOnProperty(prefix = "dolphin.gateway.dynamicRoute", name = "enabled", havingValue = "true")
public class DynamicZuulRouteConfig {
    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private DispatcherServletPath dispatcherServletPath;

    /**
     * Nacos实现方式
     */
    @Configuration
    @ConditionalOnProperty(prefix = "dolphin.gateway.dynamicRoute", name = "dataType", havingValue = "nacos", matchIfMissing = true)
    public class NacosZuulRoute {
        @Autowired
        private NacosConfigProperties nacosConfigProperties;

        @Autowired
        private ApplicationEventPublisher publisher;

        @Bean
        public NacosDynRouteLocator nacosDynRouteLocator() {
            return new NacosDynRouteLocator(nacosConfigProperties, publisher, dispatcherServletPath.getPrefix(), zuulProperties);
        }
    }
}
