package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerEffortLogEditor extends Controller implements Initializable
{
	
	@FXML
	private ControllerMenuBar menuBarController;
	@FXML
	private ChoiceBox<String> choiceBoxProject, choiceBoxLogs, choiceBoxLCS, choiceBoxEC, choiceBoxEtc;
	@FXML
	private TextField textFieldDate, textFieldStart, textFieldEnd;
	@FXML
	private Button buttonDelete, buttonUpdate, buttonSplit;
	
	public void updateLog()
	{
		
		Project project = getProjectFromChoiceBox(choiceBoxProject);
		int logNumber = Character.getNumericValue(choiceBoxLogs.getValue().charAt(0));
		
		EffortLog el = getEffortLog(project, logNumber - 1);
		
		el.date = textFieldDate.getText();
		el.start = textFieldStart.getText();
		el.stop = textFieldEnd.getText();
		el.lifeCycleStep = choiceBoxLCS.getValue();
		el.effortCategory = choiceBoxEC.getValue();
		el.delivInterEtc = choiceBoxEtc.getValue();
		
	}
	
	public void deleteLog()
	{
		Project project = getProjectFromChoiceBox(choiceBoxProject);
		int logNumber = Character.getNumericValue(choiceBoxLogs.getValue().charAt(0));
		
		project.logs.effortLogs.remove(logNumber - 1);
		ClearFields();
	}
	
	public void getLifeCycleStepsList() {
		if(choiceBoxProject.getValue() == null) {
			return;
		}
		Project project = getProjectFromChoiceBox(choiceBoxProject);
		
		List<String> lifeCycleSteps = new ArrayList<>();
		for(LifeCycleStep lcs : definitions.lifeCycleSteps) {
			if(!project.lifeCycleSteps.contains(lcs)) {
				lifeCycleSteps.add(lcs.name);
			}
		}
		
		choiceBoxLCS.setItems(FXCollections.observableArrayList(lifeCycleSteps));
	}
	
	public void getEffortCategoryList() {
		choiceBoxEC.setItems(FXCollections.observableArrayList(definitions.getEffortCategoryNames()));
	}
	
	public void getEffortCategoryList2() {
		choiceBoxEtc.setItems(FXCollections.observableArrayList(definitions.getDeliverableNames()));
	}
	
	public void SetFields()
	{
		Project project = getProjectFromChoiceBox(choiceBoxProject);
		int logNumber = Character.getNumericValue(choiceBoxLogs.getValue().charAt(0));
		EffortLog el = getEffortLog(project, logNumber - 1);
		
		textFieldDate.setText(el.date);
		textFieldStart.setText(el.start);
		textFieldEnd.setText(el.stop);
		
		if(el.lifeCycleStep != "") choiceBoxLCS.getSelectionModel().select(el.lifeCycleStep);
		if(el.effortCategory != "") choiceBoxEC.getSelectionModel().select(el.effortCategory);
		if(el.delivInterEtc != "") choiceBoxEtc.getSelectionModel().select(el.delivInterEtc);
	}
	
	public void ClearFields()
	{
		choiceBoxLCS.setValue(null);
		choiceBoxEC.setValue(null);
		choiceBoxEtc.setValue(null);
		textFieldDate.clear();
		textFieldStart.clear();
		textFieldEnd.clear();
		
		Project project = getProjectFromChoiceBox(choiceBoxProject);
		choiceBoxLogs.setItems(FXCollections.observableArrayList(definitions.getEffortLogs(project)));
	}
	
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
		
		choiceBoxLogs.setOnAction(e -> {
			if (choiceBoxLogs.getValue() == null) return;
			getLifeCycleStepsList();
			getEffortCategoryList();
			getEffortCategoryList2();
			SetFields();
		});
	}
}
