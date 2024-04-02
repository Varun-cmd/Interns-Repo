package com.example.demo;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AespectOrientedProgrammingApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		LoanService p =  (LoanService) context.getBean("loanService");
		p.issueLoan();
		p.cancelLoan();
	}
}
