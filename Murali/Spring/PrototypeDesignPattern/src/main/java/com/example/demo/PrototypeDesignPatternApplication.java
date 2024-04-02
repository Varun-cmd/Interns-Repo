package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PrototypeDesignPatternApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("Requesting Beans");
		new Thread(()->{
			System.out.println(context.getBean("beans").hashCode());	 
		}).run();
		
//		new Thread(()->{
//			System.out.println(context.getBean("beans").hashCode());	 
//		}).run();
//		
//		new Thread(()->{
//			System.out.println(context.getBean("beans").hashCode());	 
//		}).run();
		
		((ConfigurableApplicationContext) context).close();
	
		
	
	}
}
