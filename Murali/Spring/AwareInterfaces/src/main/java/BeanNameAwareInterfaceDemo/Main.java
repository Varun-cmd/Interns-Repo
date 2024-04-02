package BeanNameAwareInterfaceDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
 public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(JavConfig.class);
	SampleBean s = (SampleBean) context.getBean("newBeanName");
	s.getBeanName();
}
}
