package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {
	
	
	@Bean
	public LookupAnnotationExample lookup() {
		return new LookupAnnotationExample();
	}
	
}
