package com.example.demo;

import org.springframework.beans.factory.DisposableBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Beans implements DisposableBean {
	
	public Beans(){
		System.out.println("Bean is being Initialied");
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("Called after initialization");
	}
	

	public void destroy() {
		System.out.println("Called BeFORE Destruction");
	}
}
