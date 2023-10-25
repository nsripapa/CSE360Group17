package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerDefinitions extends Controller implements Initializable
{
	@FXML
	private ControllerMenuBar menuBarController;
	@FXML
	private ChoiceBox<String> choiceBoxSection, choiceBoxList, chioceBox1, choiceBox2;
	@FXML
	private Button buttonAddList, buttonDeleteList, buttonEditList,
	buttonAddChoiceBox1, buttonDeleteChoiceBox1, buttonAddChoiceBox2, buttonDeleteChoiceBox2;
	@FXML
	private TextField textField;
	
	private String[] sections = {"Projects", "Life Cycle Steps", "Effort Categories", 
			"Plans", "Deliverables", "Interruptions", "Defect Categories"};
	
	private Definitions definitions = new Definitions();
	
	private void setChoiceBoxList(String newValue) 
	{
		switch (newValue)
		{
		case ("Projects"):
			if (definitions.projects != null)
			{
				for (Project project : definitions.projects)
				{
					choiceBoxList.getItems().add(project.name);
				}
			}
		case ("Life Cycle Steps"):
			if (definitions.lifeCycleSteps != null)
			{
				for (LifeCycleStep lifeCycleStep : definitions.lifeCycleSteps)
				{
					choiceBoxList.getItems().add(lifeCycleStep.name);
				}
			}
		case ("Plans"):
			if (definitions.effortCategories != null)
			{
				for (EffortCategory effortCategory : definitions.effortCategories)
				{
					choiceBoxList.getItems().add(effortCategory.name);
				}
			}
		case ("Deliverables"):
			if (definitions.effortCategories != null)
			{
				for (EffortCategory effortCategory : definitions.effortCategories)
				{
					choiceBoxList.getItems().add(effortCategory.name);
				}
			}
		case ("Interruptions"):
			if (definitions.effortCategories != null)
			{
				for (EffortCategory effortCategory : definitions.effortCategories)
				{
					choiceBoxList.getItems().add(effortCategory.name);
				}
			}
		case ("Defect Categories"):
			if (definitions.effortCategories != null)
			{
				for (EffortCategory effortCategory : definitions.effortCategories)
				{
					choiceBoxList.getItems().add(effortCategory.name);
				}
			}
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//darken the Definitions Button
		menuBarController.manageButtons("Definitions");
		
		//add the sections to the first ChocieBox
		choiceBoxSection.getItems().addAll(sections);
		
		//listen for when the first ChoiceBox changes
		choiceBoxSection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				// TODO Auto-generated method stub

				//set the options for the 2nd ChoiceBox
				setChoiceBoxList(newValue);
			}

			
		});
	}
}
