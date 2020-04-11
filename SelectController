package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectController {

	@FXML
	public AnchorPane rootPane1;
	
	@FXML
	public Button start = null; //button to change screens
	
	@FXML
	public Button end = null; //button to change screens
	
	@FXML	
	public void LoadUser(ActionEvent event) throws IOException {
	
		rootPane1 = FXMLLoader.load(getClass().getResource("CharSelect.fxml"));
        Scene scene = new Scene(rootPane1);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
	}	
	
	@FXML
	public void exit() {
		System.exit(0);
	}
}
