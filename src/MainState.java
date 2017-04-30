
public class MainState extends GameState {
	//make sure it will eventually call changeState() from update() and change the state to the store state of end the game

	@Override
	void update() {
		// iterate through players and update each as they have their turn
		System.out.println("-----Let the Game Begin-----");
		System.out.println("");
		
		//move onto end state
		EndState end = new EndState();
		pushState(end);
	}
	
}
