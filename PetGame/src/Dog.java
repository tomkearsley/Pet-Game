import java.util.Scanner;

public class Dog extends Pet {
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	int weight = 10;
	static int roughness = 50;

	Dog() {
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
