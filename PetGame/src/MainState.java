import java.util.Scanner;
public class MainState extends GameState {
	//make sure it will eventually call changeState() from update() and change the state to the store state of end the game
	Scanner in = new Scanner(System.in);
	static int num_pets = Player.getPets().size();
	int num_food = Player.playerFoods.size();
	int num_toys = Player.playerToys.size();
	int dayActions = 2;
	@Override
	void update() {
		int numDays = PetGame.numDays;
		// iterate through players and update each as they have their turn
		System.out.println("");
		System.out.println("-----Let the Game Begin-----");

		
		// Checks what day it is and how many actions are left
		for(int i = 0; i < numDays+1;){
			if(dayActions == 0){
				dayActions = 2;
				i++;
				// For every new day, increases hunger & tiredness
				for(int k = 0; k < num_pets;k++){
					Pet.sleepLvl += 10;
					Pet.hungerLvl += 10;
				}
				Pet.update();
	
			}
			// main menu
			System.out.println("");
			System.out.println("This is Day " + (i+1) + " you have " + dayActions + " Actions left.");
			System.out.println("1. View Pet Status");
			System.out.println("2. Shop");
			System.out.println("3. Skip Action");
			System.out.println("4. Play");
			System.out.println("5. Feed");
			System.out.println("6. Bathroom");
			System.out.println("7. Sleep");

			int choice = in.nextInt();
			System.out.println();
		
			switch(choice) {
			case 1:
				petStatus(); 
				break;
			case 2:
				StoreState.Store();
				break;
			case 3:
				dayActions -= 1;
				break;
			case 4:
				Play();
			case 5:
				Feed();
				break;
			case 6:
				Toilet();
				break;
			case 7:
				Sleep();
				break;
			}
			
			
			
		}
		
		//move onto end state
		EndState end = new EndState();
		pushState(end);
	}
	
	public void Play(){
		System.out.println("What pet would you like to play with?");
		for(int i = 0; i < num_pets; i++){
			String petString = Player.pets.get(i).toString();
			System.out.println(i+1 + "." + "" + petString);
			System.out.println();
			
			
		}
		int choice = in.nextInt();
		String petString = Player.pets.get(choice-1).toString();
		System.out.println("What toy would you like to use with " + petString + "?");
		if(num_toys == 0){
			System.out.println("You have no toys. Go to the store to buy some.");
			System.out.println("");
		}
		for(int j = 0; j < num_toys; j++){
			String	toyString = Player.playerToys.get(j).toString();
			System.out.println((j+1) + "." + toyString);
			
		}
		
		choice = in.nextInt();
		Toy toyChoice = Player.playerToys.get(choice);
		Pet.play(toyChoice);
		Pet.update();
		System.out.println("Toy Durability: " + toyChoice.getDurability());
		System.out.println(petString + " has now played as is feeling " + Pet.getHappiness() + ".");
		
		
	}
	public void Feed(){
		System.out.println("What pet would you like to feed?");
		for(int i = 0; i < num_pets; i++){
			String petString = Player.pets.get(i).toString();
			System.out.println(i+1 + "." + "" + petString);
			System.out.println();
			
			
		}
		int choice = in.nextInt();
		String petString = Player.pets.get(choice-1).toString();
		System.out.println("What would you like to feed " + petString + "?");
		if(num_food == 0){
			System.out.println("You have no food. Go to the store to buy some.");
			System.out.println("");
		}
		for(int j = 0; j < num_food; j++){
			String foodString = Player.playerFoods.get(j).toString();
			System.out.println((j+1) + "." + foodString);
			
		}
		
		choice = in.nextInt();
		Food foodChoice = Player.playerFoods.get(choice);
		Pet.feed(foodChoice);
		Pet.update();
		System.out.println(petString + " has now eaten and is feeling " + Pet.getHunger() + ".");
	}
		
	
	
	public void Toilet(){
		System.out.println("What pet would you like to use the bathroom?");
	}
	
	public void Sleep(){
		System.out.println("What pet would you like to sleep?");
		for(int i = 0; i < num_pets; i++){
			String petString = Player.pets.get(i).toString();
			System.out.println(i+1 + "." + "" + petString);
			System.out.println();
			System.out.println(petString + " has now slept and is now feeling " + Pet.getSleep() + " and is "+ Pet.getHunger() + ".");
	}
		System.out.println("4. All Pets" );
		int choice = in.nextInt();
		if(choice == 4){
			for (int i = 0; i < num_pets; i++){
				Pet.sleep();
				Pet.update();
				
			}
		}
		else{
			String petString = Player.pets.get(choice-1).toString();
			Pet.sleep();
			Pet.update();
			System.out.println(petString + " has now slept and is now feeling " + Pet.getSleep() + " and is "+ Pet.getHunger() + ".");
		}
	dayActions -= 1;
	}
	
	public void petStatus() {
		System.out.println("What pet would you like to find out about?");
		for(int i = 0; i < num_pets; i++){
			String petString = Player.pets.get(i).toString();
			System.out.println(i+1 + "." + "" + petString);
			System.out.println();
			
			
		}
		int choice = in.nextInt();
		String petString = Player.pets.get(choice-1).toString();
		viewStatus(choice,petString);
	}
	public void viewStatus(int choice,String petString){
		System.out.println(Pet.getSleepLvl());
		System.out.println(petString + " is " + Pet.getWeight() + " kgs, " + Pet.getHunger() + ", " +Pet.getSleep() + " and " + Pet.getToilet() + ".\n" + 
				"Overall " + petString + " is " + Pet.getHappiness() + ".");
		
	}
	
	
	
}
