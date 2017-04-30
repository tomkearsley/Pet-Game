import java.util.ArrayList;
import java.util.Stack;


/* TODO List:
 * -add error exceptions for everything
 * -pets can have same name sometimes??
 * -add help
 */


public class PetGame {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static Stack<GameState> StateStack = new Stack<GameState>();
	private static GameState currentState;
	private static int numDays;
	
	private static void init() {
		IntroState introState = new IntroState();
		pushState(introState);
		currentState = StateStack.peek();
	}
	
	//main game loop
	private static void gameLoop() {
		while(currentState.getClass() != EndState.class) {
			currentState.update();
			clearConsole();
			currentState = StateStack.peek();
		}
	}
	
	private static void close() {
		System.out.println("Thanks for playing");
	}
	
	// ?? doesnt seem to work
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
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
	
	public static void pushState(GameState state) {
		StateStack.push(state);
	}
	
	public static void popState() {
		StateStack.pop();
	}
	
	// main
	public static void main(String args[]) {
		init();
		gameLoop();
		close();
	}
}
