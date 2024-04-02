package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class ServerConfig { //InitializingBean, DesposableBean -> Interfaces
		int id;
		String username;
		String password;
		
	@Autowired
		ServerConfig(int id, String username, String password){
			System.out.println("Constructor Injection");
			this.id = id;
			this.username = username;
			this.password = password;
		}
			
		@PostConstruct
		public void init() {
			System.out.println("Setting Up DB Connection...");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("Closing DB connection..");
		}
		
	}
