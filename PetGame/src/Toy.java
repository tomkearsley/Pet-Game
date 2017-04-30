import java.util.ArrayList;

public class Toy {
	static ArrayList<Toy> toys = new ArrayList<Toy>();
	int durability;
	int price;
	String name;
	Toy(String name,int durability,int price){
		this.name = name;
		this.durability = durability;
		this.price = price;
	}
	
	public static void Toys(){
		Toy fishToy = new Toy("Artificial Cave",100,20);
		Toy ball = new Toy("Ball",50,10);
		Toy bone = new Toy("Bone",120,15);
		Toy tyre = new Toy("Tyre",60,80);
		Toy mouse = new Toy("Toy Mouse",50,5);
		Toy yarn = new Toy("Ball of Yarn",80,10);
		toys.add(fishToy);
		toys.add(ball);
		toys.add(bone);
		toys.add(tyre);
		toys.add(mouse);
		toys.add(yarn);
	}
	
	public String toString(){
		return this.name + " $" + this.price;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getDurability(){
		return this.durability;
	}


}
