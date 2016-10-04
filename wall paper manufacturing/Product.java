package e3;

public class Product {
	
	// Your code for the product class goes here
	protected int ID;
	protected String name;
	
	public Product(int ID, String name){
		this.ID = ID;
		this.name = name;
	}
	
	public String toString(){
		return ID + " " + name;
	}
}