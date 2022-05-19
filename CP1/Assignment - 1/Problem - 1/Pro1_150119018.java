import java.util.Scanner;

public class Pro1_150119018 {

	public static void main(String[] args) {	
		/* This program gets a day value from the user and convert it to "year: months: days:" format. 
		 * Umut Emre Önder - 150119018
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("Number of days: ");
		int days = input.nextInt();
		int years = days / 365; // We get an int value from here so even the result of the division something like 1.4521 we only get the 1. 
		int remainingDays = days % 365; // To find the remainder of (days / 365)
		int months = remainingDays / 31;
		remainingDays %= 31; // To find the remainder of (remainingDays / 31). It's equals to the days in our format that we want to convert.
		System.out.println("Years: " + years + " Months: " + months + " Days: " + remainingDays);
	}

}
