package com.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages="com.file.control")
public class TestfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestfileApplication.class, args);
	}

}
