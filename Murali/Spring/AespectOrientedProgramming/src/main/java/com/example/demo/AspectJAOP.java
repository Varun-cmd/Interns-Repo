package com.example.demo;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
public class AspectJAOP {
	
	public AspectJAOP() {}
	
	@After("execution(* LoanService.*(..))")
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Exit "+ target.getClass()+ " : "+ method.getName());		
	}

	@Before("execution(* LoanService.*(..))")
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Entry "+ target.getClass()+ " : "+ method.getName());
	}
	
}
