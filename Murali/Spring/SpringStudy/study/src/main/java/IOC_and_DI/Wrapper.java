package IOC_and_DI;

public class Wrapper {
	
	private Animal animal;
	
	Wrapper(){}
	
	Wrapper(Animal animal){
		this.animal = animal;
	}
	
	public void makeNoice() {
		animal.getSound();
	}
}
