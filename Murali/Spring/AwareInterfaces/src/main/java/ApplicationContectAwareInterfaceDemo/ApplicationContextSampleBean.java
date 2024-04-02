package ApplicationContectAwareInterfaceDemo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextSampleBean implements ApplicationContextAware {
	
	public ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void getApplicationContextInfo() {
		System.out.println(applicationContext.getId());
		System.out.println(applicationContext.hashCode());
		
		System.out.println(applicationContext.containsBean("newName"));
	}
}
