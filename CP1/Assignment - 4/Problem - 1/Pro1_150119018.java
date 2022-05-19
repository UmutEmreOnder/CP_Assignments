import java.util.Scanner;

public class Pro1_150119018 {

	public static void main(String[] args) {
		/*
		 * Umut Emre Önder - 150119018
		 * This program calculate the bill that every flat should pay in an apartment that have central heating system
		 */
		
		// Array for storing the consumption of each flat
		double[] consumption;
		
		Scanner input = new Scanner(System.in);
		
		int numberOfHouses = input.nextInt();
		
		consumption = new double[numberOfHouses];
		
		//Getting every consumption of every flat
		for(int i = 0; i < consumption.length; i++) {
			consumption[i] = input.nextDouble();
		}
		
		double totalBill = input.nextDouble();
		
		//Printing the result
		printBills(calculateTheInvoice(consumption, totalBill));
	}
	
	//Method that calculate the money that every flat should pay
	public static double[] calculateTheInvoice (double[] flats, double totalBill) {
		// Array for storing the invoice for every flat
		double[] invoice = new double[flats.length];
		
		// 30% of the bill shared equally, 70% of the bill shared according the consumption of each flat
		double thirtyOfBill = totalBill * 30 / 100;
		double seventyOfBill = totalBill * 70 / 100;
		
		// Finding the total consumption of the apartment
		double sumOfTotalConsumption = 0;
		
		for(double value: flats) {
			sumOfTotalConsumption += value;
		}
		
		// Calculating the invoice of each flat
		for(int i = 0; i < invoice.length; i++) {
			// 30% of the bill sharing equally
			double sharedPart = thirtyOfBill / (double)(invoice.length);
			/*
			 *  70% of the bill sharing according the consumption
			 *  Algorith is;
			 *  - Find the percentage of the each flat's consumption (100 * flat[i] / sumOfTotalConsumption)
			 *  - Multiply it with the seventy of bill and divide it by 100 (100 * flat[i] / sumOfTotalConsumption * seventyOfBill / 100)
			 *  
			 *  So in short we get this method: flats[i] / sumOfTotalConsumption * seventyOfBill
			 */
			double consumptionSharingPart = flats[i] / sumOfTotalConsumption * seventyOfBill;
			double total = sharedPart + consumptionSharingPart;
			invoice[i] = total;
		} 

		return invoice;
	}
	// Printing the result
	public static void printBills (double[] bills) {
		// Variable to write the flat number
		int i = 1;
		
		// for each loop to print the every item in the list
		for(double value: bills) {
			System.out.println("Flat #" + i + ": " + get2Decimal(value));
			i++;
		}
	}
	
	// This method cut off the part after the 2nd decimal place
	public static double get2Decimal (double num) {
		double newNum = (int)(num * 100) / 100.0;
		return newNum;
	}
}