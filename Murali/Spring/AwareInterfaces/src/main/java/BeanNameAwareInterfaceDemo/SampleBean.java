package BeanNameAwareInterfaceDemo;

import org.springframework.beans.factory.BeanNameAware;

public class SampleBean implements BeanNameAware {

	public String beanName;
	
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public void getBeanName() {
		System.out.println(beanName);
	}
	
}
