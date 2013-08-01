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
		
		//Testing
//		for (int i = 0; i < 10; i++)
//			airplane.addPassengers("firstclass", 2, "aisle");		
//		for (int i = 0; i < 30; i++)
//			airplane.addPassengers("economy", 3, "aisle");
		
		System.out.println("Welcome to CS3230 Airlines!");
		
		ArrayList<Seat[][]> seats;
		Seat[][] firstClassLeft;
		Seat[][] firstClassRight;
		Seat[][] economyLeft;
		Seat[][] economyRight;
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("\n1: Add Passengers");
			System.out.print("\n2: Show Seating");
			System.out.print("\n3: Order");
			System.out.print("\n4: List Charges");
			System.out.print("\n5: List Orders");
			System.out.print("\n0: Quit");
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
					else if (classType.compareTo("firstclass") == 0 || classType.compareTo("first class") == 0){
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
						if(seatPreference.compareTo("aisle") != 0 && seatPreference.compareTo("window") != 0){
							System.out.println("Seating Preference must be aisle or window");
							break;
						}
					}
					else{
						System.out.println("class must be economy or firstclass");
						break;
					}
					if(airplane.addPassengers(classType, passengers, seatPreference))
						System.out.println("Passenger(s) added successfully.");
					else
						System.out.println("The preferred seat(s) could not be found.  Please try a different selection.");
					break;
					
				case 2:
					//Print Seating
					seats = airplane.showSeating();
					firstClassLeft = seats.get(0);
					firstClassRight = seats.get(1);
					economyLeft = seats.get(2);
					economyRight = seats.get(3);
					
					//Draw front of plane
					System.out.println("      _-^-_");
					System.out.println("     /     \\");
					System.out.println("    /       \\");
					System.out.println("   /         \\");
					System.out.println("  /           \\");
					System.out.println(" /             \\");
					
					//Print out First Class Seating
					//System.out.println("\nFirst Class Seating");
					for(int i = 0; i < firstClassLeft.length; i++){
						System.out.print("| ");
						for(int j = 0; j < firstClassLeft[0].length; j++){
							if(firstClassLeft[i][j].isAvailable())
								System.out.print("O  ");
							else
								System.out.print("X  ");
						}
						System.out.print("   ");
						for(int j = 0; j < firstClassRight[0].length; j++){
							if(firstClassRight[i][j].isAvailable())
								System.out.print("O");
							else
								System.out.print("X");
							if(j == firstClassRight[0].length - 1)
								System.out.print(" ");
							else
								System.out.print("  ");
						}
						System.out.println("|");
					}
					
					//Print out Economy Seating
					//System.out.println("Economy Seating");
					for(int i = 0; i < economyLeft.length; i++){
						System.out.print("| ");
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
						System.out.println("|");
					}
					
					//Draw back of plane
					System.out.println(" \\             /    ");
					System.out.println("  \\           /    ");
					System.out.println("   \\         /   ");
					System.out.println("____\\       /____");
					System.out.println("-----\\     /-----");
					System.out.println("      \\   /");
					System.out.println("       \\ /");
					break;
				
				case 3:
					//Order Drinks/Snacks				
					int row; int col;
					String seating;
					System.out.print("What class (economy or firstclass)? ");
					seating = in.next().toLowerCase();
					if(seating.compareTo("firstclass") != 0 && seating.compareTo("economy") != 0) {
						System.out.println("Class must be economy or firstclass");	
						break;
					}
					System.out.print("Seat Row: ");
					row = in.nextInt();
					System.out.print("Seat Column: ");
					col = in.nextInt();
					System.out.print("Drink or Snack? ");
					String menuType = in.next().toLowerCase();
					switch(menuType){
						case "drink":
							for(int i = 0; i < airplane.getDrinks().length; i++) {
								System.out.println(i + ": " + airplane.getDrinks()[i].getType() + " $" + airplane.getDrinks()[i].getCost());
							}
							System.out.print("Your selection: ");
							int orderNumber = in.nextInt();
							
							if(airplane.orderDrink(seating, row, col, orderNumber))
								System.out.println("Drink ordered.");
							else
								System.out.println("Please make sure your seat row and column are correct.");
							break;
						
						case "snack":
							for(int i = 0; i < airplane.getSnacks().length; i++) {
								System.out.println(i + ": " + airplane.getSnacks()[i].getType() + " $" + airplane.getSnacks()[i].getCost());
							}
							System.out.print("Your selection: ");
							orderNumber = in.nextInt();
							if(airplane.orderSnack(seating,  row, col, orderNumber))
								System.out.println("Snack ordered.");
							else
								System.out.println("Please make sure your seat row and column are correct.");
							break;
						
						default:
							System.out.println("Please enter drink or snack.");
							break;
					}
					break;
					
				case 4:
					//airplane.generatePurchases();
					seats = airplane.showSeating();
					firstClassLeft = seats.get(0);
					firstClassRight = seats.get(1);
					economyLeft = seats.get(2);
					economyRight = seats.get(3);
					
					System.out.println("\nFirst Class:");
					for(int i = 0; i < firstClassLeft.length; i++){
						for(int j = 0; j < firstClassLeft[0].length; j++){
							System.out.println("Row: " + (i+1) + ", Col: " + (j+1) + "    Charges: $" + firstClassLeft[i][j].totalCost());
						}
						for(int j = 0; j < firstClassLeft[0].length; j++){
							System.out.println("Row: " + (i+1) + ", Col: " + (j+firstClassLeft[0].length+1) + "    Charges: $" + firstClassRight[i][j].totalCost());
						}
					}
					System.out.println("First Class Total Charges: $" + airplane.getFirstClassTotalCost());
					
					System.out.println("\nEconomy:");
					for(int i = 0; i < economyLeft.length; i++){
						for(int j = 0; j < economyLeft[0].length; j++){
							System.out.println("Row: " + (i+1) + ", Col: " + (j+1) + "    Charges: $" + economyLeft[i][j].totalCost());
						}
						for(int j = 0; j < economyLeft[0].length; j++){
							System.out.println("Row: " + (i+1) + ", Col: " + (j+economyLeft[0].length+1) + "    Charges: $" + economyRight[i][j].totalCost());
						}
					}
					System.out.println("Economy Total Charges:      $" + airplane.getEconomyTotalCost());
					System.out.println("\nGrand Total: $" + (airplane.getFirstClassTotalCost()+airplane.getEconomyTotalCost()));
					break;
					
				case 5:
					//Print out Snack and Drink Orders by class
					System.out.println("\nFirst Class:");
					for(int i = 0; i < airplane.getFirstClassDrinkItems().length; i++) {
						System.out.println(airplane.getDrinks()[i].getType() + ": " + airplane.getFirstClassDrinkItems()[i]);
					}
					for(int i = 0; i < airplane.getFirstClassSnackItems().length; i++) {
						System.out.println(airplane.getSnacks()[i].getType() + ": " + airplane.getFirstClassSnackItems()[i]);
					}
					
					System.out.println("\nEonomy:");
					for(int i = 0; i < airplane.getEconomyDrinkItems().length; i++) {
						System.out.println(airplane.getDrinks()[i].getType() + ": " + airplane.getEconomyDrinkItems()[i]);
					}
					for(int i = 0; i < airplane.getEconomySnackItems().length; i++) {
						System.out.println(airplane.getSnacks()[i].getType() + ": " + airplane.getEconomySnackItems()[i]);
					}
					break;
				
				default: case 0:
					in.close();
					System.exit(0);
					break;
			}
			
			
		}
	}
}
