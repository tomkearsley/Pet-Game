

public class Toy {
	String name;
	int durability;
	int price;
	
	Toy(String name, int durability, int price) {
		this.name = name;
		this.durability = durability;
		this.price = price;
	}
	
	public String toString() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getDurability() {
		return durability;
	}


}
