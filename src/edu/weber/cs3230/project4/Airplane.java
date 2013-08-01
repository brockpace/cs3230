package edu.weber.cs3230.project4;

import java.util.ArrayList;
import java.util.Random;

public class Airplane {
	private Seat[][] firstClassLeft;
	private Seat[][] firstClassRight;
	private Seat[][] economyLeft;
	private Seat[][] economyRight;
	private MenuItem[] drinks;
	private MenuItem[] snacks;
	
	//Default Constructor
	public Airplane() {
		firstClassLeft = new Seat[5][2];
		firstClassRight = new Seat[5][2];
		economyLeft = new Seat[15][3];
		economyRight = new Seat[15][3];
		
		//Drinks
		drinks = new MenuItem[5];
		drinks[0] = new MenuItem("water", 0.0);
		drinks[1] = new MenuItem("soda", 2.0);
		drinks[2] = new MenuItem("juice", 2.5);
		drinks[3] = new MenuItem("cofee", 3.0);
		drinks[4] = new MenuItem("alcohol", 5.0);
		
		//Snacks
		snacks = new MenuItem[5];
		snacks[0] = new MenuItem("peanuts", 0.0);
		snacks[1] = new MenuItem("fruit", 2.0);
		snacks[2] = new MenuItem("trailmix", 2.5);
		snacks[3] = new MenuItem("chips", 3.0);
		snacks[4] = new MenuItem("combo", 6.0);
		
		//create first class seats
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 2; j++){
				if(j % 2 == 0){
					firstClassLeft[i][j] = new Seat("window", true);
					firstClassRight[i][j] = new Seat("aisle", true);
				}
				else{
					firstClassLeft[i][j] = new Seat("aisle", true);
					firstClassRight[i][j] = new Seat("window", true);
				}
			}
		}
		
		//create economy seats
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 3; j++){
				if(j == 0){
					economyLeft[i][j] = new Seat("window", true);
					economyRight[i][j] = new Seat("aisle", true);
				}
				else if(j == 1){
					economyLeft[i][j] = new Seat("center", true);
					economyRight[i][j] = new Seat("center", true);
				}
				else if(j == 2){
					economyLeft[i][j] = new Seat("aisle", true);
					economyRight[i][j] = new Seat("window", true);
				}
			}
		}
	}
	
	public Airplane(int firstClassRows, int firstClassSeats, int economyRows, int economySeats) {
		
		//Drinks
		drinks = new MenuItem[5];
		drinks[0] = new MenuItem("water", 0.0);
		drinks[1] = new MenuItem("soda", 2.0);
		drinks[2] = new MenuItem("juice", 2.5);
		drinks[3] = new MenuItem("cofee", 3.0);
		drinks[4] = new MenuItem("alcohol", 5.0);
		
		//Snacks
		snacks = new MenuItem[5];
		snacks[0] = new MenuItem("peanuts", 0.0);
		snacks[1] = new MenuItem("fruit", 2.0);
		snacks[2] = new MenuItem("trailmix", 2.5);
		snacks[3] = new MenuItem("chips", 3.0);
		snacks[4] = new MenuItem("combo", 6.0);
		
		this.firstClassLeft = new Seat[firstClassRows][firstClassRows];
		this.firstClassRight = new Seat[firstClassSeats][firstClassSeats];
		this.economyLeft = new Seat[economyRows][economySeats];
		this.economyRight = new Seat[economyRows][economySeats];
		
		//create seats
		for(int i = 0; i < firstClassRows; i++){
			for(int j = 0; j < firstClassSeats; j++){
				if(j % 2 == 0){
					firstClassLeft[i][j] = new Seat("window", true);
					firstClassRight[i][j] = new Seat("aisle", true);
				}
				else{
					firstClassLeft[i][j] = new Seat("aisle", true);
					firstClassRight[i][j] = new Seat("window", true);
				}
			}
		}
	}
	
	public boolean addPassengers(String classType, int passengerCount, String seatPreference) {
		switch (classType.toLowerCase()) {
			default: case "economy":
				if(passengerCount == 1){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							if(economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j].isAvailable()){
								economyLeft[i][j].setAvailable(false);
								return true;
							}
							else if(economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j].isAvailable()){
								economyRight[i][j].setAvailable(false);
								return true;
							}
						}
					}
					return false;
				}	//End 1 Passenger
				else if(passengerCount == 2){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							//Left Side
							if(economyLeft[i][j].isAvailable() && seatPreference.compareToIgnoreCase("window") == 0 &&
									economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j+1].isAvailable()) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j+1].setAvailable(false);
								return true;
							}
							else if(economyLeft[i][j].isAvailable() && seatPreference.compareToIgnoreCase("center") == 0 &&
									economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && (economyLeft[i][j+1].isAvailable() ||
									economyLeft[i][j-1].isAvailable())) {
								economyLeft[i][j].setAvailable(false);
								if(economyLeft[i][j+1].isAvailable())
									economyLeft[i][j+1].setAvailable(false);
								else 
									economyLeft[i][j-1].setAvailable(false);
								return true;
							}
							else if(economyLeft[i][j].isAvailable() && seatPreference.compareToIgnoreCase("aisle") == 0 &&
									economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j-1].isAvailable() ) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j-1].setAvailable(false);
								return true;
							}
							
							//Right Side
							else if(economyRight[i][j].isAvailable() && seatPreference.compareToIgnoreCase("aisle") == 0 &&
									economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j+1].isAvailable()) {
								economyRight[i][j].setAvailable(false);
								economyRight[i][j+1].setAvailable(false);
								return true;
							}
							else if(economyRight[i][j].isAvailable() && seatPreference.compareToIgnoreCase("center") == 0 &&
									economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && (economyRight[i][j+1].isAvailable() ||
									economyRight[i][j-1].isAvailable())) {
								economyRight[i][j].setAvailable(false);
								if(economyRight[i][j+1].isAvailable())
									economyRight[i][j+1].setAvailable(false);
								else 
									economyRight[i][j-1].setAvailable(false);
								return true;
							}
							else if(economyRight[i][j].isAvailable() && seatPreference.compareToIgnoreCase("window") == 0 &&
									economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j-1].isAvailable() ) {
								economyRight[i][j].setAvailable(false);
								economyRight[i][j-1].setAvailable(false);
								return true;
							}
							
						}
					}
					return false;
				}	//End 2 Passengers
				else if(passengerCount == 3){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							//Left Side
							if(j == 0 && economyLeft[i][j].isAvailable() && economyLeft[i][j+1].isAvailable() && economyLeft[i][j+2].isAvailable()) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j+1].setAvailable(false);
								economyLeft[i][j+2].setAvailable(false);
								return true;
							}
							else if(j == 0 && economyRight[i][j].isAvailable() && economyRight[i][j+1].isAvailable() && economyRight[i][j+2].isAvailable()){
								economyRight[i][j].setAvailable(false);
								economyRight[i][j+1].setAvailable(false);
								economyRight[i][j+2].setAvailable(false);
								return true;
							}
						}
					}
					return false;
				}
				break;
			case "first class": case "firstclass":
				if(passengerCount == 1){
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft[0].length; j++){
							if(firstClassLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && firstClassLeft[i][j].isAvailable()){
								firstClassLeft[i][j].setAvailable(false);
								return true;
							}
							else if(firstClassRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && firstClassRight[i][j].isAvailable()){
								firstClassRight[i][j].setAvailable(false);
								return true;
							}
						}
					}
					return false;
				}	//End 1 Passenger
				else if(passengerCount == 2){
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft[0].length; j++){
							//Left Side
							if(j == 0 && firstClassLeft[i][j].isAvailable() && firstClassLeft[i][j+1].isAvailable()) {
								firstClassLeft[i][j].setAvailable(false);
								firstClassLeft[i][j+1].setAvailable(false);
								return true;
							}
							//Right Side
							else if(j == 0 && firstClassRight[i][j].isAvailable() && firstClassRight[i][j+1].isAvailable()) {
								firstClassRight[i][j].setAvailable(false);
								firstClassRight[i][j+1].setAvailable(false);
								return true;
							}
						}
					}
					return false;
				}	//End 2 Passengers
				break;
		}
		return false;
	}
	
	public void generatePurchases() {
		Random r = new Random();
		
		//Populate First Class with purchases
		for(int i = 0; i < firstClassLeft.length; i++){
			for(int j = 0; j < firstClassLeft[0].length; j++){
				if(!firstClassLeft[i][j].isAvailable()) {
					firstClassLeft[i][j].setDrink(drinks[r.nextInt(5)]);
					firstClassLeft[i][j].setSnack(snacks[r.nextInt(5)]);
				}
				if(!firstClassRight[i][j].isAvailable()) {
					firstClassRight[i][j].setDrink(drinks[r.nextInt(5)]);
					firstClassRight[i][j].setSnack(snacks[r.nextInt(5)]);
				}
			}
		}
		
		//Populate EconomyClass with purchases
		for(int i = 0; i < economyLeft.length; i++){
			for(int j = 0; j < economyLeft[0].length; j++){
				if(!economyLeft[i][j].isAvailable()) {
					economyLeft[i][j].setDrink(drinks[r.nextInt(5)]);
					economyLeft[i][j].setSnack(snacks[r.nextInt(5)]);
				}
				if(!economyRight[i][j].isAvailable()) {
					economyRight[i][j].setDrink(drinks[r.nextInt(5)]);
					economyRight[i][j].setSnack(snacks[r.nextInt(5)]);
				}
			}
		}
	}
	
	public boolean orderSnack(String classType, int row, int col, int snack) {
		row--; col--;
		//First Class
		if(classType.compareTo("firstclass") == 0) {
			if(col < firstClassLeft[0].length && !firstClassLeft[row][col].isAvailable()){
				firstClassLeft[row][col].setSnack(snacks[snack]);
				return true;
			}
			else if(col >= firstClassLeft[0].length && !firstClassRight[row][col-firstClassRight[0].length].isAvailable()) {
				firstClassRight[row][col-firstClassRight[0].length].setSnack(snacks[snack]);
				return true;
			}
		}

		//Economy
		else if(classType.compareTo("economy") == 0) {
			if(col < economyLeft[0].length && !economyLeft[row][col].isAvailable()) {
				economyLeft[row][col].setSnack(snacks[snack]);
				return true;
			}
			else if(col >= economyLeft[0].length && !economyRight[row][col-economyRight[0].length].isAvailable()) {
				economyRight[row][col-economyRight[0].length].setSnack(snacks[snack]);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean orderDrink(String classType, int row, int col, int drink) {
		row--; col--;
		//First Class
		if(classType.compareTo("firstclass") == 0) {
			if(col < firstClassLeft[0].length && !firstClassLeft[row][col].isAvailable()) {
				firstClassLeft[row][col].setDrink(drinks[drink]);
				return true;
			}
			else if(col >= firstClassLeft[0].length-1 && !firstClassRight[row][col-firstClassRight[0].length].isAvailable()) {
				firstClassRight[row][col-firstClassRight[0].length].setDrink(drinks[drink]);
				return true;
			}
		}
		
		//Economy
		else if(classType.compareTo("economy") == 0) {
			if(col < economyLeft[0].length && !economyLeft[row][col].isAvailable()) {
				economyLeft[row][col].setDrink(drinks[drink]);
				return true;
			}
			else if(col >= economyLeft[0].length && !economyRight[row][col-economyRight[0].length].isAvailable()) {
				economyRight[row][col-economyRight[0].length].setDrink(drinks[drink]);
				return true;
			}
		}
		
		return false;
	}
	
	public MenuItem[] getDrinks() {
		return drinks.clone();
	}
	
	public MenuItem[] getSnacks() {
		return snacks.clone();
	}
	
	public int[] getFirstClassSnackItems() {
		int[] totals = new int[snacks.length];
		for(int h = 0; h < snacks.length; h++) {
			totals[h] = 0;
			for(int i = 0; i < firstClassLeft.length; i++){
				for(int j = 0; j < firstClassLeft[0].length; j++){
					if(!firstClassLeft[i][j].isAvailable()) {
						if(firstClassLeft[i][j].getSnack().getType().compareTo(snacks[h].getType()) == 0)
							totals[h]++;
					}
					if(!firstClassRight[i][j].isAvailable()) {
						if(firstClassRight[i][j].getSnack().getType().compareTo(snacks[h].getType()) == 0)
							totals[h]++;
					}
				}
			}
		}
		return totals;
	}
	
	public int[] getFirstClassDrinkItems() {
		int[] totals = new int[drinks.length];
		for(int h = 0; h < drinks.length; h++) {
			totals[h] = 0;
			for(int i = 0; i < firstClassLeft.length; i++){
				for(int j = 0; j < firstClassLeft[0].length; j++){
					if(!firstClassLeft[i][j].isAvailable()) {
						if(firstClassLeft[i][j].getDrink().getType().compareTo(drinks[h].getType()) == 0)
							totals[h]++;
					}
					if(!firstClassRight[i][j].isAvailable()) {
						if(firstClassRight[i][j].getDrink().getType().compareTo(drinks[h].getType()) == 0)
							totals[h]++;
					}
				}
			}
		}
		return totals;
	}
	
	public int[] getEconomySnackItems() {
		int[] totals = new int[snacks.length];
		for(int h = 0; h < snacks.length; h++) {
			totals[h] = 0;
			for(int i = 0; i < economyLeft.length; i++){
				for(int j = 0; j < economyLeft[0].length; j++){
					if(!economyLeft[i][j].isAvailable()) {
						if(economyLeft[i][j].getSnack().getType().compareTo(snacks[h].getType()) == 0)
							totals[h]++;
					}
					if(!economyRight[i][j].isAvailable()) {
						if(economyRight[i][j].getSnack().getType().compareTo(snacks[h].getType()) == 0)
							totals[h]++;
					}
				}
			}
		}
		return totals;
	}
	
	public int[] getEconomyDrinkItems() {
		int[] totals = new int[drinks.length];
		for(int h = 0; h < drinks.length; h++) {
			totals[h] = 0;
			for(int i = 0; i < economyLeft.length; i++){
				for(int j = 0; j < economyLeft[0].length; j++){
					if(!economyLeft[i][j].isAvailable()) {
						if(economyLeft[i][j].getDrink().getType().compareTo(drinks[h].getType()) == 0)
							totals[h]++;
					}
					if(!economyRight[i][j].isAvailable()) {
						if(economyRight[i][j].getDrink().getType().compareTo(drinks[h].getType()) == 0)
							totals[h]++;
					}
				}
			}
		}
		return totals;
	}
	
	public double getFirstClassTotalCost() {
		double total = 0;
		for(int i = 0; i < firstClassLeft.length; i++){
			for(int j = 0; j < firstClassLeft[0].length; j++){
				if(!firstClassLeft[i][j].isAvailable())
					total += firstClassLeft[i][j].totalCost();
				if(!firstClassRight[i][j].isAvailable())
					total += firstClassRight[i][j].totalCost();
			}
		}
		return total;
	}

	public double getEconomyTotalCost() {
		double total = 0;
		for(int i = 0; i < economyLeft.length; i++){
			for(int j = 0; j < economyLeft[0].length; j++){
				if(!economyLeft[i][j].isAvailable())
					total += economyLeft[i][j].totalCost();
				if(!economyRight[i][j].isAvailable())
					total += economyRight[i][j].totalCost();
			}
		}
		return total;
	}
	
	public ArrayList<Seat[][]> showSeating() {
		ArrayList<Seat[][]> seats = new ArrayList<Seat[][]>();
		seats.add(firstClassLeft);
		seats.add(firstClassRight);
		seats.add(economyLeft);
		seats.add(economyRight);
		return seats;
	}
}
