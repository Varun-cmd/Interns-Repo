package SingletonInSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
 @Bean
 @Lazy
 public Beans bean() {
	 return new Beans(anotherBean());
 }
 
 public AnotherBean anotherBean() {
	 return new AnotherBean();
 }
}
