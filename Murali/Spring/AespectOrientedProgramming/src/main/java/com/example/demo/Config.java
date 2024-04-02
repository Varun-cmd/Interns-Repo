package com.example.demo;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {

	@Bean
	public LoanService loanService() {
		return new LoanService();
	}
	
	@Bean
	public LogginBeforeAndAfter log() {
		return new LogginBeforeAndAfter();
	}
	
//	@Bean
//	public AspectJAOP aspectAOP() {
//		return new AspectJAOP();
//	}
	
	
//	@Bean
//	public ProxyFactoryBean loanServiceProxy() throws Exception {
//		String[] interceptorNames = {"log"};
//		ProxyFactoryBean p = new ProxyFactoryBean();
//		p.setTarget(loanService());
//		p.setInterceptorNames(interceptorNames);
//		return p;
//	}
	
}
