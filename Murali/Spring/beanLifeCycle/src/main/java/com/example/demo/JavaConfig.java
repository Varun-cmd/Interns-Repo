package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	@Bean
	public ServerConfig serverConfig() {
		return new ServerConfig(1001, "murali", "abc");
	}
}
