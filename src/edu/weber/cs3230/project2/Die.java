package edu.weber.cs3230.project2;

import java.util.Random;

public class Die {
	
	public static final int MAX = 6;
	private int faceValue;
	
	//Default Constructor
	public Die() {
		faceValue = 1;
	}
	
	//Constructor
	public Die(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public void roll() {
		Random random = new Random();
		faceValue = random.nextInt(MAX) + 1;
	}
	
	public String toString() {
		return "" + faceValue;
	}
	
	public boolean equals(int value) {
		if(faceValue == value)
			return true;
		else 
			return false;
	}
}
