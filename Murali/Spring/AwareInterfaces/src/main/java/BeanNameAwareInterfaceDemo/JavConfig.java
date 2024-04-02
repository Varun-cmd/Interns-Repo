package BeanNameAwareInterfaceDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavConfig {

	
	@Bean("newBeanName")
	public SampleBean sampleBean() {
		return new SampleBean();
	}
}
