package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;


public  class LookupAnnotationExample {
	
	public LookupAnnotationExample() {
	}
	
	@Resource(name = "p")
	private PrototypeBean pr;
	
	@Value("${dbName}")
	private String dbName;
	
	public void returnName() {
		System.out.println(dbName);
//		pr.returnName();
	}

}
