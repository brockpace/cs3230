package edu.weber.cs3230.project2;

public class RollingDice {

	public static void main(String[] args) {
		Die die = new Die();
		
		for(int i = 1; i < 6; i++)
		{
			die.roll();
			System.out.println("Roll " + i + ": " + die.getFaceValue());
			if(die.equals(1))
				System.out.println("This die is one!");
		}
	}

}
