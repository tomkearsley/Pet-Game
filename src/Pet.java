import java.util.ArrayList;


abstract class Pet {
	ArrayList<Toy> toys = new ArrayList<Toy>();
	String status;
	String name;
	int weight;
	int hungerLvl;
	int sleepLvl;
	
	public String viewStatus() {
		return status;
	}
	
	abstract void play();
	
	abstract void feed();
	
	abstract void sleep();
	
	abstract void toilet();
}
