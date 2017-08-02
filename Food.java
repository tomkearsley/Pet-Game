

public class Food {
	String name;
	int nutritionalValue;
	int tastiness;
	int price;
	
	// storing all food in this class instead of each having their own class
	public Food(String name,int nutritionalValue,int tastiness,int price){
		this.name = name;
		this.nutritionalValue = nutritionalValue;
		this.tastiness = tastiness;
		this.price = price;
	}
	
	public String toString(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
}
