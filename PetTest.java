import static org.junit.Assert.*;

import org.junit.Test;

public class PetTest {


	@Test
	public void toiletTest() {
		Tiger testTiger = new Tiger(3); //Dev Tiger mode -> Automatically sets name as John
		testTiger.setToiletLvl(100);
		String toilet = testTiger.getToilet();
		assertEquals("DESPERATELY needs Bathroom",toilet);
		testTiger.toilet();
		int toiletLevel = testTiger.getToiletLvl();
		assertEquals(0,toiletLevel);
		String toiletAfter = testTiger.getToilet();
		assertEquals("Does not need the bathroom",toiletAfter);
	}
	
	@Test
	public void sleepTest() {
		Tiger testTiger = new Tiger(3); //Dev Tiger mode -> Automatically sets name as John
		testTiger.setSleepLvl(100);
		String sleep = testTiger.getSleep();
		assertEquals("Exhausted",sleep);
		testTiger.sleep();
		int sleepLevel = testTiger.getToiletLvl();
		assertEquals(30,sleepLevel);
		String sleepAfter = testTiger.getSleep();
		assertEquals("Sleepy",sleepAfter);
	}
	
	@Test
	public void hungerTest() {
		Tiger testTiger = new Tiger(3); //Dev Tiger mode -> Automatically sets name as John
		Food steak = new Food("Steak",80,80,80);
		testTiger.setHungerLvl(100);
		String hunger = testTiger.getHunger();
		assertEquals("Starving",hunger);
		testTiger.feed(steak);
		int hungerLevel = testTiger.getToiletLvl();
		assertEquals(20,hungerLevel);
		String hungerAfter = testTiger.getHunger();
		assertEquals("Peckish",hungerAfter);
	}
	
	@Test
	public void happinessTest(){
		Tiger testTiger = new Tiger(3); //Dev Tiger mode -> Automatically sets name as John
		testTiger.setHungerLvl(100);
		testTiger.setSleepLvl(100);
		assertEquals("Miserable",testTiger.getHappiness());
		testTiger.setHungerLvl(0);
		testTiger.setSleepLvl(0);
		assertEquals(0,testTiger.getHappinessLvl());
		assertEquals("Happy",testTiger.getHappiness());
		
	}
	/*
	@Test
	public void deathTest(){
		Tiger testTiger = new Tiger(3);
		assertEquals(true,testTiger.getRevive());
		testTiger.setHungerLvl(100);
		testTiger.setSleepLvl(120);
		assertEquals(false,testTiger.getRevive());
		
	}*/

}
