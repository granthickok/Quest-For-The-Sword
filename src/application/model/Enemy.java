/*
 * Class that enemies will be based off of
 */

package application.model;

/* Class and methods for enemy */

public class Enemy extends Character{
	
	public String special; // Enemy special effect
	
	public Enemy() { // Default constructor
		
		super();
		
		special = "";
		
	}
	
	public Enemy(String n, int d, int h, int e, String s){ // Defined enemy constructor
		
		super(n, d, h, e);
				
		special = s;

	}
	
	/**
	 * @return the value of special
	 */
	public String getSpecial() {
		return special;
	}
	
	/**
	 * @return a copy of the selected enemy
	 */
	public Enemy copy() {
		Enemy e=new Enemy(getName(), getDMG(), getHP(), getEV(), special);
		return e;
	}
}
