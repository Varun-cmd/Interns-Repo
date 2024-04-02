package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncAnnotationExample {
	
	@Async
	public void asyncFunction1() throws InterruptedException {
		System.out.println("Async Function 1 has been Started");
		System.out.println("Thread "+ Thread.currentThread().getId() +" is running");
		Thread.sleep(2000);
		System.out.println("Async Function 1 has been completed");
	}
	
	
	@Async
	public void asyncFunction2() throws InterruptedException {
		System.out.println("Async Function 2 has been Started");
		System.out.println("Thread "+ Thread.currentThread().getId() +" is running");
		Thread.sleep(1000);
		System.out.println("Async Function 2 has been completed");
	}
}
