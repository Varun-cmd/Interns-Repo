package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@EnableAsync
@Import(AnotherConfig.class)
@PropertySource("classpath:application.properties")
public class Config {	
	@Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); 
        executor.setMaxPoolSize(10); 
        executor.setQueueCapacity(25); 
        executor.setThreadNamePrefix("AsyncThread-"); 
        executor.initialize();
        return executor;
    }
	
//	@Bean
//	public ExecutorService taskExecutor() {
//		ExecutorService exe = (ExecutorService) Executors.newFixedThreadPool(2);
//		return exe;
//	}
	
	@Bean
	public AsyncAnnotationExample asyncExample() {
		return new AsyncAnnotationExample();
	}
	
	@Bean
	public PrototypeBean p() {
		return new PrototypeBean(asyncExample());
	}


	@Bean
	public PrototypeBean g() {
		return new PrototypeBean(asyncExample());
	}
	
}
