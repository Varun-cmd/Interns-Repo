package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
//@ConditionalOnClass(name = "com.example.demo.LoginForm")
//@ConditionalOnMissingClass(value = "com.example.demo.LoginPage")
@EnableAsync
public class Config {
	
	
	
	@Bean(name = "dbConnetion")
	public CustomErrorResponse error() {
		return new CustomErrorResponse();
	}
	
	
//	@ConditionalOnBean(name = "errorResponse")
//	@ConditionalOnMissingBean(name = "dbConnetion")
//	@ConditionalOnResource(resources = "classpath:test.properties")
	@Bean

	@Conditional(Java8Condition.class)
	public LoginForm loginForm() {
		LoginForm f = new LoginForm();
		f.setUsername("murali");
		f.setEmail("m@gmail.com");
		return f;
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		return new TaskScheduler();
	}
}
