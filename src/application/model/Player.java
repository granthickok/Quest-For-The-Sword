package application.model;

public class Player extends Character{
	public String role; // Class of player

	/* Class for player */

	public Player() { // Default constructor
		
		super();
	
		role = "";
	
	}

	public Player(String n, String r, int d, int h, int e){ // Defined player constructor
		
		super(n, d, h, e);
	
		this.role = r;

	}

	/*
	 * Method to update the current player to the Mage class
	 */
	public void setMage() { // Set player class to mage
			
		role = "Mage";
		
		setDMG(480);
		setHP(3500);
		setMaxHP(getHP());
		setEV(14);
			
		}

	/*
	 * Method to update hte current player to the Warrior class
	 */
	public void setWarrior() { // Set player class to warrior
			
		this.role = "Warrior";
		
		setDMG(420);
		setHP(4500);
		setMaxHP(getHP());
		setEV(10);
			
		}

	/*
	 * Method to update the current player to the Thief class
	 */
	public void setThief() { // Set player class to thief
			
		this.role = "Thief";
		
		setDMG(460);
		setHP(3000);
		setMaxHP(getHP());
		setEV(99);

		}
			
	/*
	 * Method to update the current player to the Monk class
	 */
	public void setMonk() { // Set player class to monk
			
		this.role = "Monk";
		
		setDMG(440);
		setHP(3300);
		setMaxHP(getHP());
		setEV(20);

	}		

	/**
	 * Method to copy the selected player
	 * @return copy of the selected player
	 */
	public Player copy() {
		Player p=new Player(getName(), role, getDMG(), getHP(), getEV());
		return p;
	}
}
