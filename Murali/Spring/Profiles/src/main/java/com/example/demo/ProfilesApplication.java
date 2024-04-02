package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProfilesApplication {

	public static void main(String[] args) {
		ApplicationContext context = new  AnnotationConfigApplicationContext(Config.class);
		
		DBManager d = (DBManager) context.getBean("dbManager");
		d.getConnection();
	}

}
