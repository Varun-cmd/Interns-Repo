package ResourceLoaderAwareInterfaceDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public SampleBean sampleBean() {
		return new SampleBean();
	}
}
