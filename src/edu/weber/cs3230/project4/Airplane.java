package edu.weber.cs3230.project4;

import java.util.ArrayList;

public class Airplane {
	private Seat[][] firstClassLeft;
	private Seat[][] firstClassRight;
	private Seat[][] economyLeft;
	private Seat[][] economyRight;
	
	private int passengerCount;				//1-3
	private String seatPreference;			//aisle or window (first class) or aisle, center, or window (economy)
	private int seats;
	private int row;
	private int col;

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
		switch (classType.toLowerCase()) {
			default: case "economy":
				if(passengerCount == 1){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft.length; j++){
							if(economyLeft[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
							else if(economyRight[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
						}
					}
				}
				else if(passengerCount == 2){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft.length; j++){
							if(economyLeft[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
							else if(economyRight[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
						}
					}
				}
				else if(passengerCount == 3){
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft.length; j++){
							if(economyLeft[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
							else if(economyRight[i][j].getType() == seatPreference.toLowerCase()){
								break;
							}
						}
					}
				}
				break;
			case "first class": case "firstclass":
				
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
