
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class LevelController implements Initializable{
	
	@FXML
	public AnchorPane rootPane1;

	Stage stage;	// Placeholder to keep previous stage
	
	@FXML
	public Label gdmg = null; // Player damage displayed in game
	
	@FXML
	public Label gev = null; // Player EV displayed in game
	
	@FXML
	public Label name_Class=null;	// Label to hold player name and class name
	
	@FXML
	public Label currentHp=null;	// label to hold players current hp
	
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
	public ProgressBar playerHPBar;
	
	@FXML
	public ProgressBar enemyHPBar;

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
	public TextArea events = null; // Text area to let the player know whats happening
	
	@FXML
	public Label itemselect = null;	// Label to show current items name
	
	@FXML
	public Label itemStats;	// Label to show current items stats
	
	@FXML
	public Circle startCircle, pos10, pos11, pos1_1, pos20, pos21, pos22, pos2_1, pos2_2, pos30, pos31, pos32, pos33, pos3_1,
				pos3_2, pos3_3, pos40, pos41, pos42, pos43, pos44, pos4_1, pos4_2, pos4_3, pos4_4, pos50, pos51, pos52, pos53,
				pos5_1, pos5_2, pos5_3, pos60, pos61, pos62, pos6_1, pos6_2, pos70, pos71, pos7_1, pos80, finishCircle;

	@FXML
	public ListView<String> inventoryList;	// Listview to show current players inventory
	
	private Circle currentPos, tmp;	// Placeholder circles to hold players current position and temp variables

	// Placeholder variables for easy access
	private Enemy e;	
	private Player p;
	private Levels l;

	
	public boolean combat = false; //Booleans to control combat and turns
	
	Circle layout_Circle[][];	// Circle matrix to show visual representation of int matrix

	// Map layout
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
	
	public Item HPup = new Item("HP Potion", "HP", 1000);
	
	public Item SHPup = new Item("Super HP Potion", "HP", 2000);
	
	public Item DMGup = new Item("Damage Potion", "DMG", 100);
	
	public Item SDMGup = new Item("Super Damage Potion", "DMG", 150);
	
	public Item EVup = new Item("Evasion Potion", "EV", 10);
	
	public Item SEVup = new Item("Super Evasion Potion", "EV", 15);	
	
	public LinkedList<Item> Inventory = new LinkedList<Item>();	// Items in inventory
	
	public ArrayList<Item> ItemList = new ArrayList<Item>(); // Total list of items
	
	public ArrayList<Item> randomDrops=new ArrayList<Item>();	// Items available for random drops
	
	public ArrayList<Item> combatDrops=new ArrayList<Item>();	// Items available for combat drops
	
	/* Enemies are created */
	public Enemy orc = new Enemy("Orc Warrior", 300, 1300, 10, "Bleed" );
	
	public Enemy goblin = new Enemy("Goblin Archer", 260, 900, 30, "Bleed" );
	
	public Enemy necromancer = new Enemy("Vile Necromancer", 300, 1200, 20, "Fear" );
	
	public Enemy troll = new Enemy("Cave Troll", 400, 1600, 10, "Break" );
	
	public Enemy minotaur = new Enemy("Enraged Minotaur", 400, 1700, 10, "Break" );
	
	public Enemy hydra = new Enemy("Lake Hydra", 400, 1700, 10, "Fear" );
	
	public Enemy zombie = new Enemy("Rotten Zombie", 300, 1000, 20, "Fear" );
	
	public Enemy thrall = new Enemy("Morthar's Thrall", 200, 900, 30, "Bleed" );
	
	public Enemy demon = new Enemy("Demon Crusher", 380, 1500, 20, "Break");
	
	public Enemy witch = new Enemy("Frost Witch", 350, 1400, 15, "Break" );
	
	public Enemy boss = new Enemy("Morthar", 550, 6000, 15, "Rend" ); 
	
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
	
	/* Method to populate all the item lists */
	
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
	
	/*
	 * FXML method to handle when the player selects an item in their inventory
	 */
	@FXML
	public void setSelectedItem(MouseEvent event) {
		try {
			String s=inventoryList.getSelectionModel().getSelectedItem();	// Get selected item
			Item i=Item.getItem(ItemList, s);
			itemselect.setText(s);	// Set selected item information
			if(i.getStat().equals("HP"))
				itemStats.setText("+"+i.getChange()+" Health");
			else if(i.getStat().equals("DMG"))
				itemStats.setText("+"+i.getChange()+" Damage");
			else
				itemStats.setText("+"+i.getChange()+" Evasion");
		} catch(Exception e) {
			return;
		}
		
	}
	
	/* Method for player to attempt to run */
	
	@FXML
	public void run(ActionEvent event){
		
		Random rand = new Random();	
		
		if(combat == true && currentPos != finishCircle) {	// Check if the player is in combat and they are not at the boss circle
		
			int runCalc = rand.nextInt(101);
		
			if(runCalc <= 25) {	// Roll for ability to run
			
			
				events.appendText("Run Successful! WOOSH\n");
				
				combat=false;
			
			} else if(runCalc > 20) {		
		
				events.appendText("Run Failed! Prepare for pain!\n");	
				
				enemyAttack();
			}
		
		}
		else if(combat == true && currentPos == finishCircle) {	// Inform player they cannot run at boss
			
			events.appendText("There is no escaping Morthar!\n");
			
			enemyAttack();
			
		}
		
	}
	
	/*
	 * Method to roll for a random drop
	 */
	public void rollCommonDrop() {
		Random r=new Random();
		
		int x=r.nextInt(6);
		Item i=randomDrops.get(x);
		addItem(i.getName());
		
		events.appendText("You find an "+i.getName()+" in your adventures!\n");	// Inform player
	}
	
	/*
	 * Method to roll for a combat drop
	 */
	public void rollCombatDrop() {
		Random r=new Random();
		
		int x=r.nextInt(3);
		Item i=combatDrops.get(x);
		addItem(i.getName());
		
		events.appendText("You find an "+i.getName()+" after defeating the "+e.getName()+"!\n"); // Infrom player
	}
	
	
	
	/*Method for player to use item */
	
	@FXML
	public void useItem(ActionEvent event){
			String itemName="";
			itemName = itemselect.getText();
		
			if(itemName.equals("")) {	// Checks if selected item is blank
			
				events.appendText("Select an item from the Inventory box before clicking this button!\n");	
				return;
			
			} else {	// Begins getting item information
				Item i;
				int x;
				i=Item.getItem(ItemList, itemName);	// Get item from the item list
				
				if(i == null) {	// Check if the item isnt found in the item list
					
					events.appendText("Item not Found!\n");
					itemselect.setText("");
					itemStats.setText("");
				} else {	// Check what type of item was used
					if(i.getStat().equals("HP")) {
						int y=p.getHP()+i.getChange();
						if(y>p.getMaxHP()) {
							p.setHP(p.getMaxHP());
							events.appendText("Health Restored to Full!\n");
					}
					else {
						p.setHP(y);
						events.appendText("Health Restored by " + i.getChange()+"\n");
					}
					currentHp.setText(p.getHP()+"/"+p.getMaxHP());
					playerHPBar.setProgress((double)p.getHP()/p.getMaxHP());
				}else if(i.getStat().equals("DMG")) {
					p.setDMG(p.getDMG()+i.getChange());
					gdmg.setText(""+p.getDMG());
					events.appendText("Damage Increased by " + i.getChange()+"\n");
				}else {
					p.setEV(p.getEV()+i.getChange());
					gev.setText(""+p.getEV());
					events.appendText("EV Increased by " + i.getChange()+"\n");
				}
				
				// Remove the item from the inventory
				x=Inventory.indexOf(i);
				Inventory.remove(x);
				inventoryList.getItems().remove(x);
				itemselect.setText("");
				itemStats.setText("");
				}
			}
		
		}
		
	
	/*
	 * Method for fxml injection from previous controller
	 */
	/* Set basic Player attributes in BaseLevel */
	
	public void setPlayerAttributes(String title, Player p) {	
		name_Class.setText(title);
		currentHp.setText(p.getHP()+"/"+p.getMaxHP());
		playerHPBar.setProgress((double)p.getHP()/p.getMaxHP());
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
		setValidMoves();
		setCurrentPos();

	}

	/*
	 * Method to get the valid moves for the player and update it 
	 */
	private void setValidMoves() {
		l.getValidMoves();

		if(l.upValid) {	// Update upward movement
			tmp=layout_Circle[l.y-1][l.x];
			tmp.setFill(Paint.valueOf("Green"));
		}

		if(l.leftValid) {	// Update leftward movement
			tmp=layout_Circle[l.y][l.x-1];
			tmp.setFill(Paint.valueOf("Green"));
		}

		if(l.rightValid) {	// Update rightward movement
			tmp=layout_Circle[l.y][l.x+1];
			tmp.setFill(Paint.valueOf("Green"));
		}
	}

	/*
	 * Method to set the layout of the map
	 */
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

	/*
	 * FXML method to handle moving left
	 */
	@FXML
	private void moveLeft(ActionEvent event) {
		
		Random rand = new Random();
		
		int combatroll = rand.nextInt(101);
		int itemroll = rand.nextInt(101);
		
		if(l.leftValid && combat == false) {
			unsetValidMoves();
			l.moveLeft();
			setCurrentPos();
			if(combatroll <= 80) { // Roll for combat
				
				combat();	
			}else if(itemroll>=40) {
				rollCommonDrop();
			}
		}else {
			return;
		}
	}

	/*
	 * FXML method to handle moving right
	 */
	@FXML
	private void moveRight(ActionEvent event) {
		
		Random rand = new Random();
		
		int combatroll = rand.nextInt(101);
		int itemroll = rand.nextInt(101);
		
		if(l.rightValid && combat == false) {
			unsetValidMoves();
			l.moveRight();
			setCurrentPos();
			
			if(combatroll <= 80) { // Roll for combat
				
			combat();	
			}else if(itemroll>=40) {
				rollCommonDrop();
			}
		}else {
			return;
		}
	}

	/*
	 * FXML method to handle moving up
	 */
	@FXML
	private void moveUp(ActionEvent event) {
		
		Random rand = new Random();
		
		int combatroll = rand.nextInt(101);
		int itemroll = rand.nextInt(101);
		
		
		if(l.upValid && combat == false) {
			unsetValidMoves();
			l.moveUp();
			setCurrentPos();

			if(currentPos != finishCircle) {
				if(combatroll >= 80) { 
				
					combat();	
				}else if(itemroll>=40) {
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

	/*
	 * Method to unset the valid moves before the player moves
	 */
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

	/*
	 * Method to update the gui version of the players current position
	 */
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
		
		enemyHPBar.setProgress((double)e.getHP()/e.getMaxHP());
		
		String outDMG = Integer.toString(e.getDMG());
		
		edmg.setText(outDMG);
		
		String outEV = Integer.toString(e.getEV());
		
		eev.setText(outEV);
		
		especial.setText(e.getSpecial());
		
		events.appendText(e.getName() + " approaches!\n");
			
		
		events.appendText("What will you do?\n");				
	
	
		
}
	/* Combat method */
	@FXML
	public void bossfight(){
	
		events.clear();	 // Set enemy attributes and begin combat
			
		combat = true;
		
		e = EnemyList.get(10).copy();
		
		ename.setText(e.getName());
		
		ecurrentHp.setText(e.getHP() + "/" + e.getMaxHP());
		
		enemyHPBar.setProgress((double)e.getHP()/e.getMaxHP());
		
		String outDMG = Integer.toString(e.getDMG());
		
		edmg.setText(outDMG);
		
		String outEV = Integer.toString(e.getEV());
		
		eev.setText(outEV);
		
		especial.setText(e.getSpecial());
		
		events.appendText("You enter Morthar's lair and engage the beast!\n");
			
		events.appendText("What will you do?\n");				
	
	
		
	}
	/*Method for player to attack */ 
	
	@FXML
	public void attack(ActionEvent event) {
		if(!combat)
			return;
	
	Random rand = new Random();		
		
	if(combat == true) {
		
	events.appendText(p.getName() + " attacks!\n");	
	
	int eEV = e.getEV(); 
	
	int roll = rand.nextInt(101);
	
	if(roll <= eEV) { // Enemy evades
		
		events.appendText("Your was attack evaded!\n");
		
		}		
	else if(roll > eEV) { // Enemy is damaged
		
		e.setHP(e.getHP() - p.getDMG());
		
		String ehealth = e.getHP()+"/"+e.getMaxHP();
		
		if(e.getHP()<1) {
			e.setDead(true);
			ecurrentHp.setText(""+0);
			enemyHPBar.setProgress((double)0);
		}else {
			ecurrentHp.setText(ehealth);
			enemyHPBar.setProgress((double)e.getHP()/e.getMaxHP());
		}
		
		
		
		}
	}
	
	if(e.isDead() && currentPos != finishCircle) { // Game proceeds if monster dies and is not the final boss
		
		events.clear();
		
		events.appendText("The monster lies dead! Onward!\n");
		
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
	
	/*
	 * Method to handle when the enemy attacks after the player
	 */
	private void enemyAttack() {
		
		Random rand = new Random();	
		
		int roll = rand.nextInt(101);
		
		int sroll = rand.nextInt(101);
		
		events.appendText(e.getName() + " attacks!\n");
		
		if(roll <= p.getEV()) { // Player evades
			
			events.appendText("You evaded "+e.getName()+"\'s Attack!\n");
			
		}else if(roll > p.getEV()) { // Player is hit and dies if HP is 0 or less
			
			p.setHP(p.getHP() - e.getDMG());
			
			String newHp = p.getHP()+"/"+p.getMaxHP();
			
			String effect = e.getSpecial(); // Stats are afflicted
			
			if(sroll < 51){
				
			if(effect == "Bleed") { // Bleed Special
				
				p.setHP(p.getHP() - 100);
				
				events.appendText("You bleed profusely. - 100 HP\n");
				
				newHp = String.valueOf(p.getHP()+"/"+p.getMaxHP());
			}
			if(effect == "Break") { // Break Special 
				
				if(p.getEV()-5>0)
					p.setEV(p.getEV() - 5);
				else
					p.setEV(0);
				
				events.appendText("You feel a bone break restricting movement. - 5 EV\n");
				
				String newEV = String.valueOf(p.getEV());
				
				gev.setText(newEV);
				
			}
			if(effect == "Fear") { // Fear Special 
				
				if(p.getDMG()-40>0)
					p.setDMG(p.getDMG() - 40);
				else
					p.setDMG(0);
				
				events.appendText("A crippling fear rattles your resolve. - 40 DMG\n");
				
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
				
				events.appendText("Morthar unleashes a pillar of flame!  - 30 DMG and - 5 EV\n");
				
				String newDMG = String.valueOf(p.getDMG());
				
				String newEV = String.valueOf(p.getEV());
				
				gdmg.setText(newDMG);
				
				gev.setText(newEV);
			}
			
		}
			
			if(p.getHP() <= 0) {
				
				p.setDead(true);
				
				currentHp.setText(0+"/"+e.getMaxHP());
				playerHPBar.setProgress((double)0);
			}else {
				
				currentHp.setText(newHp);
				playerHPBar.setProgress((double)p.getHP()/p.getMaxHP());
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
	
	/*
	 * Method to load Game over screen
	 */
	public void LoadGO() throws IOException { 
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("application/view/GameOver.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = stage;// pane you are ON
        window.setScene(scene);
        window.show();
        
	}
	
	/*
	 * Method to load the victory screen
	 */
	public void LoadWin() throws IOException { 
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("application/view/Victory.fxml"));
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
