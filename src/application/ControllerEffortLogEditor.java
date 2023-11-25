package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class ControllerEffortLogEditor extends Controller implements Initializable
{
	
	@FXML
	private ControllerMenuBar menuBarController;
	@FXML
	private ChoiceBox<String> choiceBoxProject;
	@FXML
	private ChoiceBox<String> choiceBoxLogs;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("EffortLogEditor");
		choiceBoxProject.setItems(FXCollections.observableArrayList(definitions.getProjectNames()));
		
		choiceBoxProject.setOnAction(e -> {
			if (choiceBoxProject.getValue() == null) return;
			Project project = getProjectFromChoiceBox(choiceBoxProject);
			choiceBoxLogs.setItems(FXCollections.observableArrayList(definitions.getEffortLogs(project)));
		});
	}
}
