import java.util.Scanner;

public class StoreState extends GameState{
	static Scanner in = new Scanner(System.in);
	@Override
	void update() {
		
		
	}
	public static void Store(){
		System.out.println("---Welcome to the Store---");
		System.out.println("You have $" + Player.money + " What would you like to buy?");
		System.out.println("");
		System.out.println("TOYS:");
		for(int k = 0;k < Toy.toys.size();k++){
			System.out.println(k+1 + "." + Toy.toys.get(k).toString());
		}
		System.out.println("");
		System.out.println("FOODS:");
		for(int j = 0; j < Food.foodList.size();j++){
			System.out.println(j+7 + "." + Food.foodList.get(j).toString());
		}
		int choice = in.nextInt();
		if(choice <= 6){
			Player.playerToys.add(Toy.toys.get(choice-1));
			Player.money -= Toy.toys.get(choice-1).getPrice();
			System.out.println("You have Purchased " + Toy.toys.get(choice-1) + " you have " + Player.money + "dollars remaining.");
		}
		if(choice <= 12 && choice > 6) {
			Player.playerFoods.add(Food.foodList.get((choice-7))); // index value starts at 0. Hence have to do -6.
			Player.money -= Food.foodList.get((choice-7)).getPrice();
			System.out.println("You have Purchased " + Food.foodList.get(choice-7) + " you have " + Player.money + " dollars remaining.");
			
		}
		System.out.println("");
		System.out.println("Would you like to purchase more items?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println();
		int choice2 = in.nextInt();
		switch(choice2){
		case 1:
			Store();
		case 2:
			System.out.println("");
		}
		
		

	}
	
	

}
