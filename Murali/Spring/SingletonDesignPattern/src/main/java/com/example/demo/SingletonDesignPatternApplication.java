package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonDesignPatternApplication {

	public static void main(String[] args) {
		
//		Singleton s = Singleton.getInstance("Sample");
//		System.out.println(s.hashCode());
//		System.out.println(s.hashCode());
//		System.out.println(s.hashCode());
		
		new Thread(()-> {
			delay(1);
			Singleton s1 = Singleton.getInstance("Thead 1");	
			s1.displayMessage();
		}).start();
		
		new Thread(()-> {
			delay(1);
			Singleton s1 = Singleton.getInstance("Thead 2");
			s1.displayMessage();
		}).start();
		
		
		
		new Thread(()-> {
			Singleton s1 = Singleton.getInstance("Thead 3");
			s1.displayMessage();
		}).start();;
		
	}
	
	public static void delay(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
