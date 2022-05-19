import java.util.Scanner;

public class Pro3_150119018 {

	public static void main(String[] args) {
		/*
		 * Umut Emre Önder - 150119018
		 * This program print a diamond pattern with letters
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Letter: ");
		
		String given = input.nextLine();
		
		// Checking validate of the input, if it is then print the shape.
		if(isValid(given)) {
			char letter = given.charAt(0);
			printDiamond(constructDiamond(letter));
		}
		
		// If not then give an error message
		else {
			System.out.println("Invalid Input !");
		}		
	}
	
	// Method to create the diamond shape in a 2 dimensional list 
	public static char[][] constructDiamond (char letter) {
		// To construct the shape, we need an uppercase latter
		char letterUp = Character.toUpperCase(letter);
		
		// Method to calculate the rown and column length
		int row = (letterUp - 'A') * 2 + 1;
		
		char[][] diamond = new char[row][row];
		
		
		for(int j = 0; j  < row; j++) {
			for(int i = 0; i < row; i++) {
				// In this shape we have 2 position for each letter except 1st and last row
				int position1, position2;
				
				// Calculating the position1 (the left one)
				position1 = row / 2 - j;
				// Get the absolute value of the position1 because it gets negative value after the middle 
				if (position1 < 0) {
					position1 *= -1;
				}
				
				// Calculating the position 2 (the right one)
				
				// If the current row is before the middle one
				if(j <= row / 2) {
					position2 = row / 2 + j;
				}
				// If the current rown is after the middle one
				else {
					position2 = row / 2 + (row - 1 - j);
				}
				
				
				// If the i (current position) is equal to position1 or position2 we print the letter
				if (i == position1 || i == position2) {
					// If the current row is before the middle one
					if (j <= row / 2) {
						diamond[j][i] = (char)('A' + j);
					}
					// If the current row is after the middle one
					else {
						diamond[j][i] = (char) ('A' + row - 1 - j);
					}
				}
				// Except these points print dot
				else {
					diamond[j][i] = '.';
				}
			}
		}
		return diamond;
	}
	
	// Method to print the every item in the 2 dimensional list
	public static void printDiamond (char[][] diamond) {
		for(int j = 0; j < diamond.length; j++) {
			for(int i = 0; i < diamond[j].length; i++) {
				System.out.print(diamond[j][i]);
			}
			// Goes 1 line down when the row is completed
			System.out.println();
		} 
	}
	
	// Checking the validate of the given input
	public static boolean isValid(String givenInput) {
		// If the given input length is not 1, then return false
		if(givenInput.length() != 1) {
			return false;
		}
		char letter = givenInput.charAt(0);
		// or the given input is not a letter, then return false
		if (!(letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z')) {
			return false;
		}
		// otherwise return true
		return true;
	}
}