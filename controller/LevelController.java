
package application.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

import application.model.Enemy;
import application.model.Item;
import application.model.Levels;
import application.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class LevelController implements Initializable{

	@FXML
	public Label gdmg = null; // Player damage displayed in game
	
	@FXML
	public Label gev = null; // Player EV displayed in game
	
	@FXML
	public Label name_Class=null;
	@FXML
	public Label currentHp=null;
	
	@FXML
	public Label edmg = null; // Enemy damage displayed in game
	
	@FXML
	public Label eev = null; // Enemy EV displayed in game
	
	@FXML
	public Label ename=null; // Enemy name displayed in game
	
	@FXML
	public Label ecurrentHp=null; // Enemy HP displayed in game
	
	@FXML
	public Label especial = null; // Enemy damage displayed in game
	
	@FXML
	public ProgressBar currentHpBar=null;

	@FXML
	public Button attack = null; // Action buttons
	
	@FXML
	public Button item = null;
	
	@FXML
	public Button run = null;
	
	@FXML
	public Button up = null; // Movement buttons
	
	@FXML
	public Button left = null;
	
	@FXML
	public Button right = null;
	
	@FXML
	public TextArea events = null; 
	
	@FXML
	public TextArea pinventory = null;
	
	@FXML
	public TextField itemselect = null;
	
	@FXML
	public Circle startCircle, pos10, pos11, pos1_1, pos20, pos21, pos22, pos2_1, pos2_2, pos30, pos31, pos32, pos33, pos3_1,
				pos3_2, pos3_3, pos40, pos41, pos42, pos43, pos44, pos4_1, pos4_2, pos4_3, pos4_4, pos50, pos51, pos52, pos53,
				pos5_1, pos5_2, pos5_3, pos60, pos61, pos62, pos6_1, pos6_2, pos70, pos71, pos7_1, pos80, finishCircle;

	private Circle currentPos, tmp;

	private Enemy e;
	private Player p;
	private Levels l;

	
	public boolean combat = false; //Booleans to control combat and turns
	
	public boolean eturn = false;
	
	public boolean pturn = true;
	
	Circle layout_Circle[][];

	int layout[][]={{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
					{-1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1},
	                {-1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1},
	                {-1, -1, -1, -1,  1,  1,  1, -1, -1, -1, -1},
	                {-1, -1, -1,  1,  1,  1,  1,  1, -1, -1, -1},
	                {-1, -1,  1,  1,  1,  1,  1,  1,  1, -1, -1},
	                {-1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1},
	                {-1, -1,  1,  1,  1,  1,  1,  1,  1, -1, -1},
	                {-1, -1, -1,  1,  1,  1,  1,  1, -1, -1, -1},
	                {-1, -1, -1, -1,  1,  1,  1, -1, -1, -1, -1},
	                {-1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1},
	                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
	
	/* Items and Player Inventory are created */
	
	public Item HPup = new Item("HPup", "HP", 1000, 1);
	
	public Item SHPup = new Item("SHPup", "HP", 2000, 1);
	
	public Item DMGup = new Item("DMGup", "DMG", 100, 1);
	
	public Item SDMGup = new Item("SDMGup", "DMG", 200, 1);
	
	public Item EVup = new Item("EVup", "EV", 10, 1);
	
	public Item SEVup = new Item("SEVup", "EV", 20, 1);	
	
	public static LinkedList<Item> Inventory = new LinkedList<Item>();
	
	
	public static ArrayList<Item> ItemList = new ArrayList<Item>(); // Total list of items
	
	/* Enemies are created */
	
	public Enemy orc = new Enemy("Orc Warrior", 300, 1200, 10, "Bleed" );
	
	public Enemy goblin = new Enemy("Goblin Archer", 200, 800, 30, "Bleed" );
	
	public Enemy necromancer = new Enemy("Vile Necromancer", 400, 1000, 20, "Fear" );
	
	public Enemy troll = new Enemy("Cave Troll", 500, 1300, 10, "Break" );
	
	public Enemy minotaur = new Enemy("Enraged Minotaur", 450, 1500, 10, "Break" );
	
	public Enemy hydra = new Enemy("Lake Hydra", 450, 1400, 10, "Fear" );
	
	public Enemy zombie = new Enemy("Rotten Zombie", 300, 800, 20, "Fear" );
	
	public Enemy thrall = new Enemy("Morthar's Thrall", 250, 700, 30, "Bleed" );
	
	public Enemy demon = new Enemy("Demon Crusher", 400, 1200, 20, "Break");
	
	public Enemy witch = new Enemy("Frost Witch", 350, 1100, 15, "Break" );
	
	public Enemy boss = new Enemy("Morthar", 600, 2000, 15, "Rend" );
	
	public static ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
	
	/* Method to populate Enemy array */	
	
	public void popEnemies() {
		
		EnemyList.add(orc);
		EnemyList.add(goblin);
		EnemyList.add(necromancer);
		EnemyList.add(troll);
		EnemyList.add(minotaur);
		EnemyList.add(hydra);
		EnemyList.add(zombie);
		EnemyList.add(thrall);
		EnemyList.add(demon);
		EnemyList.add(witch);
		EnemyList.add(boss);
	}
	
	public void popItems() {
		
		ItemList.add(HPup);
		ItemList.add(SHPup);
		ItemList.add(DMGup);
		ItemList.add(SDMGup);
		ItemList.add(EVup);
		ItemList.add(SEVup);
	}
	
	/* Method to add item to inventory */ // Incomplete
	
	public void addItem() {
		
		Random rand = new Random();
		
		int iroll = rand.nextInt(6);
		
	    
	
	}
	
	/* Method for player to attempt to run */
	
	@FXML
	public void run(ActionEvent event){
		
		Random rand = new Random();	
		
		if(pturn == true && combat == true) {
		
		int runCalc = rand.nextInt(101);
		
		if(runCalc <= 10) {
		
			events.appendText("\n");	
			
		events.appendText("\nRun Successful! WOOSH");
		
		combat = false;
		
		pturn = true;
			
		}
		else if(runCalc > 10) {		
		
		events.appendText("\nRun Failed! Prepare for pain!");	
		
		pturn = false;
		
		eturn = true;
		}
		
		}
		
	}
	
	/*Method for player to attack */ 
	
	@FXML
	public void attack(ActionEvent event) {
	
	Random rand = new Random();		
		
	if(pturn == true && combat == true) {
		
	events.appendText("\n" + p.getName() + " attacks!");	
	
	int dmgDone = p.getDMG();
	
	int eEV = e.getEV(); 
	
	int roll = rand.nextInt(101);
	
	if(roll <= eEV) { // Enemy evades
		
		events.appendText("Attack Evaded!");
		
		eturn = true;
		
		pturn = false;
		
		}		
	else if(roll > eEV) { // Enemy is damaged
		
		e.setHP(dmgDone - e.getHP());
		
		String ehealth = Integer.toString(e.getHP());
		
		ecurrentHp.setText(ehealth);
		
		eturn = true;
		
		pturn = false;
		
		}
	}
	
	}
	
	/*Method for player to use item */ // Incomplete
	
	@FXML
	public void useItem(ActionEvent event){
		
		if(pturn == true) {
		
		String item = itemselect.getText();
		
		if(item.equals("")) {
			
		itemselect.clear();
		
		events.appendText("\nEnter an item in the selection box");	
			
		}
		
		}
		
	}
	
	
	/* Set basic Player attributes in BaseLevel */
	
	public void setPlayerAttributes(String title, Player p) {	
		name_Class.setText(title);
		currentHp.setText(p.getHP()+"/"+p.getMaxHP());
		String outDMG = Integer.toString(p.getDMG());
		gdmg.setText(outDMG);
		String outEV = Integer.toString(p.getEV());
		gev.setText(outEV);
		this.p=p;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popEnemies();
		setCircle();
		popItems();
		
		l=new Levels(layout);

		setValidMoves();
		setCurrentPos();

	}

	private void setValidMoves() {
		l.getValidMoves();

		if(l.upValid) {
			tmp=layout_Circle[l.y-1][l.x];
			tmp.setFill(Paint.valueOf("Green"));
		}

		if(l.leftValid) {
			tmp=layout_Circle[l.y][l.x-1];
			tmp.setFill(Paint.valueOf("Green"));
		}

		if(l.rightValid) {
			tmp=layout_Circle[l.y][l.x+1];
			tmp.setFill(Paint.valueOf("Green"));
		}
	}

	private void setCircle() {
		layout_Circle=new Circle[][] {{null,   null,   null,   null,   null,         null,  null,  null,  null,  null, null},
			   						  {null,   null,   null,   null,   null, finishCircle,  null,  null,  null,  null, null},
			   						  {null,   null,   null,   null,   null,        pos80,  null,  null,  null,  null, null},
			   						  {null,   null,   null,   null, pos7_1,        pos70, pos71,  null,  null,  null, null},
			   						  {null,   null,   null, pos6_2, pos6_1,        pos60, pos61, pos62,  null,  null, null},
			   						  {null,   null, pos5_3, pos5_2, pos5_1,        pos50, pos51, pos52, pos53,  null, null},
			   						  {null, pos4_4, pos4_3, pos4_2, pos4_1,        pos40, pos41, pos42, pos43, pos44, null},
			   						  {null,   null, pos3_3, pos3_2, pos3_1,        pos30, pos31, pos32, pos33,  null, null},
			   						  {null,   null,   null, pos2_2, pos2_1,        pos20, pos21, pos22,  null,  null, null},
			   						  {null,   null,   null,   null, pos1_1,        pos10, pos11,  null,  null,  null, null},
			   						  {null,   null,   null,   null,   null,  startCircle,  null,  null,  null,  null, null},
			   						  {null,   null,   null,   null,   null,         null,  null,  null,  null,  null, null}};
	}

	@FXML
	private void moveLeft(ActionEvent event) {
		
		Random rand = new Random();
		
		int croll = rand.nextInt(101);
		
		if(l.leftValid && pturn == true && combat == false) {
			unsetValidMoves();
			l.moveLeft();
			setCurrentPos();
			
		/*	if(croll >= 60) { //crashes game
				
			combat();	
			} */
		}else {
			return;
		}
	}

	@FXML
	private void moveRight(ActionEvent event) {
		
		Random rand = new Random();
		
		int croll = rand.nextInt(101);
		
		if(l.rightValid && pturn == true && combat == false) {
			unsetValidMoves();
			l.moveRight();
			setCurrentPos();
			
			/*	if(croll >= 60) { //crashes game
			
			combat();	
			} */
		}else {
			return;
		}
	}

	@FXML
	private void moveUp(ActionEvent event) {
		
		Random rand = new Random();
		
		int croll = rand.nextInt(101);
		
		if(l.upValid && pturn == true && combat == false) {
			unsetValidMoves();
			l.moveUp();
			setCurrentPos();
			
			/*	if(croll >= 60) { //crashes game
			
			combat();	
			} */
			
		}else {
			return;
		}
	}

	private void unsetValidMoves() {
		currentPos.setFill(Paint.valueOf("Dodgerblue"));

		if(l.upValid) {
			tmp=layout_Circle[l.y-1][l.x];
			tmp.setFill(Paint.valueOf("Dodgerblue"));
		}

		if(l.leftValid) {
			tmp=layout_Circle[l.y][l.x-1];
			tmp.setFill(Paint.valueOf("Dodgerblue"));
		}

		if(l.rightValid) {
			tmp=layout_Circle[l.y][l.x+1];
			tmp.setFill(Paint.valueOf("Dodgerblue"));}
	}

	private void setCurrentPos() {
		currentPos=layout_Circle[l.y][l.x];
		currentPos.setFill(Paint.valueOf("Red"));

		setValidMoves();
	}

	/* Combat method */
	@FXML
	public void combat(){
	
	events.clear();	 // Set enemy attributes and begin combat
		
	combat = true;
		
	Random rand = new Random();	
		
	int mfinder = rand.nextInt(10); // Enemy is found from enemy list and info is sent to the gui
	
	 e = EnemyList.get(mfinder);
	
	ename.setText(e.getName());
	
	ecurrentHp.setText(e.getHP() + "/" + e.getMaxHP());
	
	String outDMG = Integer.toString(e.getDMG());
	
	edmg.setText(outDMG);
	
	String outEV = Integer.toString(p.getEV());
	
	edmg.setText(outEV);
	
	especial.setText(e.getSpecial());
	
	events.appendText("\n" + e.getName() + "approaches!");
		
	while(p.isDead() == false && e.isDead() == false) { // Combat happens until either player or enemy is dead
		
	if(pturn == true) {
	
	events.appendText("\nWhat will you do?");	
	
	}
	
	if(eturn == true) {
	
	events.appendText("\n" + e.getName() + "attacks!");	
	
	int dmgDone = e.getDMG();
	
	int playerEV = p.getEV();
	
	int roll = rand.nextInt(101);
	
	if(roll <= playerEV) { // Player evades
		
		events.appendText("Attack Evaded!");
		
		eturn = false;
		
		pturn = true;
		
		}		
		else if(roll > playerEV) { // Player is hit and dies if HP is 0 or less
			
		p.setHP(p.getHP() - dmgDone);
		
		String newHp = Integer.toString(p.getHP());
		
		currentHp.setText(newHp);
		
	    eturn = false;
		
		pturn = true;
		
		if(p.getHP() <= 0) {
			
		p.setDead(true);	
		}
		
		}
	
	}
	
	}
	if(p.isDead()) { // Game over if player dies
	
	events.clear();	
		
	events.appendText("You are Dead! Game over");
	
	pturn = false;
	
	combat = false;
	}
	if(e.isDead()) { // Game proceeds if monster dies
		
	events.clear();
	
	events.appendText("The monster lies dead! Onward!");
	
	combat = false;
	
	pturn = true;
	}
	
	}
}
