import java.util.Scanner;
import java.util.Random;

public class MainState extends GameState {
	//make sure it will eventually call changeState() from update() and change the state to the store state of end the game
	Scanner in = new Scanner(System.in);
	private int day = 0;
	private boolean playerLoop = true;
	
	@Override
	public void update() {
		// iterate through players and update each as they have their turn s
		System.out.println();
		System.out.println("-----Let the Game Begin-----");
		
		// iterate through days
		while (day < PetGame.getNumDays()) {
			// iterate through players
			for (Player player : PetGame.getPlayers()) {
				System.out.println();
				System.out.println(">> Your turn " + player.getName());
				while (playerLoop) {
					playerLoop = true;
					// What does the player want to do
					mainMenu(player);
					if (!areActionsLeft(player)) {
					      playerLoop = false;
					     }
				}
				player.setActionsLeft(2);
				playerLoop = true;
			}
			nextDay();
		}
	
		// move onto end state
		pushState(new EndState());
	}
	
		
	private void mainMenu(Player player) {
		// print menu
		System.out.println();
		System.out.println(">> This is Day " + (day + 1));
		System.out.println();
		System.out.println("1. View Pet Status");
		System.out.println("2. Shop");
		System.out.println("3. Skip Day");
		System.out.println("4. Play");
		System.out.println("5. Feed");
		System.out.println("6. Bathroom");
		System.out.println("7. Sleep");
		
		// get choice
		int choice = in.nextInt();
		System.out.println();
	
		// perform action
		switch(choice) {
		case 1:
			player.petStatus();
			break;
		case 2:
			player.store();
			break;
		case 3:
			// day fixed.
			playerLoop = false;
			break;
		case 4:
			player.play();
			break;
		case 5:
			player.feed();
			break;
		case 6:
			player.toilet();
			break;
		case 7:
			player.sleep();
		}
	}
	
	private boolean areActionsLeft(Player player) {
		boolean b = false;
		for (Pet pet : player.getPets()) {
			if (pet.getActionsLeft() > 0) {
				b = true;
			}
		}
		if (!b) {
			System.out.println();
			System.out.println("All your pets are out of actions");
			System.out.println();
		}
		return b;
	}
	
	private void nextDay() {
		day++;
		Random random = new Random();
		int randVal = random.nextInt(5) + 1;
		int randomPlayer = random.nextInt(PetGame.getPlayers().size()) + 1;
		Player pickedPlayer = PetGame.getPlayers().get(randomPlayer-1);
		int randomPet = random.nextInt(pickedPlayer.getNumPets()) + 1;
		Pet pickedPet = pickedPlayer.getPets().get(randomPet-1);
		if (randVal == 3){
			
			System.out.println("Oh No " + pickedPlayer.toString() + " Your Pet " + pickedPet.toString() + " is sick! Would you like to buy Medicine? ($80).");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			System.out.println();
			switch(choice) {
			case 1: 
				pickedPlayer.medicineCost();
				System.out.println("Your Pet is feeling Much Better. Your balance is: " + pickedPlayer.getBalance());
				
				break;
			case 2:
				pickedPet.isSick(true);
				break;
			}
			
		}
		if (randVal == 7){
			System.out.println("Oh No " + pickedPlayer.toString() + " Your Pet " + pickedPet.toString() + " is misbehaving. Would you like to correct him/her?");
			System.out.println("Note: If you do not, your pet will continue to misbehave");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			System.out.println();
			switch(choice) {
			case 1: 
				System.out.println("You corrected your pets behaviour, but he/she is now feeling sad.");
				pickedPet.setHungerLvl(pickedPet.getHungerLvl() + 20);
				break;
			case 2:
				pickedPet.isMisbehaving(true);
				break;
			
			}
		}
		for (Player player : PetGame.getPlayers()) {
			for (Pet pet : player.getPets()) {
				pet.nextDayUpdate();
				if (!pet.getAlive()) {
					player.petDied(pet);
				}
			}
		}
	}
}
