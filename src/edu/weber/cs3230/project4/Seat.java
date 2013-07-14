package edu.weber.cs3230.project4;

public class Seat {
	private String type;			//aisle, center or row
	private boolean available;		//true if no one has this seat
	
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

	public Seat(String type, boolean available) {
		this.type = type;
		this.available = available;
	}
	
}
