public class Item {
	/*
	 * Umut Emre Önder - 150119018
	 * Item class to create an item with given id and store the number of items created
	 */
	private int id;
	public static int numberOfItems;
	
	// Consturctor
	public Item(int id) {
		// Number of items increases whenever an item object created
		numberOfItems++;
		this.id = id;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static int getNumberOfItems() {
		return numberOfItems;
	}
	public static void setNumberOfItems(int numberOfItems) {
		Item.numberOfItems = numberOfItems;
	}
}
