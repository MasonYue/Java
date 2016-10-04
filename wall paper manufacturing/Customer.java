package e3;

public class Customer {
	// Your full code for this class goes here
	protected int ID;
	protected String name;
	
	public Customer(int ID, String name){
		this.ID = ID;
		this.name = name;
	}
	
	public String toString(){
		return ID + " " + name;
	}
}