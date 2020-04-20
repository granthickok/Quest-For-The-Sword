package application.model;

/* Class for Item */

public class Item {
	
	public String iname; // Name of item

	public String stat; // Player stat effected

	public int change; // Amount stat is changed

	public int count; // Inventory amount

	public Item() { // Default constructor
		
		
		iname = "";
	
		stat = "";
	
		change = 0;
	
		count = 0;
		
	}

	public Item(String n, String s, int c, int i){ // Defined player constructor
		
		this.iname = n;
	
		this.stat = s;
	
		this.change = c;
	
		this.count = i;

	}
	

	
	public void setName(String n) {  // Return and set name
		
		this.iname = n;
		
	}

	public String getName() { 
		
		return iname;
		
	}

	public void setStat(String s) {  // Return and set stat
		
		this.stat = s;
		
	}

	public String getStat() { 
		
		return stat;
		
	}

	public void setChange(int c) {  // Return and set change
		
		this.change = c;
		
	}

	public int getChange() { 
		
		return change;
		
	}

	public void setCount(int c) {  // Return and set count
		
		this.count = c;
		
	}
	
	public int getCount() {
		
		return count;
		
	}

}
