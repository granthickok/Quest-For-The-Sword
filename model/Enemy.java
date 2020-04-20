package application.model;

/* Class and methods for enemy */

public class Enemy {
	public String ename; // Enemy name
	
	public int HP; // Enemy Hp
	
	public int maxHP; // Enemy max Hp
	
	public int DMG; // Enemy damage
	
	public int EV; // Enemy evasion
	
	public String special; // Enemy special effect
	
	public boolean dead = false; // Enemy living status
	
	public Enemy() { // Default constructor
		
		
		ename = "";

		DMG = 0;

		HP = 0;

		maxHP = HP;
		
		EV = 0;
		
		special = "";
		
	}
	
	public Enemy(String n, int d, int h, int e, String s){ // Defined enemy constructor
		
		this.ename = n;

		this.DMG = d;

		this.HP = h;

		this.maxHP = h;
		
		this.EV = e;
		
		this.special = s;

	}

	public void setName(String n) {  // Return and set name
	
		this.ename = n;
	
	}

	public String getName() { 
	
		return ename;
	
	}

	public String getSpecial() { // Return Special effect
		
		return special;
	}

	public int getmaxHp() { // Return max HP
		
		return maxHP;
		
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
}
