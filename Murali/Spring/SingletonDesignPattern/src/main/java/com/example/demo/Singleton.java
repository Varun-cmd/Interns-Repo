package com.example.demo;

public class Singleton {
	
	
	private String message;
	
	private  Singleton(String message) {
		this.message = message;
	}
	
	
	public  void setMessage(String message) {
		this.message = message;
	}
	
	private static Singleton instance;
	
//	static {
//		instance = new Singleton();
//		System.out.println("Instance Created in Eager Manner");
//	}
	
	private Singleton() {}
	public static Singleton getInstance(String message) {
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance==null)
				instance = new Singleton(message);	
			}
		}		
		return instance;
	}
	
	
//	public static Singleton getInstance() {
//		return instance;
//	}
	
	public void displayMessage() {
		System.out.println("The messsage is "+message);
	}
	
}
