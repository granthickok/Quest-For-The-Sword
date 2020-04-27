
package application.controller;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class LevelController implements Initializable{
	
	@FXML
	public AnchorPane rootPane1;

	Stage stage;
	
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
	public Button attackBtn = null; // Action buttons
	
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

	@FXML
	public ListView<String> inventoryList;
	
	private Circle currentPos, tmp;

	private Enemy e;
	private Player p;
	private Levels l;

	
	public boolean combat = false; //Booleans to control combat and turns
	
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
	
	public LinkedList<Item> Inventory = new LinkedList<Item>();
	
	public ArrayList<Item> ItemList = new ArrayList<Item>(); // Total list of items
	
	public ArrayList<Item> randomDrops=new ArrayList<Item>();
	
	public ArrayList<Item> combatDrops=new ArrayList<Item>();
	
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
	
	public Enemy boss = new Enemy("Morthar", 100, 2000, 15, "Rend" ); //nerfed
	
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
		
		randomDrops.add(HPup);
		randomDrops.add(SHPup);
		randomDrops.add(DMGup);
		randomDrops.add(SDMGup);
		randomDrops.add(EVup);
		randomDrops.add(SEVup);
		
		combatDrops.add(SHPup);
		combatDrops.add(SDMGup);
		combatDrops.add(SEVup);
	}
	
	/* Method to add item to inventory */
	

	public void addItem(String i) {
		Item item = Item.getItem(ItemList, i);
	    Inventory.add(item);
	    inventoryList.getItems().add(i);

	}
	
	@FXML
	public void setSelectedItem(MouseEvent event) {
		try{
			itemselect.setText(inventoryList.getSelectionModel().getSelectedItem());
		} catch(Exception e) {
			System.out.println("Hi");
			e.printStackTrace();
		}
	}
	
	/* Method for player to attempt to run */
	
	@FXML
	public void run(ActionEvent event){
		
		Random rand = new Random();	
		
		if(combat == true) {
		
			int runCalc = rand.nextInt(101);
		
			if(runCalc <= 10) {
		
				events.appendText("\n");	
			
				events.appendText("\nRun Successful! WOOSH");
				
				combat=false;
			
			} else if(runCalc > 10) {		
		
				events.appendText("\nRun Failed! Prepare for pain!");	
				
				enemyAttack();
			}
		
		}
		
	}
	
	public void rollCommonDrop() {
		Random r=new Random();
		
		int x=r.nextInt(6);
		Item i=randomDrops.get(x);
		addItem(i.getName());
		
		events.appendText("\nYou find an "+i.getName()+" in your adventures!");
	}
	
	public void rollCombatDrop() {
		Random r=new Random();
		
		int x=r.nextInt(3);
		Item i=combatDrops.get(x);
		addItem(i.getName());
		
		events.appendText("\nYou find an "+i.getName()+" after defeating the "+e.getName()+"!");
	}
	
	
	
	/*Method for player to use item */ // Incomplete
	
	@FXML
	public void useItem(ActionEvent event){
			
			String item = itemselect.getText();
		
			if(item.equals("")) {
			
				events.appendText("\nEnter an item in the selection box");	
			
			} else {
					Item i;
					int x;
					i=Item.getItem(ItemList, item);
					
					if(i == null) {
						
					events.appendText("\nItem not Found!");
					itemselect.clear();
					}
					else {
					if(i.getStat().equals("HP")) {
						int y=p.getHP()+i.getChange();
						if(y>p.getMaxHP()) {
							p.setHP(p.getMaxHP());
							events.appendText("\nHealth Restored to Full!");
						}
						else {
							p.setHP(y);
							events.appendText("\nHealth Restored by " + i.getChange());
						}
						currentHp.setText(p.getHP()+"/"+p.getMaxHP());
					}else if(i.getStat().equals("DMG")) {
						p.setDMG(p.getDMG()+i.getChange());
						gdmg.setText(""+p.getDMG());
						events.appendText("\nDamage Increased by " + i.getChange());
					}else {
						p.setEV(p.getEV()+i.getChange());
						gev.setText(""+p.getEV());
						events.appendText("\nEV Increased by " + i.getChange());
					}
					
					
					x=Inventory.indexOf(i);
					Inventory.remove(x);
					inventoryList.getItems().remove(x);
					itemselect.clear();
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
		this.p=p.copy();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popEnemies();
		setCircle();
		popItems();
		
		l=new Levels(layout);

		addItem("DMGup");
		addItem("DMGup");
		addItem("DMGup");
		addItem("DMGup");
		addItem("DMGup");
		addItem("DMGup");
		addItem("DMGup");
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
		
		if(l.leftValid && combat == false) {
			unsetValidMoves();
			l.moveLeft();
			setCurrentPos();
			if(croll <= 80) { // Roll for combat
				
				combat();	
			}else if(croll>=50) {
				rollCommonDrop();
			}
		}else {
			return;
		}
	}

	@FXML
	private void moveRight(ActionEvent event) {
		
		Random rand = new Random();
		
		int croll = rand.nextInt(101);
		
		if(l.rightValid && combat == false) {
			unsetValidMoves();
			l.moveRight();
			setCurrentPos();
			
			if(croll <= 70) { // Roll for combat
				
			combat();	
			}else if(croll>=50) {
				rollCommonDrop();
			}
		}else {
			return;
		}
	}

	@FXML
	private void moveUp(ActionEvent event) {
		
		Random rand = new Random();
		
		int croll = rand.nextInt(101);
		
		if(l.upValid && combat == false) {
			unsetValidMoves();
			l.moveUp();
			setCurrentPos();

			if(currentPos != finishCircle) {
				if(croll >= 70) { 
				
					combat();	
				}else if(croll>=50) {
					rollCommonDrop();
				}
			
			}

			else if(currentPos == finishCircle) {
				
			bossfight();
			
			}
			else {
			return;
		}
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
			
		combat = true;
			
		Random rand = new Random();	
			
		int mfinder = rand.nextInt(10); // Enemy is found from enemy list and info is sent to the gui
		
		e = EnemyList.get(mfinder).copy();
		
		ename.setText(e.getName());
		
		ecurrentHp.setText(e.getHP() + "/" + e.getMaxHP());
		
		String outDMG = Integer.toString(e.getDMG());
		
		edmg.setText(outDMG);
		
		String outEV = Integer.toString(p.getEV());
		
		edmg.setText(outEV);
		
		eev.setText(""+e.getEV());
		
		especial.setText(e.getSpecial());
		
		events.appendText("\n" + e.getName() + " approaches!");
			
		
		events.appendText("\nWhat will you do?");				
	
	
		
}
	/* Combat method */
	@FXML
	public void bossfight(){
	
		events.clear();	 // Set enemy attributes and begin combat
			
		combat = true;
		
		e = EnemyList.get(10).copy();
		
		ename.setText(e.getName());
		
		ecurrentHp.setText(e.getHP() + "/" + e.getMaxHP());
		
		String outDMG = Integer.toString(e.getDMG());
		
		edmg.setText(outDMG);
		
		String outEV = Integer.toString(p.getEV());
		
		edmg.setText(outEV);
		
		eev.setText(""+e.getEV());
		
		especial.setText(e.getSpecial());
		
		events.appendText("You enter Morthar's lair and engage the beast!");
			
		events.appendText("\nWhat will you do?");				
	
	
		
	}
	/*Method for player to attack */ 
	
	@FXML
	public void attack(ActionEvent event) {
		if(!combat)
			return;
	
	Random rand = new Random();		
		
	if(combat == true) {
		
	events.appendText("\n" + p.getName() + " attacks!");	
	
	int eEV = e.getEV(); 
	
	int roll = rand.nextInt(101);
	
	if(roll <= eEV) { // Enemy evades
		
		events.appendText("\nAttack Evaded!");
		
		}		
	else if(roll > eEV) { // Enemy is damaged
		
		e.setHP(e.getHP() - p.getDMG());
		
		String ehealth = e.getHP()+"/"+e.getMaxHP();
		
		if(e.getHP()<1) {
			e.setDead(true);
			ecurrentHp.setText(""+0);
		}else {
			ecurrentHp.setText(ehealth);
		}
		
		
		
		}
	}
	
	if(e.isDead() && currentPos != finishCircle) { // Game proceeds if monster dies and is not the final boss
		
		events.clear();
		
		events.appendText("The monster lies dead! Onward!");
		
		rollCombatDrop();
		
		combat = false;
	}
	else if(e.isDead() && currentPos == finishCircle){
		
		try {
			LoadWin();
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}	
	
	}
	else {
		enemyAttack();
	}
	
	
	}
	
	private void enemyAttack() {
		
		Random rand = new Random();	
		
		int roll = rand.nextInt(101);
		
		int sroll = rand.nextInt(101);
		
		events.appendText("\n" + e.getName() + " attacks!");
		
		if(roll <= p.getEV()) { // Player evades
			
			events.appendText("\nAttack Evaded!");
			
		}else if(roll > p.getEV()) { // Player is hit and dies if HP is 0 or less
			
			p.setHP(p.getHP() - e.getDMG());
			
			String newHp = p.getHP()+"/"+p.getMaxHP();
			
			String effect = e.getSpecial(); // Stats are afflicted
			
		if(sroll < 80){ // Change
			
		if(effect == "Bleed") { // Bleed Special
			
			p.setHP(p.getHP() - 100);
			
			events.appendText("\nYou bleed profusely. - 100 HP");
			
			newHp = String.valueOf(p.getHP()+"/"+p.getMaxHP());
		}
		if(effect == "Break") { // Break Special 
			
			if(p.getEV()-5>0)
				p.setEV(p.getEV() - 5);
			else
				p.setEV(0);
			
			events.appendText("\nYou feel a bone break restricting movement. - 5 EV");
			
			String newEV = String.valueOf(p.getEV());
			
			gev.setText(newEV);
			
		}
		if(effect == "Fear") { // Fear Special 
			
			if(p.getDMG()-40>0)
				p.setDMG(p.getDMG() - 40);
			else
				p.setDMG(0);
			
			events.appendText("\nA crippling fear rattles your resolve. - 40 DMG");
			
			String newDMG = String.valueOf(p.getDMG());
			
			gdmg.setText(newDMG);
			
		}
		if(effect == "Rend") { // Rend Special 
			
			if(p.getDMG()-30>0)
				p.setDMG(p.getDMG() - 30);
			else
				p.setDMG(0);
			
			if(p.getEV()-5>0)
				p.setEV(p.getEV() - 5);
			else
				p.setEV(0);
			
			events.appendText("\nMorthar unleashes a pillar of flame!  - 30 DMG and - 5 EV");
			
			String newDMG = String.valueOf(p.getDMG());
			
			String newEV = String.valueOf(p.getEV());
			
			gdmg.setText(newDMG);
			
			gev.setText(newEV);
		}
			
		}
			
			if(p.getHP() <= 0) {
				
				p.setDead(true);
				
				currentHp.setText(""+0);
			}else {
				
				currentHp.setText(newHp);
			}
			
		}
		
		if(p.isDead()) { // Game over if player dies
			
			try {
				LoadGO();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
			
			combat = false;
		}
	}
	
	
	public void LoadGO() throws IOException { 
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/GameOver.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = stage;// pane you are ON
        window.setScene(scene);
        window.show();
        
	}
	
	public void LoadWin() throws IOException { 
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/Victory.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = stage;// pane you are ON
        window.setScene(scene);
        window.show();
        
	}	
	
	public void setStage(Stage s) {
		stage=s;
	}
}
