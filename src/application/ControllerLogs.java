package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class ControllerLogs extends Controller implements Initializable 
{
	@FXML
	private ControllerMenuBar menuBarController;
	@FXML
	private ChoiceBox<String> choiceBoxProject;
	@FXML
	private TextArea textAreaEffort, textAreaDefect;
	
	Definitions definitions = Definitions.getInstance();
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("Logs");
		
		choiceBoxProject.setItems(FXCollections.observableArrayList(definitions.getProjectNames()));
		
		choiceBoxProject.setOnAction(e -> {
			
			
		});
	}
}
