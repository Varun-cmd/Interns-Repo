package com.springstudy.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Jio implements Sim {
	
    @Autowired
    @Qualifier("jioNetworkProvider")
	private NetworkProvide networkProvider;
	
    @Override
    public void call() {      
        System.out.println("Calling from Jio...");
    }

    @Override
    public void data() {     
        System.out.println("Data from Jio");
    }
    	
	@Override
	public NetworkProvide getNetworkProvider() {
		return networkProvider;
	}
}
