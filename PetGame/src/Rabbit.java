import java.util.Scanner;

public class Rabbit extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	int weight = 5;
	int roughness = 3;
	
	
	Rabbit() {
		do {
			System.out.println("What is your Rabbit's name? ");
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
	



	public String toString(){
		return name + " the Rabbit";
	}
	


}
