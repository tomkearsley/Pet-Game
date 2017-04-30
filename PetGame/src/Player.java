import java.util.ArrayList;
import java.util.Scanner;


public class Player{
	String name;
	static int money = 500;
	static ArrayList<Pet> pets = new ArrayList<Pet>();
	ArrayList<String> pet_names = new ArrayList<String>();
	static ArrayList<Toy> playerToys = new ArrayList<Toy>();
	static ArrayList<Food> playerFoods = new ArrayList<Food>();
	Scanner in = new Scanner(System.in);
	
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
				}	pet_names.add(name);
			}
			// same names allowed if different players?
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
			System.out.println("Which kind of pet would you like " + name + "? (1 to 6)");
			System.out.println("1. Dog");
			System.out.println("2. Cat");
			System.out.println("3. Tiger");
			System.out.println("4. Snake");
			System.out.println("5. Rabbit");
			System.out.println("6. Fish");
			
			int choice = in.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1:
				pets.add(new Dog()); 
				break;
			case 2:
				pets.add(new Cat());
				break;
			case 3: 
				pets.add(new Tiger());
				break;
			case 4: 
				pets.add(new Snake());
				break;
			case 5: 
				pets.add(new Rabbit());
				break;
			case 6: 
				pets.add(new Fish());
			}
		}
		
	}
	
	Player(int dev){
		String name = "Tosh";
		pets.add(new Cat(3));
		pets.add(new Dog(3));
		pets.add(new Tiger(3));
		Player.playerFoods = Food.foodList; //Gives all toys &  Foods to dev.
		Player.playerToys = Toy.toys;
		
		
	}
	
	public static ArrayList<Pet> getPets() {
		return pets;
	}
	
	public ArrayList<String> getNames(){
		return pet_names;
	}
	
	public void update() {
	}
	
	public static ArrayList<Food> getFood() {
		return playerFoods;
	}
}
