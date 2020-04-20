package application;
	
import javafx.application.Application; // All necessary javafx imports are called
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/StartScreen.fxml")); //fxml file is inked to main class
			Scene scene = new Scene(root,1100,900);
			primaryStage.setTitle("Quest for the sword"); //window title is set 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
