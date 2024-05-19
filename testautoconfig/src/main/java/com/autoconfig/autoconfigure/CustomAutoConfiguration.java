package com.autoconfig.autoconfigure;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autoconfig.config.CustomProperties;
import com.autoconfig.service.CustomService;

@Configuration
@EnableConfigurationProperties(CustomProperties.class)
@ConditionalOnProperty(name = "custom.enabled", havingValue = "true", matchIfMissing = false)
public class CustomAutoConfiguration {

    @Bean
    public CustomService customService(CustomProperties customProperties) {
        return new CustomService(customProperties.getMessage());
    }
}