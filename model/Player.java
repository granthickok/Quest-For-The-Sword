package application.model;

import application.model.Enemy;

public class Player {
	public String name; // Name of player

	public String role; // Class of player

	public int DMG; // Damage of player

	public int HP; // Health of player

	public int maxHP; // Health of player

	public int EV; // Evade chance of player

	public boolean dead = false;

	/* Class for player */

	public Player() { // Default constructor
		
		
		name = "";
	
		role = "";
	
		DMG = 0;
	
		HP = 0;
	
		maxHP = 0;
		
		EV = 0;
		
	}

	public Player(String n, String r, int d, int h, int e){ // Defined player constructor
		
		this.name = n;
	
		this.role = r;
	
		this.DMG = d;
	
		this.HP = h;
	
		this.maxHP = h;
		
		this.EV = e;

	}
	

	
	public void setName(String n) {  // Return and set name
		
		this.name = n;
		
	}

	public String getName() { 
		
		return name;
		
	}

	public void setDmg(int d) {  // Return and set damage
		
		this.DMG = d;
		
	}

	public int getDmg() { 
		
		return DMG;
		
	}

	public void setHp(int h) {  // Return and set hp
		
		this.HP = h;
		
	}

	public int getHp() { 
		
		return HP;
		
	}

	public int getmaxHp() { // Return max HP
		
		return maxHP;
		
	}

	public void setEv(int e) {  // Return and set ev
		
		this.EV = e;
		
	}

	public int getEv() { 
		
		return EV;
		
	}

	public boolean getDead() { // Return and set living status
	    
		return dead;
	}

	public void setDead(boolean dead) {
	    
		this.dead = dead;
	}

	public void setMage() { // Set player class to mage
			
		this.role = "Mage";

		this.DMG = 480;

		this.HP = 3500;

		this.maxHP = HP;
		
		this.EV = 14;
			
		}

	public void setWarrior() { // Set player class to warrior
			
		this.role = "Warrior";

		this.DMG = 420;

		this.HP = 4500;
		
		this.maxHP = HP;

		this.EV = 10;
			
		}

	public void setThief() { // Set player class to thief
			
		this.role = "Thief";

		this.DMG = 460;

		this.HP = 3000;

		this.maxHP = HP;
		
		this.EV = 34;

		}
			
	public void setMonk() { // Set player class to monk
			
		this.role = "Monk";

		this.DMG = 440;

		this.HP = 3300;
		
		this.maxHP = HP;

		this.EV = 20;

	}		
		
	public void attack(Enemy e) {	
		e.HP-=DMG;
	}	

}
