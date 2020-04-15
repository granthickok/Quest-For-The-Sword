package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent; // all necessary java fx imports are called 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectController  implements Initializable{
	
	@FXML
	public AnchorPane rootPane1;
	
	@FXML
	public Label name_Class=null;
	
	@FXML
	public Label currentHp=null;
	
	@FXML
	public Button start = null; // Button to start game
	
	@FXML
	public Button end = null; // Button to exit
	
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
	public TextField inputname = null; // Text field for player to enter name
	
	@FXML
	public ProgressBar currentHpBar=null;
	
	public class player{ // Player class
		
		public String name; // Name of player

		public String role; // Class of player

		public int DMG; // Damage of player

		public int HP; // Health of player
		
		public int maxHp; // Max health of player

		public float EV; // Evade chance of player

		public player() { // Default constructor
					
					
			name = "";
	
			role = "";
	
			DMG = 0;
	
			HP = 0;
			
			maxHp=0;
	
			EV = 0;
				
			}

		public player(String n, String r, int d, int h, float e){ // Defined player constructor
					
			this.name = n;
	
			this.role = r;
	
			this.DMG = d;
	
			this.HP = h;
			
			maxHp=h;
	
			this.EV = e;
		
		}
			
		public void setMage() { // Set player class to mage
					
			this.role = "Mage";
	
			this.DMG = 480;
	
			this.HP = 3500;
			
			maxHp=HP;
	
			this.EV = (1/7);
					
		}

		public void setWarrior() { // Set player class to warrior
					
			this.role = "Warrior";
	
			this.DMG = 420;
	
			this.HP = 4500;
			
			maxHp=HP;
	
			this.EV = (1/10);
					
		}

		public void setThief() { // Set player class to thief
					
			this.role = "Thief";
	
			this.DMG = 460;
	
			this.HP = 3000;
			
			maxHp=HP;
	
			this.EV = (1/3);
	
		}
			
		public void setMonk() { // Set player class to monk
					
			this.role = "Monk";
	
			this.DMG = 440;
	
			this.HP = 3300;
			
			maxHp=HP;
	
			this.EV = (1/5);
		
		}	
			
	}
	
	public player playboy = new player(); // New player is created
	
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
	
	@FXML
	public void levelSelect(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("BaseLevel.fxml"));
		rootPane1 = loader.load();
		SelectController controller=loader.<SelectController>getController();	// Controller for FXML injection
		controller.setPlayerAttributes(playboy.name + " the " + playboy.role, playboy);
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
	}
	
	public void setPlayerAttributes(String title, player p) {	// Set basic player attributes in BaseLevel
		name_Class.setText(title);
		currentHp.setText(p.HP+"/"+p.maxHp);
		currentHpBar.setProgress((double)(p.HP-1000)/p.maxHp);
		playboy=p;
	}
	
	@FXML
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
