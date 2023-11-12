package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.RootPaneContainer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerEffortConsole extends Controller implements Initializable 
{
	LocalTime startTime, endTime; int elapsedMinutes, elapsedSeconds, elapsedHours;
	LocalDate date;
	
	@FXML
	private ControllerMenuBar menuBarController;
	
	@FXML
	private Label timerLabel;
	
	@FXML
	private Label userLabel;
	
	@FXML
	private ChoiceBox<String> choiceBoxProj, choiceBoxLCS, choiceBoxEC1, choiceBoxEC2;
	
	Definitions definitions = Definitions.getInstance();
	
	private List<String> projectList = definitions.getProjectNames();
	private List<String> lcsList = definitions.getLifeCycleStepNames();
	
	String username;
	PrivilegeLevels pl = new PrivilegeLevels();
	DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss"); // Time format
	
	// starts logging time
	public void startActivity(ActionEvent e) {
		startTime = java.time.LocalTime.now();
		date = java.time.LocalDate.now();
		
		timerLabel.setText("Activity started at time: " + startTime.format(form) + " on " + date.toString()); 
		
		// add code here to start logging
	}
	
	// stops logging time
	public void endActivity(ActionEvent e) {
		
		if(startTime != null) {
			
		endTime = java.time.LocalTime.now();
		
		timerLabel.setText("Activity ended at time: " + endTime.format(form));
		
		// add code here to stop logging
		}
	}
	
	// grab username from login screen
	public void setUser(String user) {
		username = user;
	}
	
	// set label at bottom left
	public void setUserLabelText(String user)
	{
		String perms = "";
		if(pl.accesslevel.get(user).equals("admin")) {
			perms = " as an Administrator";
		}
		else {
			perms = " as a User";
		}
		userLabel.setText("Logged in: " + username + perms);
	}
	
	
	public void getLifeCycleStepsList() {
		if(choiceBoxProj.getValue() == null) {
			return;
		}
		Project project = getProjectFromChoiceBox(choiceBoxProj);
		
		List<String> lifeCycleSteps = new ArrayList<>();
		for(LifeCycleStep lcs : definitions.lifeCycleSteps) {
			if(!project.lifeCycleSteps.contains(lcs)) {
				lifeCycleSteps.add(lcs.name);
			}
		}
		
		choiceBoxLCS.setItems(FXCollections.observableArrayList(lifeCycleSteps));
	}
	public void getEffortCategoryList() {
		if(choiceBoxProj.getValue() == null) return;
		if(choiceBoxLCS.getValue() == null) return;
		
		choiceBoxEC1.setItems(FXCollections.observableArrayList(definitions.getEffortCategoryNames()));
	}
	public void getEffortCategoryList2() {
		if(choiceBoxProj.getValue() == null) return;
		if(choiceBoxLCS.getValue() == null) return;
		if(choiceBoxEC1.getValue() == null) return;
		
		choiceBoxEC2.setItems(null);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		menuBarController.manageButtons("EffortConsole");
		choiceBoxProj.getItems().addAll(projectList);
		
		choiceBoxProj.setOnAction(e -> {
			getLifeCycleStepsList();
		});
		
		choiceBoxLCS.setOnAction(e -> {
			getEffortCategoryList();
		});
		
		choiceBoxEC1.setOnAction(e -> {
			
		});
		
		choiceBoxEC2.setOnAction(e -> {
			
		});
		
		
	}
}

