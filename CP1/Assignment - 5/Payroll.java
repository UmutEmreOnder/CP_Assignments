public class Payroll {
	/*
	 * Umut Emre Önder - 150119018
	 * Payroll class to calculate the salary of an employee
	 */
	private int workHour, itemCount;
	
	// Constructor
	public Payroll(int workHour, int itemCount) {
		this.itemCount = itemCount;
		this.workHour = workHour;
	}
	
	// An employee gets 3 Liras for each workour and 2 Liras for each item he produced
	public int calculateSalary() {
		int forHour = this.workHour * 3;
		int forItem = this.itemCount * 2;
		return forHour + forItem;
	}
	
	// Returning the result sentence
	public String toString() {
		return "The work hour is " + this.workHour + " and the produced item count is " + this.itemCount + ".";
	}
	
	// Getters and setters	
	public int getWorkHour() {
		return workHour;
	}
	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}	
	
}
