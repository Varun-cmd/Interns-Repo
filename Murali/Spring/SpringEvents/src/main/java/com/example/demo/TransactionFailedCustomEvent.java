package com.example.demo;

public class TransactionFailedCustomEvent {
	private String user;
	
	public TransactionFailedCustomEvent(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
}
