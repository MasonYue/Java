package e3;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Observable {

	// Your code for Inventory class goes here
	protected List<Observer> observers;
	protected Product product;
	protected double availableQuantity;
	protected double backorderedQuantity;
	
	public Inventory(Product product){
		observers = new ArrayList<>();
		this.product = product;
		availableQuantity = 0.0;
		backorderedQuantity = 0.0;
	}
	
	protected void updateQuantities(double stock, double backord){
		this.availableQuantity = stock;
		this.backorderedQuantity = backord;
		notifyObserver();
		
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int i = observers.indexOf(o);
		if(i>=0)
			observers.remove(i);
	}
	
	public void notifyObserver(){
		for(int i=0; i<observers.size(); i++){
			Observer observer = (Observer) observers.get(i);
			observer.update(this.availableQuantity, this.backorderedQuantity);
		}
	}
	
	public String toString(){
		return product.toString()+", Available: "+availableQuantity+", Backorders: "+backorderedQuantity+"\n"+observers;
	}



}
