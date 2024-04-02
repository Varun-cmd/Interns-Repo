package com.example.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public ServerManager serverManager() throws Exception {
		FactoryBean factoryBean = new  ServerManagerFactoryBean(1234);
		return (ServerManager) factoryBean.getObject();
	}
	
	
	
}
