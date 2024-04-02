package com.example.demo;

import org.springframework.context.event.EventListener;

public class SMSListener {
	
	@EventListener
	public void smsListener(TransactionFailedCustomEvent event) {
		System.out.println("Transaction Failed for user "+event.getUser()+". Message Sent through SMS");
	}
}
