package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//every controller should inherit this class
//write methods in this class that will be used in multiple different scenes
public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//switch to EffortConsole scene
	public void goToEffortConsole(ActionEvent e) throws IOException
	{

		Parent root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to EffortLogEditor scene
	public void goToEffortLogEditor(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to DefectConsole scene
	public void goToDefectConsole(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("DefectConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to Logs scene
	public void goToLogs(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("Logs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to Definitions scene
	public void goToDefinitions(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("Definitions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to LogManager scene
	public void goToLogManager(ActionEvent e) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("LogManager.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
}
