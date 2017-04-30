import java.util.ArrayList;
import java.util.Scanner;

public class Cat extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	ArrayList<Food> acceptedFoods = Player.playerFoods;
	
	Cat() {
		do {
			System.out.println("What is your Cat's name? ");
			name = in.nextLine();
			System.out.println();
			
			//check if name is already taken
			nameInUse = false;
			for (Player a : PetGame.getPlayers()) {
				for (Pet b : a.getPets()) {
					if (b.name.equals(this.name)) {
						nameInUse = true;
					}
				}
			}
			if (nameInUse) {
				System.out.println("This name in in use, choose another. ");
				System.out.println();
			}
		} while (nameInUse);
	}
	
	Cat(int dev){ // will expand upon later, add different hunger, tired, toilet,ect.
		name = "Greg";
		
	}


	
	public String toString(){
		return name + " the Dog";
	}

}
