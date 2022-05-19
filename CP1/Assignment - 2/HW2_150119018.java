import java.util.Scanner;

public class HW2_150119018 {

	public static void main(String[] args) {
		/* 	This program calculates the tax you have to pay in Turkey, according to year and your income information.
		  	Umut Emre Önder - 150119018
		 */ 
		
		// Creating a scanner object to get inputs from the user
		Scanner input = new Scanner(System.in);
		
		// Getting inputs about the tax calculation
		int year = input.nextInt();
		double income = input.nextDouble();
		
		// If income is <= 0 show an error message and stop the program
		if (income <= 0) {
			System.out.println("Income must be > 0!");
			System.exit(0);
		}
		
		// Define a tax variable
		double tax = 0;
		
		// Calculating the tax according the year 		
		switch (year) {
			case 2020:
				if (income < 22000) {
					tax = income * 15 / 100;
				}
				else if (income < 49000) {
					tax = 3300 + ((income - 22000) * 20 / 100);
				}
				else if (income < 180000) {
					tax = 8700 + ((income - 49000) * 27 / 100);
				}
				else if (income < 600000) {
					tax = 44070 + ((income - 180000) * 35 / 100);
				}
				else {
					tax = 191070 + ((income - 600000) * 40 /100);
				}		
				break;
				
			case 2019:
				if (income < 18000) {
					tax = income * 15 / 100;
				}
				else if (income < 40000) {
					tax = 2700 + ((income - 18000) * 20 / 100);
				}
				else if (income < 148000) {
					tax = 7100 + ((income - 40000) * 27 / 100);
				}
				else if (income < 500000) {
					tax = 36260 + ((income - 148000) * 35 / 100);
				}
				else {
					tax = 163460 + ((income - 500000) * 40 /100);
				}		
				break;
				
			case 2018:
				if (income < 14800) {
					tax = income * 15 / 100;
				}
				else if (income < 34000) {
					tax = 2220 + ((income - 14800) * 20 / 100);
				}
				else if (income < 120000) {
					tax = 6060 + ((income - 34000) * 27 / 100);
				}
				else {
					tax = 29280 + ((income - 120000) * 35 / 100);
				}
				break;
				
			case 2017:
				if (income < 13000) {
					tax = income * 15 / 100;
				}
				else if (income < 30000) {
					tax = 1950 + ((income - 13000) * 20 / 100);
				}
				else if (income < 110000) {
					tax = 5350 + ((income - 30000) * 27 / 100);
				}
				else {
					tax = 26950 + ((income - 110000) * 35 / 100);
				}
				break;
				
			default:
				//If not any case fits, show an error message and stop the program
				System.out.println("Undefined year value!");
				System.exit(1);
		}
		
		// Calculating the other parts
		double newBalance = (int)((income - tax) * 100) / 100.0;
		double realTax = (int)((tax * 100 / income) * 100) / 100.0;
		
		// Showing the result		
		System.out.println("Income: " + income 
				+ "\nTax amount: " + (int)(tax * 100) / 100.0 
				+ "\nIncome after tax: " + newBalance 
				+ "\nReal tax rate: " + realTax + "%");
	}

}
