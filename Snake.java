import java.util.Scanner;

public class Snake extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	
	
	Snake() {
		do {
			// init variables
			weight = 15;
			roughness = 3;
			favouriteToy = PetGame.getAvailableToys().get(4);
			
			// get name
			System.out.println("What is your Snake's name? ");
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
		return name + " the Snake";
	}


}
