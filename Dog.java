import java.util.Scanner;

public class Dog extends Pet {
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;

	Dog() {
		weight = 20;
		roughness = 10;
		favouriteToy = PetGame.getAvailableToys().get(2);
		
		do {
			System.out.println("What is your Dog's name? ");
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
	
	
	Dog(int dev){ // will expand upon later, add different hunger, tired, toilet,ect.
		name = "Bob";
		
	}

	
	public String toString(){
		return name + " the Dog";
	}

}
