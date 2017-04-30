import java.util.Scanner;

public class Fish extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	public Toy favouriteToy = Toy.toys.get(0); //Fish Favourite toy, artifical rock.
	static int roughness = 10;
	Fish() {
		do {
			System.out.println("What is your Fish's name? ");
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
		return name + " the Fish";
	}


}
