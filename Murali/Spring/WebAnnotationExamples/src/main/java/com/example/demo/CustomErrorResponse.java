package com.example.demo;

import org.springframework.beans.factory.BeanNameAware;

public class CustomErrorResponse implements BeanNameAware {
    private int status;
    private String message;
    private String beanName;
    
    public CustomErrorResponse() {
    	
    }

//    // Constructor
//    public ErrorResponse(int status, String message) {
//        this.status = status;
//        this.message = message;
//    }


	// Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		this.beanName = beanName;
	}
}
