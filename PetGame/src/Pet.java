


abstract class Pet {
	// moved food & toy list. Thought it should be unique to player not Pet otherwise you can have up to 6 inventories (1 Food & Toy for each pet.)
	
	// Pet should die if any attribute reaches 100.
	//static Toy favouriteToy; //sets to ball as default.
	String name;
	static int weight;
	static int hungerLvl = 0;
	static int sleepLvl = 0;
	static int toiletLvl = 0;
	static int happinessLvl = sleepLvl + hungerLvl + toiletLvl;
	static int roughness = 0;
	static String toilet = "Does not need the bathroom";
	static String hunger = "Not Hungry";
	static String sleep = "Not Tired";
	static String happiness = "Happy";
	
	public static void update(){

		
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
			toilet = "Does not need the Bathroom";
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
		if(happinessLvl > 200){
			happiness = "Miserable";
		}
	}
	
	
	public static int getWeight(){
		return weight;
	}
	
	public static String getHunger(){
		return hunger;
	}
	
	public static String getSleep(){
		return sleep;
	}
	
	public static String getHappiness(){
		return happiness;
	}
	
	public static String getToilet(){
		return toilet;
	}
	
	public static int getSleepLvl(){
		return sleepLvl;
	}
	
	public static void play(Toy toy){
		/*if(toy == Pet.favouriteToy){
			Pet.happinessLvl -= 50;
		}*/
		Pet.happinessLvl -= 30;
		toy.durability -= Pet.roughness;
		
		
	}
	
	public static void feed(Food food) {
		hungerLvl -= food.nutritionalValue;
		toiletLvl += 20;
		happinessLvl -= food.tastiness;
		
	}
	
	public static void sleep() {
		hungerLvl += 20;
		sleepLvl -= 50;
		toiletLvl += 30;
	}
	
	public static void toilet(){
		toiletLvl = 0;
	}
	
	

}
