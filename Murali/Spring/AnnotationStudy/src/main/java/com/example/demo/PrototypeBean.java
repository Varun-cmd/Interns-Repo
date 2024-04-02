package com.example.demo;

public class PrototypeBean{
	
	AsyncAnnotationExample asyncExe;
	
	public PrototypeBean(AsyncAnnotationExample asyncExe)  {
		this.asyncExe = asyncExe;
	}
	
	public void returnName() {
		System.err.println("Name");
	}
}