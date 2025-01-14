package com.hmall.api.config;

import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public RequestInterceptor userInfoRequestInterceptor() {
        return requestTemplate -> {
            Long user = UserContext.getUser();
            if (!Objects.isNull(user)) {
                requestTemplate.header("user-info", user.toString());
            }
        };
    }
}
