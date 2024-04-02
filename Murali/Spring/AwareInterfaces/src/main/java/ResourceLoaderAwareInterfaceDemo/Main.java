package ResourceLoaderAwareInterfaceDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
 public static void main(String[] args) throws Exception {
	 
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
	
	SampleBean s = (SampleBean) context.getBean("sampleBean");
	s.readResource();
}
}
