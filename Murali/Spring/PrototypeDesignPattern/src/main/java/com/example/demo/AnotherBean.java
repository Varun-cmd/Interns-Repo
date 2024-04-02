package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PreDestroy;


public class AnotherBean implements BeanPostProcessor, BeanFactoryAware, DisposableBean {
	
	private BeanFactory beanFactory;
	private List<Object> prototypeObjects = new ArrayList<>();
		
	AnotherBean(){}	

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;		
	}
	
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if(beanFactory.isPrototype(beanName)) {
			synchronized (prototypeObjects) {
				prototypeObjects.add(bean);
			}
		}		
		return bean;
	}
	
	
	@Override
	public void destroy() throws Exception {
		System.err.println("Destroy of singleton called");
		synchronized (prototypeObjects) {
			for(Object bean : prototypeObjects) {
				if(bean instanceof DisposableBean) {
					DisposableBean dispose = (DisposableBean) bean;
					
					try {
						dispose.destroy();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			prototypeObjects.clear();
		}
		
	}	
}
