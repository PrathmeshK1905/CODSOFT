package Task_1;

import java.util.*;

public class Number_Game {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the maximum value of your range ");
		int max = sc.nextInt();
		
		
		System.out.println("Enter the minimum value of your range ");
		int min = sc.nextInt();
		
		
		int total_attempts = 0;
		int max_attempts = 10;
		int secret_Number = new Random().nextInt(max - min + 1) + min;
		
		while(total_attempts <= max_attempts)
		{
			System.out.println("Enter your guess for the number ");
			int ur_guess = sc.nextInt();
			total_attempts ++;
		
		
			if(secret_Number == ur_guess)
			{
				System.out.println("You win !!!... in "+ total_attempts + " attempts");
				
				break;
			}
			else if( secret_Number > ur_guess)
			{
				System.out.println("Your guess is less than the number!");
				
			}
			else
			{
				System.out.println("Your guess is greater than the number!");
				
			}
		}
		
		System.out.println("All your attempts are over. You lost the game!!!");
			
	}

	
}