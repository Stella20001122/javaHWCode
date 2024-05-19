package com.autoconfig.service;

import org.springframework.stereotype.Service;

@Service
public class CustomService {
    private final String message;

    public CustomService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}