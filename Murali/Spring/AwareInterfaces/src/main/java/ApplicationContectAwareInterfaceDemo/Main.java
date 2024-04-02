package ApplicationContectAwareInterfaceDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ResourceLoaderAwareInterfaceDemo.JavaConfig;
import ResourceLoaderAwareInterfaceDemo.SampleBean;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextJavaConfig.class);
		
		ApplicationContextSampleBean s = (ApplicationContextSampleBean) context.getBean("applicationContextSampleBean");
		s.getApplicationContextInfo();
	}
}
