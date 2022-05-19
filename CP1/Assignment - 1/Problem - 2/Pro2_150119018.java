import java.util.Scanner;

public class Pro2_150119018 {
	
	public static void main(String[] args) {
		/*	This program calculates the compound monthly interest with given variables. 
		 * 	Umut Emre Önder - 150119018
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("Enter initial principle balance: ");
		double initalBalance = input.nextDouble();
		System.out.print("Enter yearly interest rate (Ex: 9.45): ");
		double annualInterestRate = input.nextDouble();
		System.out.print("Enter monthly time periods (Ex: 8): ");
		double periods = input.nextDouble();
		double monthlyInterestRate = annualInterestRate / 1200.0; // We divide the annual rate first 12 (12 months=1 year) than 100 because the given rate is percentage. We need to convert it to decimal.
		// We use the "(int/double)(value * 100) / 100.0" method to get values with 2 digits after decimal point
		double finalBalance = (double)(initalBalance * (Math.pow(1+monthlyInterestRate, periods) * 100) / 100.0);
		System.out.println("\nInitial Balance: " + initalBalance);
		System.out.println("Monthly Interest Rate: " + (int)(monthlyInterestRate * 10000) / 100.0); // But here we multiplied with 10000 because we need to convert the interest rate back to percentage type
		System.out.println("Total Compound Interest: " + (int)((finalBalance - initalBalance) * 100) / 100.0);
		System.out.println("Final Balance: " + (int)(finalBalance * 100) / 100.0);
	}
	
}
