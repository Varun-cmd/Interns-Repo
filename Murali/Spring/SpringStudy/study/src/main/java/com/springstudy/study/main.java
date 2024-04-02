package com.springstudy.study;

import java.util.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("Enter Number to Call: ");
		long number = sc.nextLong();	
		System.out.println("Choose Sim Card\n1.Jio\n2.Airtel");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			Sim jio = applicationContext.getBean("jio", Sim.class);
			System.out.println("The Network is provided by "+ jio.getNetworkProvider());
			jio.call();
			break;

		case 2:
			Sim airtel = applicationContext.getBean("airtel", Sim.class);
			System.out.println("The Network is provided by "+ airtel.getNetworkProvider());
			airtel.call();
			break;
		}
	}

}
