package edu.weber.cs3230.project4;

public class MenuItem implements Cloneable {
	private String type;
	private double cost;
	
	public MenuItem() {
		type = "none";
		cost = 0.0;
	}
	
	public MenuItem(String type, double cost) {
		this.type = type;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public Object clone() {
	    try {
	        return super.clone();
	    } catch (Exception e) {
	        return null;
	    }
	}
}
