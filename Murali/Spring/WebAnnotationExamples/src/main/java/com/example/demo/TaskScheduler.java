package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler {
	
	@Scheduled(fixedRate = 1000)
	@Async
	public void myTask() {
		System.out.println("New Task Running...");
	}
}
