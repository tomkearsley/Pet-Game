import java.util.ArrayList;

public class Food {
	int nutritionalValue;
	int tastiness;
	String name;
	int price;
	static ArrayList<Food> foodList = new ArrayList<Food>();
	// storing all food in this class instead of each having their own class
	public Food(String name,int nutritionalValue,int tastiness,int price){
		this.name = name;
		this.nutritionalValue = nutritionalValue;
		this.tastiness = tastiness;
		this.price = price;
	}
	
	public static void Foods(){

		
	
	//Foods
	Food steak = new Food("Steak",80,80,80);
	Food cake = new Food("Cake",10,50,30);
	Food milk =  new Food("Milk",40,20,30);
	Food fishFood = new Food("Fish Food",40,40,40);
	Food mouse = new Food("Mouse",40,40,40);
	Food bone = new Food("Bone",30,20,25);
	Food rabbitFood	= new Food("Rabbit Food",40,40,40);
	foodList.add(cake);
	foodList.add(steak);
	foodList.add(milk);
	foodList.add(fishFood);
	foodList.add(bone);
	foodList.add(rabbitFood);
	foodList.add(mouse);
	}
	
	public String toString(){
		return this.name + " $" + this.price;
	}
	
	public int getPrice(){
		return this.price;
	}
	
}
