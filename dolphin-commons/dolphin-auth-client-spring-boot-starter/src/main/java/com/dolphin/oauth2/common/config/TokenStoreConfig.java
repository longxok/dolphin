package com.dolphin.oauth2.common.config;

import com.dolphin.oauth2.common.store.*;
import com.dolphin.oauth2.common.store.AuthDbTokenStore;
import com.dolphin.oauth2.common.store.AuthJwtTokenStore;
import com.dolphin.oauth2.common.store.AuthRedisTokenStore;
import com.dolphin.oauth2.common.store.ResJwtTokenStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * token存储配置
 *
 * @author dolphin
 */
public class TokenStoreConfig {
    @Configuration
    @ConditionalOnProperty(prefix = "dolphin.oauth2.token.store", name = "type", havingValue = "db")
    @Import(AuthDbTokenStore.class)
    public class JdbcTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "dolphin.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
    @Import(AuthRedisTokenStore.class)
    public class RedisTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "dolphin.oauth2.token.store", name = "type", havingValue = "authJwt")
    @Import(AuthJwtTokenStore.class)
    public class AuthJwtTokenConfig {
    }

    @Configuration
    @ConditionalOnProperty(prefix = "dolphin.oauth2.token.store", name = "type", havingValue = "resJwt")
    @Import(ResJwtTokenStore.class)
    public class ResJwtTokenConfig {
    }
}
