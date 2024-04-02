package com.springstudy.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Airtel implements Sim {
	
	@Autowired
	@Qualifier("airtelNetworkProvider")
	private NetworkProvide networkProvider;

    @Override
    public void call() { 
        System.out.println("Calling from Airtel...");
    }

    @Override
    public void data() {
        
        System.out.println("Data from Airtel");
    }
    
	
	@Override
	public NetworkProvide getNetworkProvider() {
		return networkProvider;
	}   
}
