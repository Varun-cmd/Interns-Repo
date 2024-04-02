package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BeanLifeCycleApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		ServerConfig s=  (ServerConfig) context.getBean("serverConfig");
		System.out.println(s.id +" "+s.username);
	

		((ConfigurableApplicationContext) context).close();
	}

}
