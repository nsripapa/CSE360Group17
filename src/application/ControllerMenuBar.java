package application;

import java.io.IOException;

import javafx.event.ActionEvent;
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
	@FXML
	private Button buttonPlanningPoker;
	
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

	//switch to PlanningPoker scene
	public void goToPlanningPoker(MouseEvent e) throws IOException
		{
				
			root = FXMLLoader.load(getClass().getResource("PlanningPoker.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		}
	
	public void logout() throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)buttonEffortConsole.getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void support() throws IOException
	{
		//AUTHOR: Ream Russom Teame
		root = FXMLLoader.load(getClass().getResource("Support.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Support");
		stage.show();
	}
	
	public void feedback() throws IOException
	{
		// author: Augustine Suter
		root = FXMLLoader.load(getClass().getResource("Feedback.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Feedback");
		stage.show();
	}
	
	//keep the tab for the active scene "darkened"
	public void manageButtons(String scene)
	{
		buttonEffortConsole.getStyleClass().removeAll("selected-button");
		buttonEffortLogEditor.getStyleClass().removeAll("selected-button");
		buttonDefectConsole.getStyleClass().removeAll("selected-button");
		buttonLogs.getStyleClass().removeAll("selected-button");
		buttonDefinitions.getStyleClass().removeAll("selected-button");
		buttonLogManager.getStyleClass().removeAll("selected-button");
		buttonPlanningPoker.getStyleClass().removeAll("selected-button");
		
		switch(scene)
		{
			case ("EffortConsole"):
				buttonEffortConsole.getStyleClass().add("selected-button");
				break;
			case ("EffortLogEditor"):
				buttonEffortLogEditor.getStyleClass().add("selected-button");
				break;
			case ("DefectConsole"):
				buttonDefectConsole.getStyleClass().add("selected-button");
				break;
			case ("Logs"):
				buttonLogs.getStyleClass().add("selected-button");
				break;
			case ("Definitions"):
				buttonDefinitions.getStyleClass().add("selected-button");
				break;
			case ("LogManager"):
				buttonLogManager.getStyleClass().add("selected-button");
				break;
			case ("PlanningPoker"):
				buttonPlanningPoker.getStyleClass().add("selected-button");
				break;
		}
		
	}
}
