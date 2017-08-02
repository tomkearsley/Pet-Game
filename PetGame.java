import java.util.ArrayList;
import java.util.Stack;


/* TODO List:
 * -JUST READ ASSIGMENTS SPECIFICATION
 * -random events 
 * -add error exceptions for everything
 * -add death and revival NEED DAYS FIXED FIRST
 * -pets can have same name sometimes??
 * -add help LOW PRIORITY
 * - GUI.
 * -end score ADDED
 */


public class PetGame {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Toy> availableToys = new ArrayList<Toy>();
	private static ArrayList<Food> availableFoods = new ArrayList<Food>();
	private static Stack<GameState> StateStack = new Stack<GameState>();
	private static int finalScore = 500;
	private static GameState currentState;
	private static int numDays;
	
	
	public static void pushState(GameState state) {
		StateStack.push(state);
		gameLoop();
	}
	
	public static void popState() {
		StateStack.pop();
		gameLoop();
	}
	
	private static void init() {
		StateStack.push(new IntroState());
		initToys();
		initFoods();
	}
	
	//main game loop
	private static void gameLoop() {
		currentState = StateStack.peek();
		while(currentState.getClass() != EndState.class) {
			currentState.update();
		}
	}
	
	private static void score(){
		// Score should be combination of all pet unhappiness levels. Eg: 500 - Pet1.Happiness, Pet2.Happiness..... 
		int numPlayers = players.size();
		for (int k = 0; k < numPlayers; k++){
			String playerName = players.get(k).getName();
			//next access players pets & their happiness levels
			ArrayList<Pet> pets = players.get(k).getPets();
			for(int j = 0; j < pets.size(); j++){
				finalScore -= pets.get(j).getHappinessLvl(); //Removes Pets UNhappiness level from initial score of 500.

				
			}
		System.out.println("Well Done! " + playerName +  " your Score Was: " + finalScore + "/500");
		}
		
	}
	
	private static void close() {
		System.out.println("-----Thanks for playing-----");
		score();
	
	}

	// CHANGED TO PUBLIC FOR PLAYER TESTS
	public static void initToys() {
		Toy fishToy = new Toy("Artificial Cave",100,20);
		Toy ball = new Toy("Ball",50,10);
		Toy bone = new Toy("Bone",120,15);
		Toy tyre = new Toy("Tyre",60,80);
		Toy mouse = new Toy("Toy Mouse",50,5);
		Toy yarn = new Toy("Ball of Yarn",80,10);
		availableToys.add(fishToy);	// 0
		availableToys.add(ball);
		availableToys.add(bone);
		availableToys.add(tyre);
		availableToys.add(mouse);
		availableToys.add(yarn);	//5
	}
	// CHANGED TO PUBLIC FOR PLAYER TESTS
	public static void initFoods() {
		Food steak = new Food("Steak",80,80,80);
		Food cake = new Food("Cake",10,50,30);
		Food milk =  new Food("Milk",40,20,30);
		Food fishFood = new Food("Fish Food",40,40,40);
		Food mouse = new Food("Mouse",40,40,40);
		Food bone = new Food("Bone",30,20,25);
		Food rabbitFood	= new Food("Rabbit Food",40,40,40);
		availableFoods.add(cake);
		availableFoods.add(steak);
		availableFoods.add(milk);
		availableFoods.add(fishFood);
		availableFoods.add(bone);
		availableFoods.add(rabbitFood);
		availableFoods.add(mouse);
	}
	
	//	Setters and Getters
	public static void addPlayer(Player player) {
		players.add(player);
	}
	
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	public static void setNumDays(int num) {
		numDays = num;
	}
	
	public static int getNumDays() {
		return numDays;
	}
	
	public static ArrayList<Toy> getAvailableToys() {
		return availableToys;
	}
	
	public static ArrayList<Food> getAvailableFoods() {
		return availableFoods;
	}
	
	// main
	public static void main(String args[]) {
		init();
		gameLoop();
		close();
	}
}
