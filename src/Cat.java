import java.util.Scanner;

public class Cat extends Pet{
	private Scanner in = new Scanner(System.in);
	private boolean nameInUse = false;
	
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
	
	@Override
	void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void feed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void toilet() {
		// TODO Auto-generated method stub
		
	}

}
