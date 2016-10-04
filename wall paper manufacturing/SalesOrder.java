package e3;

public class SalesOrder implements Observer, DisplayElement {
	// Your code for SalesOrder class goes here
	private static int orderSequence;
	protected int ID;
	protected Customer customer;
	protected double quantity;
	protected Observable inventory;
	
	public SalesOrder(Customer customer, double quantity, Observable inventory){
		this.orderSequence ++;
		ID = orderSequence;
		this.customer = customer;
		this.quantity = quantity;
		this.inventory = inventory;
		if(this.ship(((Inventory)inventory).availableQuantity)){
			display(quantity);
			double new_quantity = ((Inventory)inventory).availableQuantity-quantity;
			double backord = ((Inventory)inventory).backorderedQuantity;
			((Inventory)inventory).updateQuantities(new_quantity, backord);
		}
		else{
			((Inventory)inventory).registerObserver(this);
			double old_quantity = ((Inventory)inventory).availableQuantity;
			double new_backord = ((Inventory)inventory).backorderedQuantity+quantity;
			((Inventory)inventory).updateQuantities(old_quantity, new_backord);
		}
		
		
	}
	
	public void update(double availQty, double ordQty){
		if(this.ship(availQty)){
			display(quantity);
			double new_quantity = ((Inventory)inventory).availableQuantity-quantity;
			double backord = ((Inventory)inventory).backorderedQuantity-quantity;
			((Inventory)inventory).removeObserver(this);
			((Inventory)inventory).updateQuantities(new_quantity, backord);
			
		}
		
	}

	public void display(double displayQuantity){
		System.out.println("Shipping Order# "+ID+" to "+customer.name+", Product: "+
				((Inventory)inventory).product.name+", "+"Quantity: "+displayQuantity);
	}
	
	private boolean ship(double availableQuantity){
		return availableQuantity >= this.quantity;	
	}
	
	public String toString(){
		return "SO"+ID+" "+((Inventory)inventory).product.name+" "+quantity;
	}


}