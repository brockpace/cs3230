package edu.weber.cs3230.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AppointmentTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Appointment appointment[] = new Appointment[5]; 
		appointment[0] = new Appointment(2013, 6, 4, "CS3230.");
		appointment[1] = new Onetime(2013, 6, 3, "This assignment is due.");
		appointment[2] = new Daily(2013, 6, 4, "Eat Dinner.", 2013, 6, 4, 2013, 8, 4);
		appointment[3] = new Monthly(2013, 6, 4, "Pay Power Bill.", 2013, 6, 4, 2013, 8, 4);
		
		String fileName = "appointments.txt";
		
		while(true) {
			System.out.print("1 to check for appointments\n2 to add an appointment\n3 to save an appointment\n4 to load an appointment\nWhat is your choice?");
			Scanner in = new Scanner(System.in);
			switch(in.nextInt()) {
			case 1:
				//Check for appointments
				System.out.print("Enter the year: ");
				int year = in.nextInt();
				System.out.print("Enter the month: ");
				int month = in.nextInt();
				System.out.print("Enter the day: ");
				int day = in.nextInt();
				
				System.out.println("Appointments that occur on that day:");
				for(Appointment a : appointment) {
					if(a != null && a.occursOn(year, month, day))
						System.out.println(a.getDescription());
				}	
				System.out.println();
				break;
			case 2:
				//Get new appointment from user:
				Scanner in2 = new Scanner(System.in);
			    System.out.print("Enter the appointment type: (Once, Daily, Monthly) ");
			    String type = in.next().toLowerCase();
			    System.out.print("Enter the appointment description: ");
			    String description = in2.nextLine();
			    System.out.print("Enter the appointment year: (2013) ");
			    int newYear = in.nextInt();
			    System.out.print("Enter the appointment month: (1) ");
			    int newMonth = in.nextInt();
			    System.out.print("Enter the appointment day: (15) ");
			    int newDay = in.nextInt();
			    int startYear = 0, startMonth = 0, startDay = 0, endYear = 0, endMonth = 0, endDay = 0;
			    
			    if(type.equals("monthly") || type.equals("daily"))
			    {
			    	System.out.println("Enter the start year: ");
			    	startYear = in.nextInt();
			    	System.out.println("Enter the start month: ");
			    	startMonth = in.nextInt();
			    	System.out.println("Enter the start day: ");
			    	startDay = in.nextInt();
			    	
			    	System.out.println("Enter the end year: ");
			    	endYear = in.nextInt();
			    	System.out.println("Enter the end month: ");
			    	endMonth = in.nextInt();
			    	System.out.println("Enter the end day: ");
			    	endDay = in.nextInt();
			    }
			    	
				switch (type){
					case "Monthly": case "monthly":
						appointment[4] = new Monthly(newYear, newMonth, newDay, description, 
								startYear, startMonth, startDay, endYear, endMonth, endDay);
						break;
					case "Daily": case "daily":
						appointment[4] = new Daily(newYear, newMonth, newDay, description, 
								startYear, startMonth, startDay, endYear, endMonth, endDay);
						break;
					case "Once": case "once": case "onetime": case "Onetime": default:
						appointment[4] = new Onetime(newYear, newMonth, newDay, description);
						break;
				}
				break;
			case 3:
				//Save Appointment
				if(appointment[4] != null)
				{
					appointment[4].save();
					System.out.println("Appointment Saved!");
				}
				else
					System.out.println("There is no appointment to save.  Please enter an appointment (option 2)");
				break;
			case 4:
				//Load Appointment				
				Scanner input;
				
				try {
					input = new Scanner(new File(fileName));
					int loadYear, loadMonth, loadDay, loadStartYear = 0, loadStartMonth = 0, loadStartDay = 0, 
							loadEndYear = 0, loadEndMonth = 0, loadEndDay = 0;
					String loadDescription = "";
					while (input.hasNextLine())
					{
						String line = input.nextLine();
						String appointmentRaw[] = line.split(" ");
						
						loadYear = Integer.parseInt(appointmentRaw[1]);
						loadMonth = Integer.parseInt(appointmentRaw[2]);
						loadDay = Integer.parseInt(appointmentRaw[3]);
						
						if(appointmentRaw[0].equalsIgnoreCase("Monthly") || appointmentRaw[0].equalsIgnoreCase("Daily"))
						{
							loadStartYear = Integer.parseInt(appointmentRaw[4]);
							loadStartMonth = Integer.parseInt(appointmentRaw[5]);
							loadStartDay = Integer.parseInt(appointmentRaw[6]);
							loadEndYear = Integer.parseInt(appointmentRaw[7]);
							loadEndMonth = Integer.parseInt(appointmentRaw[8]);
							loadEndDay = Integer.parseInt(appointmentRaw[9]);
							for(int i = 10; i < appointmentRaw.length; i++)
								loadDescription += appointmentRaw[i] + " ";
						}
						else
							for(int i = 4; i < appointmentRaw.length; i++)
								loadDescription += appointmentRaw[i] + " ";
						
						switch (appointmentRaw[0]){
							case "Monthly": case "monthly":
								appointment[4] = new Monthly(loadYear, loadMonth, loadDay, loadDescription, 
										loadStartYear, loadStartMonth, loadStartDay, loadEndYear, loadEndMonth, loadEndDay);
								break;
							case "Daily": case "daily":
								appointment[4] = new Daily(loadYear, loadMonth, loadDay, loadDescription, 
										loadStartYear, loadStartMonth, loadStartDay, loadEndYear, loadEndMonth, loadEndDay);
								break;
							case "Once": case "once": case "onetime": case "Onetime": default:
								appointment[4] = new Onetime(loadYear, loadMonth, loadDay, loadDescription);
								break;
						}
						System.out.println("Appointment Loaded!");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
					
			}
			
		}
		
		
		
//		System.out.println("Appointment: " + appointment[0].getDate().toString() + " Description: " + appointment[0].getDescription());
//		if(appointment[0].occursOn(2013, 6, 4))
//			System.out.println("Working");
//		
//		if(appointment[1].occursOn(2013, 6, 3))
//			System.out.println("Working");
	}
}
