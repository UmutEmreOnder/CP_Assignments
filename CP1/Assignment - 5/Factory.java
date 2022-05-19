public class Factory {
	/*
	 * Umut Emre Önder - 150119018
	 * Factory class is the main class of the past 4 classes. Does everything by communicating other classes
	 */
	private String name;
	private Employee[] employees;
	private Storage storage;
	private Payroll[] payrolls;
	private double itemPrice;
	
	// Constructor
	public Factory(String name, int capacity, double itemPrice) {
		this.name = name;
		this.storage = new Storage(capacity);
		this.itemPrice = itemPrice;
	}
	
	// Method to calculate revenue 
	public double getRevenue() {
		return Item.numberOfItems * itemPrice;		
	}
	
	// Method to calculate total pay that should pay to employees
	public double getPaidSalaries() {
		double sum = 0;
		for(int i = 0; i < this.payrolls.length; i++) {
			sum += this.payrolls[i].calculateSalary();
		}
		return sum;
	}
	
	// Method to add an employee to the factory
	public void addEmployee(Employee employee) {
		// Adding the employee to the employees array
		this.employees = addEmployeeList(this.employees, employee);
		// After the adding process we start the shift for the employee and add the every item to the storage that s/he produced
		Item[] itemList = employee.startShift();
		for(int i = 0; i < itemList.length; i++) {
			this.storage.addItem(itemList[i]);
		}
		// If the storage is full, we set the numberOfItems to the factory's storage's capacity.
		if (Item.numberOfItems > this.storage.getCapacity()) {
			Item.numberOfItems = this.storage.getCapacity();
		}
	}
	
	// Method to remove an employee from the factory
	public Employee removeEmployee(int id) {
		Employee removedEmployee = null;
		/*
		 *  If the employees array never created, so if it is null
		 *  Then print an appropriate error message, and return the removed employee which is null for that situation
		 */
		if (this.employees == null) {
			System.out.println("There are no employees!\n");
			return removedEmployee;
		}
		
		// Checking the employees id from every index of the employee length
		boolean match = false;
		for(int i = 0; i < this.employees.length; i++) {
			// If the given id matches an employees id
			if(this.employees[i].getId() == id) {
				removedEmployee = this.employees[i];
				// Removing the employee from the employees array
				this.employees = removeEmployeeList(this.employees, i);
				match = true;
			}
		}
		// If there is no match then print an appropriate error message, and return the removed employee which is null for that situation
		if(!match) {
			System.out.println("Employee does not exist!\n");
			return removedEmployee;
		}
		// If there is match, then add the Payroll of the removed employee to the payrolls array
		if(match) {
			addPayroll(removedEmployee.endShift()); 
		}
		return removedEmployee;
		
	}
	
	// Method to add a payroll to the payroll list
	private void addPayroll(Payroll payroll) {
		this.payrolls = addPayrollList(this.payrolls, payroll);
	}
	

	
	// Method to adding an item to an array which has no space, has been explained in the storage class
	 
	public Employee[] addEmployeeList(Employee[] list, Employee employee) {
		int newSize;
		if (list == null) {
			newSize = 1;
			Employee[] listNew = new Employee[newSize];
			listNew[0] = employee;
			return listNew;
		}
		else {
			newSize = list.length + 1;
			Employee[] listNew = new Employee[newSize];
			for(int i = 0; i < list.length; i++) {
				listNew[i] = list[i];
			}
			listNew[listNew.length - 1] = employee;
			return listNew;
		}		
	}
		
	private Payroll[] addPayrollList(Payroll[] list, Payroll payroll) {
		int newSize;
		if(list == null) {
			newSize = 1;
			Payroll[] listNew = new Payroll[newSize];
			listNew[0] = payroll;
			return listNew;
		}
		else {
			newSize = list.length + 1;
			Payroll[] listNew = new Payroll[newSize];
			for(int i = 0; i < list.length; i++) {
				listNew[i] = list[i];
			}
			listNew[listNew.length - 1] = payroll;
			return listNew;
		}		
	}
	
	/*
	 * To remove an item from an array and then resize the array we need to create a new array that has 1 less length
	 * And then we need to swap the item that we want to delete with the last index of the old array
	 * So when the item that we want to delete is at the last index of the old array, we need to put every item in that old array to the new array except the last index
	 * So at the end, we got an array that does not have the item we want to remove
	 */
	public Employee[] removeEmployeeList(Employee[] list, int index) {
		int lastIndex = list.length - 1;
		// Swapping the item will be removed with the last index of the array
		Employee temp = list[lastIndex];
		list[lastIndex] = list[index];
		list[index] = temp;
		// Creating a new array that has 1 less length
		Employee[] listNew = new Employee[list.length - 1];
		// Put the every item in the given array to the new array, except the last index
		for(int i = 0; i  < listNew.length; i++) {
			listNew[i] = list[i];
		}
		// Return the new array
		
		/*
		 *  Put the old last index to the last index again
		 *  Unless the given index is the last index of the array, because we didnt swap anything in that situation
		 */
		if (index != list.length -1) {
			temp = listNew[index];
			// Shifting the array 1 left from the removed index
			for(int i = index; i < listNew.length-1; i++) {
				listNew[i] = listNew[i+1];
			}
			// Putting the last employee of the old array to last index of the new array
			listNew[listNew.length - 1] = temp;
			return listNew;
		}
		return listNew;
	}

	// Getters and setters	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Storage getStorage() {
		return storage;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public Payroll[] getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(Payroll[] payrolls) {
		this.payrolls = payrolls;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
