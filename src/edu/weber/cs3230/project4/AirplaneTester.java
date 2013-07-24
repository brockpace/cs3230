package edu.weber.cs3230.project4;

import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneTester {

	public static void main(String[] args) {
		Airplane airplane;
		
		//user input parameters from command line
		if(args != null && args.length == 4) {
			airplane = new Airplane(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		}
		else
			airplane = new Airplane();
		
		
//		airplane.addPassengers("first class", 1, "window");
//		airplane.addPassengers("firstClass", 2, "window");
//		airplane.addPassengers("firstclass", 1, "window");
//		airplane.addPassengers("firstclass", 1, "window");
//		
//		airplane.addPassengers("economy", 2, "window");
//		airplane.addPassengers("economy", 2, "window");
//		airplane.addPassengers("economy", 1, "window");
//		airplane.addPassengers("economy", 3, "window");
//		
		
		System.out.println("Welcome to CS3230 Airlines!");
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("\n1: Add Passengers");
			System.out.print("\n2: Show Seating");
			System.out.print("\n3: Quit");
			System.out.print("\nYour Choice: ");
			int choice = in.nextInt();
			switch (choice) {
				case 1:
					String classType = "";
					int passengers = 0;
					String seatPreference = "";
					//Input class Type
					System.out.print("What class (economy or firstclass)? ");
					classType = in.next().toLowerCase();	
					if(classType.compareTo("economy") == 0){
						//Input number of passengers
						System.out.print("Number of Passengers (1-3): ");
						passengers = in.nextInt();
						if(passengers < 1 && passengers > 3){
							System.out.println("Number of passengers must be between 1 and 3");
							break;
						}
						//Input Seating Preference
						System.out.print("What is the seating preference (aisle, center, or window)? ");
						seatPreference = in.next().toLowerCase();
						if(seatPreference.compareTo("aisle") != 0 && seatPreference.compareTo("center") != 0 && seatPreference.compareTo("window") != 0){
							System.out.println("Seating Preference must be aisle, center, or window");
							break;
						}
					}
					else if (classType.compareTo("firstclass") == 0 && classType.compareTo("first class") == 0){
						//Input number of passengers
						System.out.print("Number of Passengers (1-2): ");
						passengers = in.nextInt();
						if(passengers < 1 && passengers > 2){
							System.out.println("Number of passengers must be between 1 and 2");
							break;
						}
						//Input Seating Preference
						System.out.print("What is the seating preference (aisle or window)? ");
						seatPreference = in.next().toLowerCase();
						if(seatPreference.compareTo("aisle") != 0 || seatPreference.compareTo("window") != 0){
							System.out.println("Seating Preference must be aisle or window");
							break;
						}
					}
					else{
						System.out.println("class must be economy or firstclass");
						break;
					}
					airplane.addPassengers(classType, passengers, seatPreference);
					System.out.println("Passenger(s) added successfully.");
					break;
					
				case 2:
					//Print Seating
					ArrayList<Seat[][]> seats = airplane.showSeating();
					Seat[][] firstClassLeft = seats.get(0);
					Seat[][] firstClassRight = seats.get(1);
					Seat[][] economyLeft = seats.get(2);
					Seat[][] economyRight = seats.get(3);
					
					//Print out First Class Seating
					System.out.println("\nFirst Class Seating");
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft[0].length; j++){
							if(firstClassLeft[i][j].isAvailable())
								System.out.print("O ");
							else
								System.out.print("X ");
						}
						System.out.print("  ");
						for(int j = 0; j < firstClassRight[0].length; j++){
							if(firstClassRight[i][j].isAvailable())
								System.out.print("O ");
							else
								System.out.print("X ");
						}
						System.out.println();
					}
					
					//Print out Economy Seating
					System.out.println("Economy Seating");
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							if(economyLeft[i][j].isAvailable())
								System.out.print("O ");
							else
								System.out.print("X ");
						}
						System.out.print("  ");
						for(int j = 0; j < economyRight[0].length; j++){
							if(economyRight[i][j].isAvailable())
								System.out.print("O ");
							else
								System.out.print("X ");
						}
						System.out.println();
					}
					break;
					
				default: case 3:
					System.exit(0);
					break;
			}
			
			
		}
	}
}
