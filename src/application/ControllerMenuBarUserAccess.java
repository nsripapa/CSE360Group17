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

public class ControllerMenuBarUserAccess extends Controller {
	
	@FXML
	private Button buttonEffortConsole;
	@FXML
	private Button buttonDefinitions;
	@FXML
	private Button buttonPlanningPoker;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void goToEffortConsole(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void goToDefinitions(MouseEvent e) throws IOException
	{
		
		root = FXMLLoader.load(getClass().getResource("Definitions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void goToPlanningPoker(MouseEvent e) throws IOException
	{
			
		root = FXMLLoader.load(getClass().getResource("PlanningPoker.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	public void manageButtons(String scene)
	{
		buttonEffortConsole.getStyleClass().removeAll("selected-button");
		buttonDefinitions.getStyleClass().removeAll("selected-button");
		buttonPlanningPoker.getStyleClass().removeAll("selected-button");
		
		switch(scene)
		{
			case ("EffortConsole"):
				buttonEffortConsole.getStyleClass().add("selected-button");
				break;
			case ("Definitions"):
				buttonDefinitions.getStyleClass().add("selected-button");
				break;
			case ("PlanningPoker"):
				buttonPlanningPoker.getStyleClass().add("selected-button");
				break;
		}
		
	}
}
