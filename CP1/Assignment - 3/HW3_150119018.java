import java.util.Scanner;


public class HW3_150119018 {

	public static void main(String[] args) {
		/*	
		 *  This program draws a coordinate system and some geometric shapes on the console screen according to given data from the user
		 *  150119018 - Umut Emre Önder 
		 */
		
		// Infinite loop
		while (true) {
			
			// Defining variables for the geometric shapes
			double a,b,c;
			
			// Creating the scanner object
			Scanner input = new Scanner(System.in);
			
			// User select the shape type
			System.out.println("Which shape would you like to draw?\n"
					+ " 1. Line\n"
					+ " 2. Parabola\n"
					+ " 3. Circle\n"
					+ " 4. Exit");
			
			int shapeType = input.nextInt();
			
			// Switch cases for the shapeType
			switch (shapeType) {
			
			// Case1: Line Shape
			case 1:
				
				// Getting inputs about the line's formula
				System.out.println("Line formula is y = ax + b");
				System.out.print("Please enter coefficients a and b: ");
				a = input.nextDouble();
				b = input.nextDouble();
				
				// Drawing the coordinate system
				
				/* The main point of it, these y and x values are really the y and x in the coordinate system
				 * So the drawing algorithm check every (x,y) point in the area its defined
				 * It starts from (-10,10) and goes to (11,-11), it checks every point between these points
				 * Whether there should be a * (the line's points) |, - or space 
				 */
				
				// Decrease the y one by one since it is -11
				for (int y = 10; y >= -11; y--) {
					
					// Increase the x one by one since it is 11
					for (int x = -10; x <= 11; x++) {
						
						/*
						 * It checks the line first, if the line going through this point 
						 * (if the equation is valid at the point according to a and b)
						 * it puts a "*" here and goes back to line 56th 
						*/ 
						if (a * x + b == y) {
							// However if this point is topmost or rightmost point, it prints y or x instead of *
							if (x == 0 && y == 11) {
								System.out.print("y");
							}
							
							else if (y == 0 && x == 11) {
								System.out.print("x");
							}
							
							else {
							System.out.print("*");
							}
						}
						
						// If line doesn't intersect at this point, it checks other part
						else {
							
							// If x is 0 then there should be the horizontal line, this if block draw it
							if (x == 0) {
								// But if y is equal to 10 (the topmost point) it prints y instead of |
								if (y != 10) {
								System.out.print("|");
								}
								else {
									System.out.print("y");
								}
							}
							
							// If y is 0 then there should be the vertical line, this if block draw it
							else if (y == 0) {
								
								// But if x is equal to 11 (the rightmost point) it prints x instead of -
								if (x != 11) {
								System.out.print("-");
								}
								else {
									System.out.print("x");
								}
							}
							
							// If its neither (0,y) nor (x,0) nor the intersect point, it prints space
							else {
								System.out.print(" ");
							}
						}
					}
					
					// It goes one line down when x reaches its maximum point, and do the same steps since (11,-11) point
					System.out.println();
				}
				break;
			
			// Case2: Parabola Shape	
			case 2:
				System.out.println("Parabola formula is y = ax^2 + bx + c");
				System.out.print("Please enter coefficients a,b and c: ");
				a = input.nextDouble();
				b = input.nextDouble();
				c = input.nextDouble();
				
				for (int y = 10; y >= -11; y--) {
					for (int x = -10; x <= 11; x++) {
			
						if (a * x * x + b * x + c == y) {
							if (x == 0 && y == 11) {
								System.out.print("y");
							}
							else if (y == 0 && x == 11) {
								System.out.print("x");
							}
							else {
							System.out.print("*");
							}
						}
						
						else {
							if (x == 0) {
								if (y != 10) {
									System.out.print("|");
									}
									else {
										System.out.print("y");
									}
							}
							else if (y == 0) {
								if (x != 11) {
									System.out.print("-");
									}
									else {
										System.out.print("x");
									}
							}
							else {
								System.out.print(" ");
							}
						}
					}
					System.out.println();
				}	
				break;
			
			// Case3: Circle Shape	
			case 3:
				System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
				System.out.print("Please enter center's coordinates (a,b) and radius: ");
				a = input.nextDouble();
				b = input.nextDouble();
				double r = input.nextDouble();
				
				for (int y = 10; y >= -11; y--) {
					for (int x = -10; x <= 11; x++) {
			
						if (Math.pow(x-a, 2) + Math.pow(y-b, 2) == r*r) {
							if (x == 0 && y == 11) {
								System.out.print("y");
							}
							else if (y == 0 && x == 11) {
								System.out.print("x");
							}
							else {
							System.out.print("*");
							}
						}
						
						else {
							if (x == 0) {
								if (y != 10) {
									System.out.print("|");
									}
									else {
										System.out.print("y");
									}
							}
							else if (y == 0) {
								if (x != 11) {
									System.out.print("-");
									}
									else {
										System.out.print("x");
									}
							}
							else {
								System.out.print(" ");
							}
						}
					}
					System.out.println();
				}	
				break;
			
			// Case4: Exit
			case 4:
				
				/* At line 15 I defined the while loop, while (true)
				 * So it is a infinite loop, it never stops
				 * However when the user wants to exit, it give the input 4 and the program execute this case
				 * This case basically close the app
				 */
				System.exit(4);
				break;
	
			default:
				break;
			}
			
			// It goes one line down when the drawing finishes, just for visuality
			System.out.println();
		}
	}		
}
