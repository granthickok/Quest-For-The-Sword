package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Enemy;
import application.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

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
	
	private Enemy e;
	private Player p;
	
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
		
	}

}
