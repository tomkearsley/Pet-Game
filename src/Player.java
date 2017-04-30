import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	String name;
	private int actionCount = 0;
	private int dayCount = 0;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private Scanner in = new Scanner(System.in);
	
	Player() {
		//get players name
		boolean nameInUse = false;
		do {
			System.out.println("What is your name? ");
			name = in.nextLine();
			System.out.println();
				
			//check if name is already taken
			nameInUse = false;
			for (Player p : PetGame.getPlayers()) {
				if (p.name.equals(this.name)) {
					nameInUse = true;
				}
			}
			if (nameInUse) {
				System.out.println("This name in in use, choose another. ");
				System.out.println();
			}
		} while (nameInUse);
		
		//get how many pets they would like
		System.out.println("How many pets would you like " + name + "? (1 to 3) ");
		int numPets = in.nextInt();
		System.out.println();
		
		//add pets
		for (int i = 0; i < numPets; i++) {
			System.out.println("Which kind of pet would you like " + name + "? (1 to 2)");
			System.out.println("1. Dog");
			System.out.println("2. Cat");
			
			int choice = in.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1:
				pets.add(new Dog()); 
				break;
			case 2:
				pets.add(new Cat());
			}
		}
	}
	
	public ArrayList<Pet> getPets() {
		return pets;
	}
	
	public void update() {
	}
}
