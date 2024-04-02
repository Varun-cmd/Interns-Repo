package com.smallcompany.small_company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apiImplementor.API_Implementor.SecureStoreImplementor;

@Configuration
public class JavaConfig {
	
	@Bean
	public SecureStoreImplementor secureStoreImplementor() {
		int accid = 123;
		String username = "murali",  password="234";
		List<Integer> serverlist = Arrays.asList(123, 345);
		Map<String,String> configparms = new HashMap<>();
		configparms.put("cores", "16");
		configparms.put("ram", "246gg");		
		return new SecureStoreImplementor(accid, username,password,  serverlist, configparms);
		
	}
	
	@Bean
	public ServerConnection serverConnection() {
		return new ServerConnection(secureStoreImplementor());
	}
}
