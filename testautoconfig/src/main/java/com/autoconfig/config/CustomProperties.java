package com.autoconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    private String message;

    // 省略getter和setter方法

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}