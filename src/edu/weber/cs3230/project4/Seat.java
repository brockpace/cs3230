package edu.weber.cs3230.project4;

public class Seat {
	private String type;			//aisle, center or row
	private boolean available;		//true if no one has this seat
	private MenuItem drink;
	private MenuItem snack;
	
	public Seat(String type, boolean available) {
		this.type = type;
		this.available = available;
		drink = new MenuItem();
		snack = new MenuItem();
	}
	
	public double totalCost(){
		if(drink != null && snack == null)
			return drink.getCost();
		else if(drink == null && snack != null)
			return snack.getCost();
		else if(drink != null && snack != null)
			return drink.getCost() + snack.getCost();
		return 0.0;
	}
	
	public MenuItem getDrink() {
		return (MenuItem)drink.clone();
	}
	
	public void setDrink(MenuItem drink) {
		this.drink = drink;
	}
	
	public MenuItem getSnack() {
		return (MenuItem)snack.clone();
	}
	
	public void setSnack(MenuItem snack) {
		this.snack = snack;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
