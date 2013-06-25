package edu.weber.cs3230.project2;

import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {

		PairOfDice computer = new PairOfDice();
		PairOfDice user = new PairOfDice();
		int computerGrandTotal = 0;
		int computerTurnTotal = 0;
		int userGrandTotal = 0;
		int userTurnTotal = 0;
		String winner = "";
		String turn = "user";
		boolean turnChanged = false;
		
		System.out.print("Welcome to the DiceGame. It's you against the computer. \n" +
				"You play by rolling the dice. The first player \n" +
				"to get 100 points wins. However, if you roll one 1 \n" +
				"you lose all the points you've accumulated in your	\n" +
				"turn. If you roll two 1's, you lose all your points. \n" +
				"You can turn the dice over at any time. \n" +
				"However, if you roll one or two 1's, you lose your \n" +
				"turn. I (the computer) play by the same rules, \n" +
				"except I'll always turn over the dice when I've \n" +
				"rolled 20 or more points in a single turn.	\n" +
				"Ready to begin? (Type 'y' when you're ready)\n");
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().toLowerCase();
		if(input.equals("y"))
		{
			while(winner == "")
			{
				turnChanged = false;
				
				if(turn == "user")
				{
					//user's turn
					System.out.println("You're rolling the dice...");
					user.roll();
					System.out.println("You rolled " + user.getDieValues()[0] + " " + user.getDieValues()[1]);
					
					//Check if user didn't roll a 1
					if(!user.equals(1))
					{
						userTurnTotal += user.getDiceSum();
						System.out.println("This gives you a turn total of");
						System.out.println(userTurnTotal);		
						System.out.println("and a grand total of");
						System.out.println(userTurnTotal + userGrandTotal);
						System.out.println("The computer has a total of");
						System.out.println(computerGrandTotal);
		
						System.out.println("Do you want to continue rolling? (Type 'y' or 'n')");
						input = in.nextLine().toLowerCase();
						if(input.equals("n"))
						{
							turn = "computer";
							userGrandTotal += userTurnTotal;
							userTurnTotal = 0;
							turnChanged = true;
						}
						else if(!input.equals("y"))
							System.exit(0);
						
					}
					//Check if user rolled two 1's
					else if(user.equals(1,1))
					{
						System.out.println("You got two 1's!");
						userTurnTotal = 0;
						userGrandTotal = 0;
						turn = "computer";
						turnChanged = true;
						System.out.println("Continue? (Type 'y' when you're ready to turn the dice over to me");
						input = in.nextLine().toLowerCase();
						if(!input.equals("y"))
							System.exit(0);
					}
					//Check if user rolled a 1
					else
					{
						System.out.println("You got a 1!");
						userTurnTotal = 0;
						turn = "computer";
						turnChanged = true;
						System.out.println("Continue? (Type 'y' when you're ready to turn the dice over to me");
						input = in.nextLine().toLowerCase();
						if(!input.equals("y"))
							System.exit(0);
					}
					
					//Check to see if user won
					if(userGrandTotal + userTurnTotal >= 100)
						winner = "user";
				} //End of User Turn
				else
				{
					//Computer's turn
					System.out.println("I'm rolling the dice...");
					computer.roll();
					System.out.println("I rolled " + computer.getDieValues()[0] + " " + computer.getDieValues()[1]);
					
					//Check if user didn't roll a 1
					if(!computer.equals(1))
					{
						computerTurnTotal += computer.getDiceSum();
						System.out.println("This gives me a turn total of");
						System.out.println(computerTurnTotal);						
						System.out.println("and a grand total of");
						System.out.println(computerTurnTotal + computerGrandTotal);
						System.out.println("You have a total of");
						System.out.println(userGrandTotal);
						System.out.println("Continue? (Type 'y')");
						input = in.nextLine().toLowerCase();
						if(!input.equals("y"))
							System.exit(0);
						
						if(computerTurnTotal >= 20)
						{
							turn = "user";
							turnChanged = true;
							computerGrandTotal += computerTurnTotal;
							computerTurnTotal = 0;
						}
	
					}
					//Check if computer rolled two 1's
					else if(computer.equals(1,1))
					{
						System.out.println("I got two 1's!");
						computerTurnTotal = 0;
						computerGrandTotal = 0;
						turn = "user";
						turnChanged = true;
						System.out.println("Continue? (Type 'y' when you're ready");
						input = in.nextLine().toLowerCase();
						if(!input.equals("y"))
							System.exit(0);
					}
					//Check if computer rolled a 1
					else
					{
						System.out.println("I got a 1!");
						computerTurnTotal = 0;
						turn = "user";
						turnChanged = true;
						System.out.println("Continue? (Type 'y' when you're ready");
						input = in.nextLine().toLowerCase();
						if(!input.equals("y"))
							System.exit(0);
					}
					
					//Check to see if computer won
					if(computerGrandTotal + computerTurnTotal >= 100)
						winner = "computer";
					
				} //End Computer's Turn
				
				if(turnChanged)
				{
					System.out.println("The score is: ");
					System.out.println("You: " + userGrandTotal);
					System.out.println("Computer: " + computerGrandTotal);
					System.out.println();
				}
				
			} //End Game Loop
		}
		else
			System.exit(0);
		
		if(winner == "user")
			System.out.println("\nGood job you won!");
		else
			System.out.println("\nBetter luck next time!");
	}

}
