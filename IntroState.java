import java.util.Scanner;


public class IntroState extends GameState {
	//make sure it will eventually call changeState() from update() and change the state to the main game state
	private Scanner in = new Scanner(System.in);
	
	
	@Override
	void update() {
		// welcome
		System.out.println("-----Welcome to the Pet Game-----");
		System.out.println();
		System.out.println("1. Play");
		System.out.println("2. Help");
		System.out.println("3. Dev Mode");
		int choice = in.nextInt();
		System.out.println();
		switch (choice) {
		case 1:
			playLoop();
			break;
		case 2:
			helpPage();
			break;
		case 3:
			devMode();
			break;
		}
	}
	
	
	public void playLoop() {
		// get number of players
		int numPlayers = 0;
		while (numPlayers <= 0 || numPlayers > 3) {
			System.out.println("Enter number of Players (1 to 3): ");
			numPlayers = in.nextInt();
			System.out.println();
		}
	
		// get number of days
		System.out.println("Enter number of Days: ");
		int numDays = in.nextInt();
		System.out.println();
		PetGame.setNumDays(numDays);
		
		// add players
		for (int i = 1; i < numPlayers + 1; i++) {
			PetGame.addPlayer(new Player());
			System.out.println(">> Next player's turn ");
			System.out.println();
		}
	
		// move onto main game state
		pushState(new MainState());
	}
		
	
	public void helpPage() {
		System.out.println("Why are you reading this?");
		System.out.println("1. Back");
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			update();
		}
	}
	
	public void devMode(){
		PetGame.setNumDays(3);
		PetGame.addPlayer(new Player(3));
		
		MainState mainState = new MainState();
		pushState(mainState);
	}
}

