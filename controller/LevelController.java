package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import application.model.Enemy;
import application.model.Item;
import application.model.Levels;
import application.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class LevelController implements Initializable{
	
	@FXML
	public Label gdmg = null; // Damage displayed in game
	
	@FXML
	public Label gev = null; // EV displayed in game
	
	@FXML
	public Label name_Class=null;

	@FXML
	public Label currentHp=null;
	
	@FXML
	public ProgressBar currentHpBar=null;
	
	@FXML
	public Circle startCircle, pos10, pos11, pos1_1, pos20, pos21, pos22, pos2_1, pos2_2, pos30, pos31, pos32, pos33, pos3_1,
				pos3_2, pos3_3, pos40, pos41, pos42, pos43, pos44, pos4_1, pos4_2, pos4_3, pos4_4, pos50, pos51, pos52, pos53,
				pos5_1, pos5_2, pos5_3, pos60, pos61, pos62, pos6_1, pos6_2, pos70, pos71, pos7_1, pos80, finishCircle;
	
	private Circle currentPos, tmp;
	
	private Enemy e;
	private Player p;
	private Levels l;
	
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
	
	public Item health = new Item("HP up", "HP", 1000, 1);
	
	public Item shealth = new Item("Super HP up", "HP", 2000, 1);
	
	public Item damage = new Item("DMG up", "DMG", 100, 1);
	
	public Item sdamage= new Item("Super DMG up", "DMG", 200, 1);
	
	public Item evade = new Item("EV up", "EV", 10, 1);
	
	public Item sevade = new Item("Super EV up", "EV", 20, 1);	
	
	public static LinkedList<Item> Inventory = new LinkedList<Item>();
	
	
	
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
	
	/* Method to add item to inventory */
	
	public void addItem(Item i) {
		
		Inventory.add(i);	
	
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
		if(l.leftValid) {
			unsetValidMoves();
			l.moveLeft();
			setCurrentPos();
		}else {
			return;
		}
	}
	
	@FXML
	private void moveRight(ActionEvent event) {
		if(l.rightValid) {
			unsetValidMoves();
			l.moveRight();
			setCurrentPos();
		}else {
			return;
		}
	}
	
	@FXML
	private void moveUp(ActionEvent event) {
		if(l.upValid) {
			unsetValidMoves();
			l.moveUp();
			setCurrentPos();
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

}
