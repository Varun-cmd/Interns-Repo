package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public CustomEventPublisher customEvent() {
		return new CustomEventPublisher();
	}
	
	@Bean
	public EmailListener email() {
		return new EmailListener();
	}
	
	@Bean
	public SMSListener sms() {
		return new SMSListener();
	}
}
