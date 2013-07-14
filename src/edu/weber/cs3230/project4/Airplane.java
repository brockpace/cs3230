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
		
		//create seats
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 2; j++){
				if(j % 2 == 0){
					firstClassLeft[i][j] = new Seat("aisle", true);
					firstClassRight[i][j] = new Seat("window", true);
				}
				else{
					firstClassLeft[i][j] = new Seat("window", true);
					firstClassRight[i][j] = new Seat("aisle", true);
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
					firstClassLeft[i][j] = new Seat("aisle", true);
					firstClassRight[i][j] = new Seat("window", true);
				}
				else{
					firstClassLeft[i][j] = new Seat("window", true);
					firstClassRight[i][j] = new Seat("aisle", true);
				}
			}
		}
	}
	
	public void addPassengers(String classType, int passengerCount, String seatPreference) {
		
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
