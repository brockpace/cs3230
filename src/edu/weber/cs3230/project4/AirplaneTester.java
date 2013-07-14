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
		for(int i = 0; i < firstClassLeft.length; i++){
			for(int j = 0; j < firstClassLeft[0].length; j++){
				System.out.print(firstClassLeft[i][j].isAvailable() + "    " + firstClassRight[i][j].isAvailable() + " ");
			}
			System.out.println();
		}
	}

}
