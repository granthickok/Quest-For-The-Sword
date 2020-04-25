package application.model;

public class Character {
	private String name;
	
	private int DMG; // Damage of player

	private int HP; // Health of player

	private int maxHP; // Health of player

	private int EV; // Evade chance of player

	private boolean dead;
	
	public Character() {
		name="";
		DMG = 0;
		HP = 0;
		maxHP = 0;
		EV = 0;
		dead=false;
	}
	
	public Character(String s, int dmg, int hp, int ev) {
		name=s;
		DMG=dmg;
		HP=hp;
		maxHP=hp;
		EV=ev;
		dead=false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dMG
	 */
	public int getDMG() {
		return DMG;
	}

	/**
	 * @param dMG the dMG to set
	 */
	public void setDMG(int dMG) {
		DMG = dMG;
	}

	/**
	 * @return the hP
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * @param hP the hP to set
	 */
	public void setHP(int hP) {
		HP = hP;
	}

	/**
	 * @return the maxHP
	 */
	public int getMaxHP() {
		return maxHP;
	}

	/**
	 * @param maxHP the maxHP to set
	 */
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	/**
	 * @return the eV
	 */
	public int getEV() {
		return EV;
	}

	/**
	 * @param eV the eV to set
	 */
	public void setEV(int eV) {
		EV = eV;
	}

	/**
	 * @return the dead
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public void attack(Character c) {
		c.HP-=DMG;
	}
}
