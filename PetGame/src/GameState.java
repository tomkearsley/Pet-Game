
abstract class GameState {
	
	abstract void update();
	
	protected void pushState(GameState state) {
		PetGame.pushState(state);
	}
	
	protected void popState() {
		PetGame.popState();
	}
}
