package edu.weber.cs3230.project1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Appointment> loadedAppointments = new ArrayList<Appointment>();
		
		Appointment appointment[] = new Appointment[4];
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
				for(Appointment a : appointmentList)
					if(a != null && a.occursOn(year, month, day))
						System.out.println(a.getDescription());
				for(Appointment a : loadedAppointments)
					if(a != null && a.occursOn(year, month, day))
						System.out.println(a.getDescription());
				
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
			    	System.out.print("Enter the start year: ");
			    	startYear = in.nextInt();
			    	System.out.print("Enter the start month: ");
			    	startMonth = in.nextInt();
			    	System.out.print("Enter the start day: ");
			    	startDay = in.nextInt();
			    	
			    	System.out.print("Enter the end year: ");
			    	endYear = in.nextInt();
			    	System.out.print("Enter the end month: ");
			    	endMonth = in.nextInt();
			    	System.out.print("Enter the end day: ");
			    	endDay = in.nextInt();
			    }
			    	
				switch (type){
					case "Monthly": case "monthly":
						appointmentList.add(new Monthly(newYear, newMonth, newDay, description, 
								startYear, startMonth, startDay, endYear, endMonth, endDay));
						break;
					case "Daily": case "daily":
						appointmentList.add(new Daily(newYear, newMonth, newDay, description, 
								startYear, startMonth, startDay, endYear, endMonth, endDay));
						break;
					case "Once": case "once": case "onetime": case "Onetime": default:
						appointmentList.add(new Onetime(newYear, newMonth, newDay, description));
						break;
				}
				break;
			case 3:
				//Save Appointments
				if(!appointmentList.isEmpty())
				{
					save(appointmentList);
					appointmentList.clear();
					System.out.println("Appointments Saved!");
				}
				else
					System.out.println("There are no appointments to save.  Please enter an appointment (option 2)");
				break;
			case 4:
				//Load Appointments				
				Scanner input;
				
				loadedAppointments.clear();
				
				try {
					input = new Scanner(new File(fileName));
					int loadYear, loadMonth, loadDay, loadStartYear = 0, loadStartMonth = 0, loadStartDay = 0, 
							loadEndYear = 0, loadEndMonth = 0, loadEndDay = 0;
					String loadDescription, line;
					while (input.hasNextLine())
					{
						loadDescription = "";
						line = input.nextLine();
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
								loadedAppointments.add(new Monthly(loadYear, loadMonth, loadDay, loadDescription, 
										loadStartYear, loadStartMonth, loadStartDay, loadEndYear, loadEndMonth, loadEndDay));
								break;
							case "Daily": case "daily":
								loadedAppointments.add(new Daily(loadYear, loadMonth, loadDay, loadDescription, 
										loadStartYear, loadStartMonth, loadStartDay, loadEndYear, loadEndMonth, loadEndDay));
								break;
							case "Once": case "once": case "onetime": case "Onetime": default:
								loadedAppointments.add(new Onetime(loadYear, loadMonth, loadDay, loadDescription));
								break;
						}
					}
					System.out.println("Appointments Loaded!");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
					
			}
			
		}
	}
	
	public static void save(ArrayList<Appointment> appointments) {
		File inputFile = new File("appointments.txt");
		if (!inputFile.exists()) {
			try {
				inputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
			PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(inputFile, true)));
			for(Appointment a : appointments) {
				String type[] = a.getClass().getName().split("\\.");
				
				if(type[type.length - 1].equalsIgnoreCase("Daily"))
					out.println(type[type.length - 1] + " " + dateFormat.format(a.getDate()) + " "
							+ dateFormat.format( ((Daily)a).getStartDate() ) + " " 
							+ dateFormat.format( ((Daily)a).getEndDate() ) + " " + a.getDescription());
				else if(type[type.length - 1].equalsIgnoreCase("Monthly"))
					out.println(type[type.length - 1] + " " + dateFormat.format(a.getDate()) + " "
							+ dateFormat.format( ((Monthly)a).getStartDate() ) + " "
							+ dateFormat.format( ((Monthly)a).getEndDate() ) + " " + a.getDescription());
				else
					out.println(type[type.length - 1] + " " + dateFormat.format(a.getDate()) + " " + a.getDescription());
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
