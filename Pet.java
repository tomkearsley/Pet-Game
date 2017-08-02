

abstract class Pet {
	// Pet should die if any attribute reaches 100.
	protected String name;
	protected int weight;
	protected int roughness = 0;
	protected Toy favouriteToy;
	protected boolean alive = true;
	protected int hungerLvl = 0;
	protected int sleepLvl = 0;
	protected int toiletLvl = 0;
	protected int happinessLvl = sleepLvl + hungerLvl + toiletLvl;
	protected String toilet = "Does not need the bathroom";
	protected String hunger = "Not Hungry";
	protected String sleep = "Not Tired";
	protected String happiness = "Happy";
	protected int actionsLeft = 2;
	protected boolean revived = true;
	
	private void update() {
		
		//HUNGER
		if(hungerLvl <= 0){
			hungerLvl = 0;
			hunger = "Not Hungry";
		}
		if(hungerLvl > 0){
			hunger = "Peckish";
		}
		if(hungerLvl > 50){
			hunger = "Very Hungry";
		}
		if(hungerLvl > 80) {
			hunger = "Starving";
		}
		
		//SLEEP
		if(sleepLvl <= 0){
			sleepLvl = 0;
			sleep = "Not Tired";
		}
		if(sleepLvl > 0){
			sleep = "Sleepy";
		}
		if(sleepLvl > 50){
			sleep = "Tired";
		}
		if(sleepLvl > 80) {
			sleep = "Exhausted";
		}
		
		//TOILET
		if(toiletLvl <= 0){
			toiletLvl = 0;
			toilet = "Does not need the bathroom";
		}
		if(toiletLvl > 30){
			toilet = "Needs Bathroom";
			
		}
		if(toiletLvl > 60) {
			toilet = "Really needs Bathroom";
		}
		
		if(toiletLvl > 90) {
			toilet = "DESPERATELY needs Bathroom";
		}
		updateHappiness();
		//HAPPINESS Maybe change to unhappiness Level
		if(happinessLvl <= 0){
			happinessLvl = 0;
			happiness = "Happy";
		}
		
		if(happinessLvl > 60) {
			happiness = "Ok";
		}
		if(happinessLvl > 90) {
			happiness = "Not Happy";
		}
		if(happinessLvl > 150) {
			happiness = "Very unhappy";
		}
		if(happinessLvl > 170){
			happiness = "Miserable";
		}
		
		if (happinessLvl > 200 || hungerLvl > 100 || sleepLvl > 100) {
			System.out.println("Your Pet " + name + " has Died!");
			if (!revived) {
				revived = true;
				System.out.println("Your Pet has been Revived. This cannot happen Again!");
			} else {
				alive = false;
				System.out.println("You have already used your revive! Your pet will remain dead. ");
			}
		}
	}
	
	public boolean getAlive() {
		update();
		return alive;
	}
	
	
	public void updateHappiness(){
		happinessLvl = sleepLvl + hungerLvl + toiletLvl;
	}
	
	
	public void play(Toy toy) {
		if (actionsLeft  <= 0) {
			System.out.println("This pet doesn't have actions left to do that");
			return;
		}
		
		if (toy == favouriteToy) {
			happinessLvl -= 50;
			hungerLvl += 20;
		} else {
			happinessLvl -= 30;
			hungerLvl += 20;
		}
		toy.durability -= roughness;
		update();
		
		System.out.println("Toy Durability: " + toy.getDurability());
		System.out.println(toString() + " has now played as is feeling " + getHappiness() + ".");
		
		actionsLeft--;
	}
	
	public void feed (Food food) {
		if (actionsLeft  <= 0) {
			System.out.println("This pet doesn't have actions left to do that");
			return;
		}
		
		hungerLvl -= food.nutritionalValue;
		toiletLvl += 20;
		happinessLvl -= food.tastiness;
		update();
		
		System.out.println(toString() + " has now eaten and is feeling " + getHunger() + ".");
		
		actionsLeft--;
	}
	
	public void sleep() {
		if (actionsLeft  <= 0) {
			System.out.println("This pet doesn't have actions left to do that");
			return;
		}
		hungerLvl += 20;
		sleepLvl -= 50;
		toiletLvl += 30;
		update();
		
		System.out.println(toString() + " has now slept and is now feeling " + getSleep() + " and is " + getHunger() + ".");
		
		actionsLeft--;
	}
	
	public void toilet(){
		if (actionsLeft  <= 0) {
			System.out.println("This pet doesn't have actions left to do that");
			return;
		}
		
		toiletLvl = 0;
		
		System.out.println(toString() + " has now been to the bathroom");
		
		actionsLeft--;
		update();
	}
	
	public void nextDayUpdate() {
		sleepLvl += 10;
		hungerLvl += 10;
		actionsLeft = 2;
	}
	
	public void printStats(){
		update();
		System.out.println("____Stats____");
		System.out.println("Pet: " + name);
		System.out.println("Actions left: " + actionsLeft);
		System.out.println("Weight: " + weight + "kgs");
		System.out.println("Hunger: " + hunger);
		System.out.println("Tiredness: " + sleep);
		System.out.println("Actions left: " + actionsLeft);
		System.out.println("Happiness: " + happiness);

		
	}
	
	
	public abstract String toString();
	
	// SETTER AND GETTERS	
	public void isSick(boolean sick) {
		if(sick == true){
			hungerLvl += 50;
			toiletLvl += 20;
			sleepLvl += 50;
			update();
		}
	}
	
	public void isMisbehaving(boolean misbehaving){
		if(misbehaving == true){
			hungerLvl += 20;
			toiletLvl += 20;
			sleepLvl += 20;
			update();
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getHungerLvl() {
		return hungerLvl;
	}
	
	public String getToilet(){
		return toilet;
	}
	
	public String getHunger() {
		return hunger;
	}
	
	public int getSleepLvl() {
		return sleepLvl;
	}
	
	public String getSleep() {
		return sleep;
	}
	
	public int getToiletLvl() {
		return toiletLvl;
	}
	
	public int getHappinessLvl() {
		return happinessLvl;
	}
	
	public String getHappiness() {
		return happiness;
	}
	
	public int roughness() {
		return roughness;
	}
	
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	public boolean getRevive(){
		update();
		return revived;
	}
	
	public void setToiletLvl(int x){
		toiletLvl = x;
		update();
	}
	public void setSleepLvl(int x){
		sleepLvl = x;
		update();
	}
	
	public void setHungerLvl(int x){
		hungerLvl = x;
		update();
	}
	
	public void setHappinessLvl(int x){
		happinessLvl = x;
		update();
	}
}
