package edu.weber.cs3230.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Appointment {
	private Date date;
	private String description;
	
	
	public Appointment() {
		this(2013, 1, 1, "This is a default appointment.");
	}
	
	public Appointment(int year, int month, int day, String description) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.date = calendar.getTime();
		this.description = description;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return (Date)date.clone();
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		if(calendar.getTime().compareTo(this.date) == 0)
			return true;
		else 
			return false;
	}	
}
