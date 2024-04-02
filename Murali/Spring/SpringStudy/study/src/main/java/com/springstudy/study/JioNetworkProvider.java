package com.springstudy.study;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class JioNetworkProvider implements NetworkProvide {

	@Override
	public void provideNetwork() {
		System.out.println("Network is Providede By Jio");
	}	
}
