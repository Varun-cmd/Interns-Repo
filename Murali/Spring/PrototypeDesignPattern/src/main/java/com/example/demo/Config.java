package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
	

	@Bean
	public AnotherBean anotherBean() {
		return new AnotherBean();
	}
	
	@Bean
	@Scope("prototype")
	public Beans beans() {
		return new Beans();
	}
	
	
}
