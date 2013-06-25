package edu.weber.cs3230.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Daily extends Appointment {
	private Date startDate;
	private Date endDate;
	
	public Daily(int year, int month, int day, String description, int startYear, 
			int startMonth, int startDay, int endYear, int endMonth, int endDay) {
		super(year, month, day, description);
		GregorianCalendar start = new GregorianCalendar(startYear, startMonth - 1, startDay);
		GregorianCalendar end = new GregorianCalendar(endYear, endMonth - 1, endDay);
		this.startDate = start.getTime();
		this.endDate = end.getTime();
	}
	
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		Date date = calendar.getTime();
		if(!date.before(startDate) && !date.after(endDate))
			return true;
		else
			return false;
	}
	
	public void save() {
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
			PrintStream out = new PrintStream(inputFile);
			String type[] = this.getClass().getName().split("\\.");
			out.println(type[type.length - 1] + " " + dateFormat.format(super.getDate()) + " " + dateFormat.format(startDate) + " " + dateFormat.format(endDate) + " " + super.getDescription());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}				
	}
}
