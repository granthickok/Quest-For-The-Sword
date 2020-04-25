package application.model;

import application.model.Enemy;

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

	public void setMage() { // Set player class to mage
			
		role = "Mage";
		
		setDMG(480);
		setHP(3500);
		setMaxHP(getHP());
		setEV(14);
			
		}

	public void setWarrior() { // Set player class to warrior
			
		this.role = "Warrior";
		
		setDMG(420);
		setHP(4500);
		setMaxHP(getHP());
		setEV(10);
			
		}

	public void setThief() { // Set player class to thief
			
		this.role = "Thief";
		
		setDMG(460);
		setHP(3000);
		setMaxHP(getHP());
		setEV(34);

		}
			
	public void setMonk() { // Set player class to monk
			
		this.role = "Monk";
		
		setDMG(440);
		setHP(3300);
		setMaxHP(getHP());
		setEV(20);

	}		

	public Player copy() {
		Player p=new Player(getName(), role, getDMG(), getHP(), getEV());
		return p;
	}
}
