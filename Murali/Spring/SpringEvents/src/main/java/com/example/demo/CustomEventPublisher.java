package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class CustomEventPublisher {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void publisCustomEvent(String username) {
		this.publisher.publishEvent(new TransactionFailedCustomEvent(username));
	}
}
