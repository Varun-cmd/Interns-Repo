package SingletonInSpring;

import org.springframework.context.annotation.Lazy;


public class Beans {

	AnotherBean anotherBean;
	
	public Beans() {	
		}

	public Beans(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
		System.out.println("Bean is lazily loaded");
	}
	
	public void displayMessage(String message) {
		anotherBean.displayMessage(message);
	}
}
