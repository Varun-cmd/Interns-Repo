package com.example.demo;

import org.springframework.context.event.EventListener;

public class EmailListener {
	
	@EventListener
	public void handleCustomEventSMS(TransactionFailedCustomEvent event) {
		System.out.println("Transaction failed for user "+ event.getUser() +". Message Sent through Email");
	}
}
