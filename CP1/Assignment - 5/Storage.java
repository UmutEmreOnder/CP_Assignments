public class Storage {
	/*
	 * Umut Emre Önder - 150119018
	 * Story class to store the items created by employees
	 */
	private int capacity;
	private Item[] items;
	
	// Constructor 
	public Storage(int capacity) {
		this.capacity = capacity;
	}
	
	// Method to add an item to the items array
	public void addItem(Item item) {
		// If it is the first item, first we need to create the array with 0 length.
		if (this.items == null) {
			this.items = new Item[0];
		}
		// Unless the storage is full
		if(this.items.length < this.capacity) {
			this.items = addItemList(this.items, item);
		}	
	}
	

	/* 
	 * To add an item to an array if the array is null, we create a list with length 1 and put that item to the list.
	 * If the array is not null then we need to resize the array. 
	 * To do that, actually we need to create a new array that has a 1 more space. 
	 * Then we need to fill the array with the old arrays item, then add the new item to the new space. 
	 */

	public Item[] addItemList(Item[] list, Item item) {
		// Determine the new size
		int newSize = list.length + 1;
		// Create the new list
		Item[] listNew = new Item[newSize];
		// Add the every item in the old array to the new array
		for(int i = 0; i < list.length; i++) {
			listNew[i] = list[i];
		}
		// Add the new item to the new array's last space
		listNew[listNew.length - 1] = item;
		// Return the new array
		return listNew;		
	}
	
	// Getters and setters	
	public int getCapacity() {
		return capacity;
	}	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
}
