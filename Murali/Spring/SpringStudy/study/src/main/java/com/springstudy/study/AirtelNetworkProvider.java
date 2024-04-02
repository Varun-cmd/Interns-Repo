package com.springstudy.study;

import org.springframework.stereotype.Component;


@Component
public class AirtelNetworkProvider implements NetworkProvide {

	@Override
	public void provideNetwork() {
		System.out.println("Network is Providede By Jio");
	}
}
