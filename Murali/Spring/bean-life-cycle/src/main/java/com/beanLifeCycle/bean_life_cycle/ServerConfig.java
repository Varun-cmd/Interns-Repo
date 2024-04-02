package com.beanLifeCycle.bean_life_cycle;

public class ServerConfig {
	int id;
	String username;
	String password;
	
	ServerConfig(int id, String username, String password){
		System.out.println("Constructor Injection");
		this.id = id;
		this.username = username;
		this.password = password;
	}
			
}
