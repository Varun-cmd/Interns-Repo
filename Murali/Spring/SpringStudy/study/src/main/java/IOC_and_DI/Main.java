package IOC_and_DI;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
	Wrapper w = (Wrapper) applicationContext.getBean(Wrapper.class);
	
//	Wrapper w = (Wrapper) applicationContext.getBean("wrapper");
	w.makeNoice();
				
	}
}
