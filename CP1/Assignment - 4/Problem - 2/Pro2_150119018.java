import java.util.Scanner;

public class Pro2_150119018 {

	public static void main(String[] args) {
		/*
		 * Umut Emre Önder - 150119018
		 * This program check a number validate with the luhn algorithm
		 */
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		// The given input can have spaces but the program cannot calculate with the spaces so weed to get rid of them
		
		// deleteSpace method deleting the every space in the given input
		String numberWithoutSpace = deleteSpace(number);
		
		/* 
		 * Checking the validate of the input first, if not stop the program
		 * If the given input has a character that is not digit or the input has less than or equal 1 number it is invalid
		 */ 
		for (int i = 0; i < numberWithoutSpace.length(); i++) {
			if(!Character.isDigit(numberWithoutSpace.charAt(i)) || numberWithoutSpace.length() <= 1) {
				System.out.println("Invalid Input !");
				System.exit(1);
			}
		}
		// DNumber is the doubled digits every second digit which starts from the rigth
		System.out.println("DNumber:" + DNumber(numberWithoutSpace));
		
		/*
		 * LNumber is the last form of our number 
		 * The algorith of the program is actually creating the LNumber and then add the every digit in this number, check the validity 
		 */
		String LNumber = LNumber(numberWithoutSpace);
		System.out.println("LNumber:" + LNumber);
		
		// Checking the validity
		if(validateNumber(LNumber)) {
			System.out.println("Number is Valid");
		}
		else {
			System.out.println("Number is Invalid");
		}
	}
	
	// Method to validating the given input
	public static boolean validateNumber (String number) {
		// If (sum of the every digit of the LNumber) % 10 == 0 then the number is valid  
		int sum = 0;
		
		for(int i = 0; i < number.length(); i++) {
			// char to int
			int digit = (int)(number.charAt(i) - '0');
			sum += digit;	
		}
		
		// returns true if the sum is evenly divisible by 10
		return sum % 10 == 0 && (sum / 10) % 2 == 0;
	}
	
	// Method to create the DNumber
	public static String DNumber (String number) {
		String DNumber = "";
		
		// For loop to check every digit of the number 
		for(int i = 0; i < number.length(); i++) {
			
			// Switch case to find the if the number length is even or odd
			switch (number.length() % 2) {
			
			// if it is even, then the first digit will be added to the DNumber string, the second one is will not. Instead of 2nd one we add "_" and go on in this pattern
			case 0:
				DNumber += number.charAt(i);
				i++;
				if(i < number.length()) {
					DNumber += "_";
				}

				break;
				
			// if it is odd, then the second digit will be added to the DNumber string but first digit will not. Instead of 1st one we add "_" and go on in this pattern
			case 1:
				DNumber += "_";
				i++;
				if(i < number.length()) {
					DNumber += number.charAt(i);
				}				
				break;

			default:
				break;
			}
		}
		
		return DNumber;
	}
	
	// Method to create LNumber
	public static String LNumber (String number) {
		
		// Converting the given String to int array for easier calculation
		int[] numberListWithoutSpaces = new int[number.length()];
		
		for(int i = 0; i < number.length(); i++) {
			// char to int
			int digit = (int)(number.charAt(i) - '0');
			numberListWithoutSpaces[i] = digit;
		}
		
		// The String that will be returned end of the method
		String LNumber = "";
		
		// Checking the every digit in the number
		for(int i = 0; i < number.length(); i++) {
			switch (number.length() % 2) {
			// If the number is even, we double the first digit and take the 2nd digit in natural form and go on in this pattern
			case 0:
				int doubledDigit0 = numberListWithoutSpaces[i] * 2;
				
				// If the doubled digit bigger than 9 we substract 9
				if(doubledDigit0 > 9) {
					doubledDigit0 -= 9;
				}
				
				// Add it to the LNumber
				LNumber += doubledDigit0;
				
				// Increase the i to reach the 2nd digit 
				i++;
				
				// This if condition necessary because while increasing the i in the loop, i could get larger value than the max index of the list
				if(i < number.length()) {
					LNumber += number.charAt(i);
				}
				
				break;
				
				
			// If the number is odd, we double the 2nd digit and take the 1st digit in natural form and go on in this pattern
			case 1:
				LNumber += number.charAt(i);
				
				i++;
				
				if(i < number.length()) {
					int doubledDigit1 = numberListWithoutSpaces[i] * 2;
					
					if(doubledDigit1 > 9) {
						doubledDigit1 -= 9;
					}
					
					LNumber += doubledDigit1;
				}
				break;
	
			default:
				break;
			}
		}
		return LNumber;
	}
	
	// Method to delete spaces 
	public static String deleteSpace(String number) {
		String newNumber = "";
		
		// Checks the every char in the string and if the char is not ' ' (space) add it to the newNumber
		for(int i = 0; i < number.length(); i++) {
			if(number.charAt(i) != ' ') {
				newNumber += number.charAt(i);
			}
		}
		// Returns the newNumber
		return newNumber;
	}
}