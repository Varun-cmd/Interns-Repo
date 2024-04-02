package com.springstudy.study;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration

public class AppConfig {

	@Bean(name = "airtel")
	public Sim airtel(){			 
		return new Airtel();
	}
	
	@Bean (name = "jio")
	public Sim jio(){
		return new Jio();
	}
	
	
	@Bean(name="airtelNetworkProvider")
	
	public NetworkProvide airtelNetworkProvider() {
		return new AirtelNetworkProvider();
	}
	
	@Bean(name="jioNetworkProvider")
	@Primary
	public NetworkProvide jioNetworkProvider() {
		return new JioNetworkProvider();
	}
}
