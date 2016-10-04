package e3;

public class ProductionOrder implements Observer, DisplayElement {
	// Your code for the ProductionOrder class goes here
	private static int orderSequence;
	protected int ID;
	protected double minQuantity;
	protected Observable inventory;
	
	public ProductionOrder(double minQty,Observable inventory){
		orderSequence++;
		ID = orderSequence;
		minQuantity = minQty;
		this.inventory = inventory;
		((Inventory)inventory).registerObserver(this);
		double new_avail = ((Inventory)inventory).availableQuantity;
		double backord = ((Inventory)inventory).backorderedQuantity;
		update(new_avail,backord);
	
	}
	
	public void update(double availQty, double ordQty){
		if(ordQty-availQty>=minQuantity){
			display(ordQty-availQty);
			double new_avail = ((Inventory)inventory).availableQuantity+ordQty-availQty;
			double backord = ((Inventory)inventory).backorderedQuantity;
			((Inventory)inventory).updateQuantities(new_avail, backord);
			}
	}
	
	public void display(double dispQty){
		System.out.println("Production Order# "+ ID+", item "+((Inventory)inventory).product.name+", produced "+dispQty);
	}
	
	public String toString(){
		return "PO"+ID+" "+((Inventory)inventory).product.name+" "+minQuantity;
	}
			


}
