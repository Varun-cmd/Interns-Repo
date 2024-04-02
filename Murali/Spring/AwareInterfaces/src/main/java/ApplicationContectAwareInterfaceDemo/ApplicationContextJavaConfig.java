package ApplicationContectAwareInterfaceDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ResourceLoaderAwareInterfaceDemo.SampleBean;

@Configuration
public class ApplicationContextJavaConfig {
	
	@Bean
	public ApplicationContextSampleBean applicationContextSampleBean() {
		return new ApplicationContextSampleBean();
	}
	
	@Bean("newName")
	public AnotherBean anotherBean() {
		return new AnotherBean();
	}

}
