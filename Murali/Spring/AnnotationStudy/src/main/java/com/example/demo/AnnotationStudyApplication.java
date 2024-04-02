package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class AnnotationStudyApplication {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		LookupAnnotationExample  l= (LookupAnnotationExample) context.getBean("lookup");
		l.returnName();
		
//		try {
//			exe.asyncFunction1();
//			exe.asyncFunction2();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Another function started");	
//	}
//		System.out.println(lookupExample.createPrototypeBean().hashCode());
//		System.out.println(lookupExample.createPrototypeBean().hashCode());
	}
}
