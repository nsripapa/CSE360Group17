package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerMenuBar extends Controller
{
	@FXML
	private Button buttonEffortConsole;
	@FXML
	private Button buttonEffortLogEditor;
	@FXML
	private Button buttonDefectConsole;
	@FXML
	private Button buttonLogs;
	@FXML
	private Button buttonDefinitions;
	@FXML
	private Button buttonLogManager;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//switch to EffortConsole scene
	public void goToEffortConsole(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to EffortLogEditor scene
	public void goToEffortLogEditor(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to DefectConsole scene
	public void goToDefectConsole(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("DefectConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to Logs scene
	public void goToLogs(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("Logs.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	//switch to Definitions scene
	public void goToDefinitions(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("Definitions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//switch to LogManager scene
	public void goToLogManager(MouseEvent e) throws IOException
	{
			
		root = FXMLLoader.load(getClass().getResource("LogManager.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	
}
