package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
public class TestlogApplication {

	private static final Logger logger = LoggerFactory.getLogger(TestlogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TestlogApplication.class, args);
		
		logger.info("Application started");
	        
	        // 这里是你的业务逻辑代码
	        // ...
	        
	   logger.error("An error occurred", new RuntimeException("Error details"));
	}

}
