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
	
	public void displayLogs()
	{
		textAreaEffort.clear();
		textAreaDefect.clear();
		//get the project
		Project project = null;
		String projectName = choiceBoxProject.getValue();
		
		for (Project p : definitions.projects)
		{
			if (p.name == projectName)
			{
				project = p;
				break;
			}
		}
		
		int i = 1;
		for (EffortLog el : project.logs.effortLogs)
		{
			textAreaEffort.appendText(i + ". ");
			
			textAreaEffort.appendText(el.date + " | ");
			textAreaEffort.appendText(el.start + " | ");
			textAreaEffort.appendText(el.stop + " | ");
			textAreaEffort.appendText(el.time + " | ");
			textAreaEffort.appendText(el.lifeCycleStep + " | ");
			textAreaEffort.appendText(el.effortCategory + " | ");
			textAreaEffort.appendText(el.delivInterEtc);
			
			textAreaEffort.appendText("\n");
			i++;
		}
		
		i = 1;
		for (DefectLog dl : project.logs.defectLogs)
		{
			textAreaDefect.appendText(i + ". ");
			
			textAreaDefect.appendText(dl.name + " | ");
			textAreaDefect.appendText(dl.detail + " | ");
			textAreaDefect.appendText(dl.injected + " | ");
			textAreaDefect.appendText(dl.removed + " | ");
			textAreaDefect.appendText(dl.category + " | ");
			textAreaDefect.appendText(dl.status + " | ");
			textAreaDefect.appendText(dl.fix + " | ");
			
			textAreaDefect.appendText("\n");
			i++;
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("Logs");
		
		choiceBoxProject.setItems(FXCollections.observableArrayList(definitions.getProjectNames()));
		
		//predefined log values for testing---------------------------------------------------------------
		EffortLog el = new EffortLog();
		DefectLog dl = new DefectLog();
		
		Project project = definitions.projects.get(1);
		//project.logs.effortLogs
		
		//-------------------------------------------------------------------------------------------------
		choiceBoxProject.setOnAction(e -> {
			if (choiceBoxProject.getValue() != null)
			{
				displayLogs();
			}
			
		});
	}
}
