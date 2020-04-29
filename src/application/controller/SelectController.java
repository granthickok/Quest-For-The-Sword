/*
 * Controller class to Handle various inputs from the user for the first few pages of the application
 */

package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Player;
import javafx.event.ActionEvent; // all necessary java fx imports are called 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
	}	
	
	@FXML
	public AnchorPane rootPane1;	// AnchorPane to save fxml files to
	
	@FXML
	public Button start = null; // Button to start game
	
	@FXML
	public Button back = null; // Button to return to char select
	
	@FXML
	public Button end = null; // Button to exit
	
	@FXML
	public Button embark = null; // Button to start the game
	
	@FXML
	public Button retry = null; // Button to retry game
	
	@FXML
	public Button nameset = null; // Button to set Player name
	
	@FXML
	public Button bmage = null; // Button to set Player class to mage
	
	@FXML
	public Button bthief = null; // Button to set Player class to thief
	
	@FXML
	public Button bwarrior = null; // Button to set Player class to warrior
	
	@FXML
	public Button bmonk = null; // Button to set Player class to monk
	
	@FXML
	public Button finalize = null; // Button to finalize character
	
	@FXML
	public Button test = null; // Button to finalize character
	
	@FXML
	public Label plschoose = null;
	
	@FXML
	public Label gname = null; // Name displayed in game
	
	@FXML
	public Label ghp = null; // Hp displayed in game
	
	@FXML
	public TextField inputname = null; // Text field for Player to enter name
	
		
	
	/* Player is created */
	
	public static Player playboy = new Player();
	
	
	/* Method to set Player name */

	@FXML	
	public void setname(ActionEvent event) {
	
		String set = inputname.getText();
		
		playboy.setName(set);
		
		inputname.clear();
	}

	/* Methods to set Player class */
	
	@FXML
	public void toMage(ActionEvent event) {
	
	
		playboy.setMage();
	}

	@FXML
	public void toWarrior(ActionEvent event) {
	
	
		playboy.setWarrior();
		
	}

	@FXML
	public void toThief(ActionEvent event) {
	
	
		playboy.setThief();
		
	}

	@FXML
	public void toMonk(ActionEvent event) {
	
	
		playboy.setMonk();
		
	}
	
	/* Method to change to character select */
	
	@FXML	
	public void LoadUser(ActionEvent event) throws IOException { 
	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("application/view/CharSelect.fxml"));
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
		loader.setLocation(getClass().getClassLoader().getResource("application/view/BaseLevel.fxml"));
		rootPane1 = loader.load();
		LevelController controller=loader.<LevelController>getController();	// Controller for FXML injection
		controller.setPlayerAttributes(playboy.getName() + " the " + playboy.role, playboy);
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        controller.setStage(window);
        window.setScene(scene);
        window.show();
        
	}	

	/* Method to change to How to play */ 

	@FXML	
	public void LoadHTP(ActionEvent event) throws IOException { 
		
		if(playboy.role == "" || playboy.getName() == "") {
			
		plschoose.setText("Please set a name and class to proceed");	
		
		}
		else {	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("application/view/HowToPlay.fxml"));
		rootPane1 = loader.load();
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
		}
	}

	@FXML
	public void exit() {
		System.exit(0);
	}
}
