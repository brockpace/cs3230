package edu.weber.cs3230.project4;

import java.util.ArrayList;

public class Airplane {
	private Seat[][] firstClassLeft;
	private Seat[][] firstClassRight;
	private Seat[][] economyLeft;
	private Seat[][] economyRight;

	public Airplane() {
		firstClassLeft = new Seat[5][2];
		firstClassRight = new Seat[5][2];
		economyLeft = new Seat[15][3];
		economyRight = new Seat[15][3];
		
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
	
	public void addPassengers(String classType, int passengerCount, String seatPreference) {

		outerloop:
		switch (classType.toLowerCase()) {
			default: case "economy":
				if(passengerCount == 1){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							if(economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j].isAvailable()){
								economyLeft[i][j].setAvailable(false);
								break outerloop;
							}
							else if(economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j].isAvailable()){
								economyRight[i][j].setAvailable(false);
								break outerloop;
							}
						}
					}
				}	//End 1 Passenger
				else if(passengerCount == 2){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft.length; j++){
							//Left Side
							if(seatPreference.compareToIgnoreCase("window") == 0 && economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j+1].isAvailable()) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j+1].setAvailable(false);
								break outerloop;
							}
							else if(seatPreference.compareToIgnoreCase("center") == 0 && economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && (economyLeft[i][j+1].isAvailable() || economyLeft[i][j-1].isAvailable())) {
								economyLeft[i][j].setAvailable(false);
								if(economyLeft[i][j+1].isAvailable())
									economyLeft[i][j+1].setAvailable(false);
								else 
									economyLeft[i][j-1].setAvailable(false);
								break outerloop;
							}
							else if(seatPreference.compareToIgnoreCase("aisle") == 0 && economyLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyLeft[i][j-1].isAvailable() ) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j-1].setAvailable(false);
								break outerloop;
							}
							
							//Right Side
							else if(seatPreference.compareToIgnoreCase("aisle") == 0 && economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j+1].isAvailable()) {
								economyRight[i][j].setAvailable(false);
								economyRight[i][j+1].setAvailable(false);
								break outerloop;
							}
							else if(seatPreference.compareToIgnoreCase("center") == 0 && economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && (economyRight[i][j+1].isAvailable() || economyRight[i][j-1].isAvailable())) {
								economyRight[i][j].setAvailable(false);
								if(economyRight[i][j+1].isAvailable())
									economyRight[i][j+1].setAvailable(false);
								else 
									economyRight[i][j-1].setAvailable(false);
								break outerloop;
							}
							else if(seatPreference.compareToIgnoreCase("window") == 0 && economyRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && economyRight[i][j-1].isAvailable() ) {
								economyRight[i][j].setAvailable(false);
								economyRight[i][j-1].setAvailable(false);
								break outerloop;
							}
							
						}
					}
				}	//End 2 Passengers
				else if(passengerCount == 3){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft.length; j++){
							//Left Side
							if(j == 0 && economyLeft[i][j].isAvailable() && economyLeft[i][j+1].isAvailable() && economyLeft[i][j+2].isAvailable()) {
								economyLeft[i][j].setAvailable(false);
								economyLeft[i][j+1].setAvailable(false);
								economyLeft[i][j+2].setAvailable(false);
								break outerloop;
							}
							else if( j == 0 && economyRight[i][j].isAvailable() && economyRight[i][j+1].isAvailable() && economyRight[i][j+2].isAvailable()){
								economyRight[i][j].setAvailable(false);
								economyRight[i][j+1].setAvailable(false);
								economyRight[i][j+2].setAvailable(false);
								break outerloop;
							}
						}
					}
				}
				break;
			case "first class": case "firstclass":
				if(passengerCount == 1){
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft[0].length; j++){
							if(firstClassLeft[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && firstClassLeft[i][j].isAvailable()){
								firstClassLeft[i][j].setAvailable(false);
								break outerloop;
							}
							else if(firstClassRight[i][j].getType().compareToIgnoreCase(seatPreference) == 0 && firstClassRight[i][j].isAvailable()){
								firstClassRight[i][j].setAvailable(false);
								break outerloop;
							}
						}
					}
				}	//End 1 Passenger
				else if(passengerCount == 2){
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft.length; j++){
							//Left Side
							if(j == 0 && firstClassLeft[i][j].isAvailable() && firstClassLeft[i][j+1].isAvailable()) {
								firstClassLeft[i][j].setAvailable(false);
								firstClassLeft[i][j+1].setAvailable(false);
								break outerloop;
							}
							//Right Side
							else if(j == 0 && firstClassRight[i][j].isAvailable() && firstClassRight[i][j+1].isAvailable()) {
								firstClassRight[i][j].setAvailable(false);
								firstClassRight[i][j+1].setAvailable(false);
								break outerloop;
							}
						}
					}
				}	//End 2 Passengers
				break;
		}
	}
	
	public ArrayList<Seat[][]> showSeating() {
		ArrayList<Seat[][]> seats = new ArrayList<Seat[][]>();
		seats.add(firstClassLeft);
		seats.add(firstClassRight);
		seats.add(economyLeft);
		seats.add(economyRight);
		return seats;
	}
	
	public void quit() {
		
	}
}
