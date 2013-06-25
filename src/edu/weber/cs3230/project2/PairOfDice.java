package edu.weber.cs3230.project2;

public class PairOfDice {

	private Die firstDie;
	private Die secondDie;
	
	public PairOfDice() {
		firstDie = new Die();
		secondDie = new Die();
	}
	
	public void setDieValues(int faceValue1, int faceValue2) {
		firstDie = new Die();
		secondDie = new Die();
		firstDie.setFaceValue(faceValue1);
		secondDie.setFaceValue(faceValue2);
	}
	
	public int[] getDieValues() {
		return new int[]{ firstDie.getFaceValue(), secondDie.getFaceValue() };
	}
	
	public void roll() {
		firstDie.roll();
		secondDie.roll();
	}
	
	public String toString() {
		return firstDie.getFaceValue() + " " + secondDie.getFaceValue();
	}
	
	public boolean equals(int value) {
		return firstDie.equals(value) || secondDie.equals(value);
	}
	
	public boolean equals(int value1, int value2) {
		return firstDie.equals(value1) && secondDie.equals(value2);
	}
	
	public int getDiceSum() {
		return firstDie.getFaceValue() + secondDie.getFaceValue();
	}
}
