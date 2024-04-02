package com.example.demo;

import org.springframework.beans.factory.FactoryBean;

public class ServerManagerFactoryBean<T> implements FactoryBean<T> {

	private int apiKey;
	
	public ServerManagerFactoryBean(int apiKey) {
		this.apiKey = apiKey;
	}
	
	@Override
	public T getObject() throws Exception {
		// TODO Auto-generated method stub
		if(isValidApiKey(apiKey)) {
			return (T) new ServerManager(false);
		}else {
			return (T) new ServerManager(true);
		}
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return ServerManager.class;
	}
	
	
	public static boolean isValidApiKey(int apiKey) {
		if(apiKey==123) {
			return true;
		}else {
			return false;
		}
	}

}
