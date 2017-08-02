import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest{

	@Test
	public void buyTest() {
		PetGame.initToys();
		PetGame.initFoods();
		Player transactionPlayer = new Player(3);// Runs Dev mode.
		transactionPlayer.buy(1); // Buys Artifical Reef $20.
		assertEquals(480,transactionPlayer.getBalance(),0); // Checks Balance
		
	}
	@Test
	public void sellTest(){
		PetGame.initFoods();
		PetGame.initToys();
		Player sellPlayer = new Player(3);
		sellPlayer.buy(1);
		sellPlayer.sell(1);
		assertEquals(490,sellPlayer.getBalance(),0);
		
	}
	@Test
	public void nameTest(){
		Player namePlayer = new Player(3);
		String name = namePlayer.getName();
		System.out.println(name);
		assertEquals("Tom",name);
	}
	
	@Test 
	public void PetListTest(){
		Player PetListPlayer = new Player(3);
		// Player has 3 pets
		int numPets = PetListPlayer.getNumPets();
		assertEquals(3,numPets);
	}
	
	
	
	

}
