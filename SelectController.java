package application;

import java.io.*;
import javafx.event.ActionEvent; // all necessary java fx imports are called 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectController  implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
			}	
	
	@FXML
	public AnchorPane rootPane1;
	
	@FXML
	public Button start = null; // Button to start game
	
	@FXML
	public Button back = null; // Button to return to char select
	
	@FXML
	public Button end = null; // Button to exit
	
	@FXML
	public Button embark = null; // Button to start the game
	
	@FXML
	public Button nameset = null; // Button to set player name
	
	@FXML
	public Button bmage = null; // Button to set player class to mage
	
	@FXML
	public Button bthief = null; // Button to set player class to thief
	
	@FXML
	public Button bwarrior = null; // Button to set player class to warrior
	
	@FXML
	public Button bmonk = null; // Button to set player class to monk
	
	@FXML
	public Button finalize = null; // Button to finalize character
	
	@FXML
	public Button test = null; // Button to finalize character
	
	@FXML
	public Label plschoose = null;
	
	@FXML
	public Label gname = null; // Name displayed in game
	
	@FXML
	public Label gdmg = null; // Damage displayed in game
	
	@FXML
	public Label ghp = null; // Hp displayed in game
	
	@FXML
	public Label gev = null; // EV displayed in game
	
	@FXML
	public Label name_Class=null;

	@FXML
	public Label currentHp=null;
	
	@FXML
	public ProgressBar currentHpBar=null;
	
	@FXML
	public TextField inputname = null; // Text field for player to enter name
	
	public static class player{ // Player class
		
		public String name; // Name of player

		public String role; // Class of player

		public int DMG; // Damage of player

		public int HP; // Health of player
		
		public int maxHP; // Health of player

		public int EV; // Evade chance of player
		
		public boolean dead = false;

/* Class for player */		
		
public player() { // Default constructor
			
			
		name = "";

		role = "";

		DMG = 0;

		HP = 0;

		maxHP = 0;
		
		EV = 0;
			
		}

public player(String n, String r, int d, int h, int e){ // Defined player constructor
			
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
		
public void attack(enemy e) {
	
	
	
	
}	
			
		}
	
	/* Class and methods for enemy */	
	
	public static class enemy{
		

	public String ename; // Enemy name
	
	public int HP; // Enemy Hp
	
	public int maxHP; // Enemy max Hp
	
	public int DMG; // Enemy damage
	
	public int EV; // Enemy evasion
	
	public String special; // Enemy special effect
	
	public boolean dead = false; // Enemy living status
	
public enemy() { // Default constructor
		
		
		ename = "";

		DMG = 0;

		HP = 0;

		maxHP = HP;
		
		EV = 0;
		
		special = "";
		
	}
	
public enemy(String n, int d, int h, int e, String s){ // Defined enemy constructor
		
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
	
	/* Player is created */
	
	public static player playboy = new player();
	
	/* Enemies are created */
	
	public enemy orc = new enemy("Orc Warrior", 300, 1200, 10, "Bleed" );
	
	public enemy goblin = new enemy("Goblin Archer", 200, 800, 30, "Bleed" );
	
	public enemy necromancer = new enemy("Vile Necromancer", 400, 1000, 20, "Fear" );
	
	public enemy troll = new enemy("Cave Troll", 500, 1300, 10, "Break" );
	
	public enemy minotaur = new enemy("Enraged Minotaur", 450, 1500, 10, "Break" );
	
	public enemy hydra = new enemy("Lake Hydra", 450, 1400, 10, "Fear" );
	
	public enemy zombie = new enemy("Rotten Zombie", 300, 800, 20, "Fear" );
	
	public enemy thrall = new enemy("Morthar's Thrall", 250, 700, 30, "Bleed" );
	
	public enemy demon = new enemy("Demon Crusher", 400, 1200, 20, "Break");
	
	public enemy witch = new enemy("Frost Witch", 350, 1100, 15, "Break" );
	
	public enemy boss = new enemy("Morthar", 600, 2000, 15, "Rend" );
	
	public static ArrayList<enemy> enemyList = new ArrayList<enemy>();

/* Method to populate enemy array */	
	
public void popEnemies(ArrayList<enemy> a) {
	
a.add(orc);
a.add(goblin);
a.add(necromancer);
a.add(troll);
a.add(minotaur);
a.add(hydra);
a.add(zombie);
a.add(thrall);
a.add(demon);
a.add(witch);
a.add(boss);

}
	/* Method to set player name */

@FXML	
public void setname(ActionEvent event) {
	
	String set = inputname.getText();
	
	playboy.name = set;
	
	inputname.clear();
	
	System.out.println(playboy.name);
}

/* Methods to set player class */

@FXML
public void toMage(ActionEvent event) {
	
	
	playboy.setMage();
	
	System.out.println(playboy.name + " the " + playboy.role); //delete
}

@FXML
public void toWarrior(ActionEvent event) {
	
	
	playboy.setWarrior();
	
	System.out.println(playboy.name + " the " + playboy.role); //delete
}

@FXML
public void toThief(ActionEvent event) {
	
	
	playboy.setThief();
	
	System.out.println(playboy.name + " the " + playboy.role); //delete
}

@FXML
public void toMonk(ActionEvent event) {
	
	
	playboy.setMonk();
	
	System.out.println(playboy.name + " the " + playboy.role); //delete
}
	
	/* Method to change to character select */
	
@FXML	
public void LoadUser(ActionEvent event) throws IOException { 
	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CharSelect.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
	}	
	
/* Method to change to Base Level Screen */

@FXML	
public void LoadBaseLevel(ActionEvent event) throws IOException { 
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("BaseLevel.fxml"));
		rootPane1 = loader.load();
		SelectController controller=loader.<SelectController>getController();	// Controller for FXML injection
		controller.setPlayerAttributes(playboy.name + " the " + playboy.role, playboy);
		controller.popEnemies(enemyList);
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
        
	}	

/* Method to change to How to play */

@FXML	
public void LoadHTP(ActionEvent event) throws IOException { 
		
		if(playboy.role == "" || playboy.name == "") {
			
		plschoose.setText("Please set a name and class to proceed");	
		
		}
		else {	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HowToPlay.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
		}
	}

/* Set basic player attributes in BaseLevel */

public void setPlayerAttributes(String title, player p) {	
	name_Class.setText(title);
	currentHp.setText(p.HP+"/"+p.maxHP);
	String outDMG = Integer.toString(p.DMG);
	gdmg.setText(outDMG);
	String outEV = Integer.toString(p.EV);
	gev.setText(outEV);
	playboy=p;
}

@FXML
public void exit() {
		System.exit(0);
	}
}
