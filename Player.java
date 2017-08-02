import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String name;
	private int money = 500;
	private int actionsLeft = 2;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private ArrayList<String> pet_names = new ArrayList<String>();
	private ArrayList<Toy> toys = new ArrayList<Toy>(); // Change to Protected for use in PlayerTests
	private ArrayList<Food> foods = new ArrayList<Food>();
	private Scanner in = new Scanner(System.in);
	
	
	//CONSTRUCTOR SPECIFICALLY FOR DEV MODE
	Player(int dev){
		name = "Tom";
		pets.add(new Cat(3));
		pets.add(new Dog(3));
		pets.add(new Tiger(3));
		//ADDS ALL FOODS & ALL TOYS TO DEV INVENTORY.
		int listSizeToys = PetGame.getAvailableToys().size(); 
		int listSizeFood = PetGame.getAvailableFoods().size();
		for(int k = 0; k < listSizeToys;k++){
			Toy chosenToy = PetGame.getAvailableToys().get(k);
			toys.add(chosenToy);
		}
		for (int j=0; j < listSizeFood;j++){
			Food chosenFood = PetGame.getAvailableFoods().get(j);
			foods.add(chosenFood);
		}

		

		
	}
	
	
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
	

	public void petStatus() {
		System.out.println("What pet would you like to find out about?");
		Pet pet = choosePet();
		pet.printStats();
	}
	
	public void petDied(Pet pet) {
		pets.remove(pet);
	}
	
	public void store() {
		System.out.println("-----Welcome to the Store-----");
		System.out.println("Would you like to buy or sell? ");
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		int choice = in.nextInt();
		switch (choice){
		case 1:
			displayBuyItems();
			int buyChoice = in.nextInt();
			buy(buyChoice);
			continueShopping(); //SPLIT FROM BUY & SELL TO MINIMIZE REPEATED CODE & FOR JUNIT TESTS.
			break;
		case 2:
			displaySellItems();
			int sellChoice = in.nextInt();
			sell(sellChoice);
			continueShopping();
			break;
		}
		

	}
	
	public void displayBuyItems(){
		// print toys
					System.out.println("You have $" + money + " What would you like to buy?");
					System.out.println();
					System.out.println("TOYS:");
					int i = 0;
					for (; i < PetGame.getAvailableToys().size(); i++) {
						int toyPrice = PetGame.getAvailableToys().get(i).getPrice();
						System.out.println((i + 1) + ". " + PetGame.getAvailableToys().get(i).toString() + " $" + toyPrice);
					}
					
					// print foods
					System.out.println();
					System.out.println("FOODS:");
					for(int j = 0; i < (PetGame.getAvailableToys().size() + PetGame.getAvailableFoods().size()); i++, j++){
						int foodPrice = PetGame.getAvailableFoods().get(j).getPrice();
						System.out.println((i + 1) + ". " + PetGame.getAvailableFoods().get(j).toString() + " $" + foodPrice);
					}
					
					// back option
					System.out.println();
					System.out.println((i + 1) + ". back");
					// make choice and add item
		
	}
	
	
	
	
	public void buy(int choice){
		int i = 6;
		if (choice < PetGame.getAvailableToys().size()) {
			Toy chosenToy = PetGame.getAvailableToys().get(choice - 1);
			toys.add(chosenToy);
			money -= chosenToy.getPrice();
			System.out.println("You have Purchased " + chosenToy.toString() + " you have " + money + " dollars remaining.");
		} else if (choice < (i + 1) && choice > PetGame.getAvailableToys().size()) {
			Food chosenFood = PetGame.getAvailableFoods().get(choice - (PetGame.getAvailableToys().size() + 1));
			foods.add(chosenFood);
			money -= chosenFood.getPrice();
			System.out.println("You have Purchased " + chosenFood.toString() + " you have " + money + " dollars remaining.");
		} else if (choice == i + 1) {
			System.out.println("Thanks for shopping!");
			return;
		}

		
	}
	
	public void continueShopping(){
		// ask if player wants to continue shopping
		System.out.println();
		System.out.println("Would you like to continue shopping?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println();
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			store();
			break;
		case 2:
			System.out.println("Thanks for shopping!");
			return;
		}
		
	}
	
	public void displaySellItems(){
		System.out.println("What item would you like to sell?");
		System.out.println("==== TOYS ====");
		int i = 0;
		for(; i < toys.size();i++){
			int sellPrice = toys.get(i).getPrice()/2;
			System.out.println((i+1) +". "+ toys.get(i).toString() + " $" + sellPrice);
			
		}
		
		
		// print foods
		System.out.println();
		System.out.println("==== FOODS ====");
		for(int j = 0; i < (foods.size() + toys.size()); i++,j++){
			int sellPrice = foods.get(j).getPrice()/2;
			System.out.println((j+1) +". "+ foods.get(j).toString() + " $" + sellPrice);
		}
		
	}
	
	public void sell(int choice){
		int i = 6;
		// SELLING TOYS
		if (choice < toys.size()) {
			Toy chosenToy = toys.get(choice - 1);
			toys.remove(chosenToy);
			money += (chosenToy.getPrice()/2);
			System.out.println("You have Sold " + chosenToy.toString() + " you have " + money + " dollars remaining.");
		} else if (choice < (i + 1) && choice > toys.size()) {
			Food chosenFood = foods.get(choice - (toys.size() + 1));
			foods.remove(chosenFood);
			money += (chosenFood.getPrice()/2);
			System.out.println("You have Sold " + chosenFood.toString() + " you have " + money + " dollars remaining.");
		} else if (choice == i + 1) {
			System.out.println("Thanks for shopping!");
			return;
		}

		
	}
	
	
	
	public void play() {
		// pick a pet
		System.out.println("What pet would you like to play with?");
		Pet pet = choosePet();
		
		// which toy
		System.out.println("What toy would you like to use with " + pet.getName() + "?");
		if (toys.size() == 0) {
			System.out.println("You have no toys. Go to the store to buy some.");
			System.out.println("");
			return;
		}
		for(int j = 0; j < toys.size(); j++){
			Toy toy = toys.get(j);
			System.out.println((j + 1) + ". " + toy.toString());
		}
		int choice = in.nextInt();
		Toy toyChoice = toys.get(choice - 1);
		
		// play with that toy
		pet.play(toyChoice);
		if (!pet.getAlive()) {
			petDied(pet);
		}
	}
	
	
	public void feed() {
		// which pet
		System.out.println("What pet would you like to feed?");
		Pet pet = choosePet();
		
		// which food
		System.out.println("What would you like to feed " + pet.getName() + "?");
		if (toys.size() == 0) {
			System.out.println("You have no food. Go to the store to buy some.");
			System.out.println();
		}
		for (int j = 0; j < foods.size(); j++) {
			Food food = foods.get(j);
			System.out.println((j + 1) + ". " + food.toString());
		}
		int choice = in.nextInt();
		Food foodChoice = foods.get(choice - 1);
		
		// feed pet
		pet.feed(foodChoice);
		if (!pet.getAlive()) {
			petDied(pet);
		}
	}
	
	
	public void toilet() {
		// which pet
		System.out.println("What pet would you like to use the bathroom?");
		Pet pet = choosePet();
		
		// let the pet go to the toilet
		pet.toilet();
	}

	
	public void sleep() {
		// which pet
		System.out.println("What pet would you like to sleep?");
		for(int i = 0; i < pets.size(); i++) {
			Pet pet = pets.get(i);
			System.out.println((i + 1) + "." + " " + pet.toString());
		}
		System.out.println("4. All Pets" );
		int choice = in.nextInt();
		System.out.println();
		
		// sleep pet(s)
		if(choice == 4) {
			for (Pet pet : pets) {
				pet.sleep();
				if (!pet.getAlive()) {
					petDied(pet);
				}
				
			}
		} else {
			Pet pet = pets.get(choice - 1);
			pet.sleep();
			if (!pet.getAlive()) {
				petDied(pet);
			}
		}
	}
	
	
	//	Getters and Setters
	
	public void medicineCost(){
		money -= 80;
	}
	
	public int getBalance(){
		return money;
	}
	
	public void setBalance(int x) {
		money = x;
	}
	
	public int getNumPets(){
		return pets.size();
	}
	
	public String getName() {
		return name;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public void setActionsLeft(int x) {
		actionsLeft = x;
	}
	
	public ArrayList<Pet> getPets() {
		return pets;
	}
	
	public ArrayList<String> getNames(){
		return pet_names;
	}
	
	public ArrayList<Food> getFood() {
		return foods;
	}
	
	
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
	
	
	
	
	//	Private Methods
	
	private Pet choosePet() {
		for(int i = 0; i < pets.size(); i++) {
			Pet pet = pets.get(i);
			System.out.println((i + 1) + "." + " " + pet.toString());
		}
		
		int choice = in.nextInt();
		Pet pet = pets.get(choice - 1);
		System.out.println();
		
		return pet;
	}
}
