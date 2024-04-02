package IOC_and_DI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	@Bean
	public Animal dog() {
		return new Dog();
	}
	
	@Bean
	public Animal cat() {
		return new Cat();
	}
	
	@Bean
	public Wrapper wrapper() {
		return new Wrapper(cat());
	}
	
	
	
	


}
