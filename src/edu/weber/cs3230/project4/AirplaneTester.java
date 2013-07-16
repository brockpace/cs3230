package edu.weber.cs3230.project4;

import java.util.ArrayList;

public class AirplaneTester {

	public static void main(String[] args) {
		Airplane airplane;
		
		//user input parameters from command line
		if(args != null && args.length == 4) {
			airplane = new Airplane(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		}
		else
			airplane = new Airplane();
		
		ArrayList<Seat[][]> seats = airplane.showSeating();
		Seat[][] firstClassLeft = seats.get(0);
		Seat[][] firstClassRight = seats.get(1);
		Seat[][] economyLeft = seats.get(2);
		Seat[][] economyRight = seats.get(3);
		
		economyRight[0][0].setAvailable(false);
		economyRight[0][1].setAvailable(false);
		economyRight[1][1].setAvailable(false);
		
		//Print out First Class Seating
		System.out.println("First Class Seating");
		for(int i = 0; i < firstClassLeft.length; i++){
			for(int j = 0; j < firstClassLeft[0].length; j++){
				System.out.print(firstClassLeft[i][j].getType() + " ");
			}
			System.out.print("  ");
			for(int j = 0; j < firstClassRight[0].length; j++){
				System.out.print(firstClassRight[i][j].getType() + " ");
			}
			System.out.println();
		}
		
		//Print out Economy Seating
		System.out.println("Economy Seating");
		for(int i = 0; i < economyLeft.length; i++){
			for(int j = 0; j < economyLeft[0].length; j++){
				System.out.print(economyLeft[i][j].getType() + " ");
			}
			System.out.print("  ");
			for(int j = 0; j < economyRight[0].length; j++){
				System.out.print(economyRight[i][j].getType() + " ");
			}
			System.out.println();
		}
	}

}
