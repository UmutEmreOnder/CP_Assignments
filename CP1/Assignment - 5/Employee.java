import java.util.Random;

public class Employee {
	/*
	 * Umut Emre Önder - 150119018
	 * Employee class to create employees, start their shift to create items that they can, and end their shift to calculate their salary
	 */
	private int id, workHour, speed;
	private String name, surname;
	private Item[] items;
	private Payroll payroll;
	
	// Constructor
	public Employee(int id, String name, String surname, int workHour, int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
	}
	
	// Method to create items with random and unique id and add them to items array 
	public Item[] startShift() {
		int numberOfItemsProduced = this.workHour * this.speed;
		this.items = new Item[numberOfItemsProduced];
		for(int i = 0; i < items.length; i++) {
			// To create unique random number I used seed, which is numberOfItems (it increases every time whenever this for loop executed)
			Random random = new Random(Item.numberOfItems);
			this.items[i] = new Item(random.nextInt(100) + 1);	
		}
		return this.items;
	}
	
	// Method to calculate the Payroll
	public Payroll endShift() {
		this.payroll = new Payroll(this.workHour, this.speed * this.workHour);
		return this.payroll;
	}
	
	// Returning the result sentence
	public String toString() {
		return "This is the employee with id " + this.id + " speed " + this.speed + ". The work hour is " + this.workHour + " and the produced item count is " + (this.workHour * this.speed) + ".";
	}

	// Getters and setters
	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
} 
