import java.util.Scanner;

public class Tiger extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	int weight = 300;
	int roughness = 30;

	
	
	Tiger() {
		do {
			System.out.println("What is your Tiger's name? ");
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
	
	Tiger(int dev){ // will expand upon later, add different hunger, tired, toilet,ect.
		name = "John";
		
	}





	
	public String toString(){
		return name + " the Tiger";
	}

}
