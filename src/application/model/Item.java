/*
 * Class to handle various item creation/manipulations
 */

package application.model;

import java.util.ArrayList;

/* Class for Item */

public class Item {
	
	private String iname; // Name of item

	private String stat; // Player stat effected

	private int change; // Amount stat is changed

	public Item() { // Default constructor
		
		
		iname = "";
	
		stat = "";
	
		change = 0;
		
	}

	public Item(String n, String s, int c){ // Defined player constructor
		
		this.iname = n;
	
		this.stat = s;
	
		this.change = c;

	}
	

	
	public void setName(String n) {  // Set the name of the item
		
		this.iname = n;
		
	}

	public String getName() { // Get the name of the item
		
		return iname;
		
	}

	public void setStat(String s) {  // Set the stat modified in the item
		
		this.stat = s;
		
	}

	public String getStat() { // Get the stat changed in the item
		
		return stat;
		
	}

	public void setChange(int c) {  // Set the number to change the stat by
		
		this.change = c;
		
	}

	public int getChange() { // Get the number to change the stat by
		
		return change;
		
	}
	
	public static Item getItem(ArrayList<Item> i, String s) {
		for(Item item:i) {
			if(item.iname.equals(s))
				return item;
		}
		return null;
	}

}
