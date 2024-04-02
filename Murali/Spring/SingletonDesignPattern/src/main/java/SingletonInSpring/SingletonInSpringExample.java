package SingletonInSpring;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonInSpringExample {
	public static void main(String[] args) {
		
		
		
		AnnotationConfigApplicationContext context  =  new AnnotationConfigApplicationContext(Config.class);
		System.out.println("Requestig for bean");
		
		new Thread(()->{
			System.out.println(context.getBean("bean").hashCode());

		}).start();
		
		new Thread(()->{
			System.out.println(context.getBean("bean").hashCode());
		}).start();
		
		new Thread(()->{
			System.out.println(context.getBean("bean").hashCode());
		}).start();
	}
	
	public static void delay(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
