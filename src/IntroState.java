import java.util.Scanner;


public class IntroState extends GameState {
	//make sure it will eventually call changeState() from update() and change the state to the main game state
	private Scanner in = new Scanner(System.in);
	
	IntroState() {	
	}

	@Override
	void update() {
		//welcome
		System.out.println("-----Welcome to the Pet Game-----");
		System.out.println();

		
		//get number of players
		int numPlayers = 0;
		while (numPlayers <= 0 || numPlayers > 3) {
			System.out.println("Enter number of Players (1 to 3): ");
			numPlayers = in.nextInt();
			System.out.println();

		}
		
		//get number of days
		System.out.println("Enter number of Days: ");
		int numDays = in.nextInt();
		System.out.println();
		PetGame.setNumDays(numDays);
		
		//add players
		for (int i = 1; i < numPlayers + 1; i++) {
			PetGame.addPlayer(new Player());
			System.out.println(">>next player's turn ");
			System.out.println();
		}
		
		//move onto main game state
		MainState mainState = new MainState();
		pushState(mainState);
	}
}
