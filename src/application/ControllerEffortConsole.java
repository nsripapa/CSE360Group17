package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.time.Duration;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerEffortConsole extends Controller implements Initializable 
{
	LocalTime startTime, endTime; int elapsedMinutes, elapsedSeconds, elapsedHours;
	LocalDate date;
	
	@FXML
	private ControllerMenuBar menuBarController;
	
	@FXML
	private Label timerLabel, userLabel;
	
	@FXML
	private Button startButton, endButton;
	@FXML
	private ChoiceBox<String> choiceBoxProj, choiceBoxLCS, choiceBoxEC1, choiceBoxEC2;
	
	Definitions definitions = Definitions.getInstance();
	
	private List<String> projectList = definitions.getProjectNames();
	
	String username;
	PrivilegeLevels pl = new PrivilegeLevels();
	DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss"); // Time format
	
	// starts logging time
	public void startActivity() {
		
		startTime = java.time.LocalTime.now();
		date = java.time.LocalDate.now();
		
		timerLabel.setText("Activity started at time: " + startTime.format(form) + " on " + date.toString()); 
		//addLog(date.toString(), startTime.format(form));
		
	}
	
	// stops logging time
	public void endActivity() {
		if(startTime != null) {
			
			endTime = java.time.LocalTime.now();
		
			timerLabel.setText("Activity ended at time: " + endTime.format(form));
			addLog(date.toString());
		}
	}
	
	public void addLog(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Duration duration = Duration.between(startTime, endTime);
		LocalTime durationAsTime = LocalTime.MIDNIGHT.plus(duration);
		
		EffortLog effortLog = new EffortLog();
		effortLog.date = date;
		effortLog.start = startTime.format(formatter);
		effortLog.stop = endTime.format(formatter);
		effortLog.time = durationAsTime.format(formatter);
		effortLog.lifeCycleStep = choiceBoxLCS.getValue();
		effortLog.effortCategory = choiceBoxEC1.getValue();
		effortLog.delivInterEtc = choiceBoxEC2.getValue();
		
		int index = 0;
		for(int i = 0; i < projectList.size(); i++) {
			if(choiceBoxProj.getValue() == projectList.get(i)) {
				index = i;
			}
		}
		
		Project project = definitions.projects.get(index);
		project.getLogs().getEffortLogs().add(effortLog);
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
		
		choiceBoxEC2.setItems(FXCollections.observableArrayList(definitions.getDeliverableNames()));
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
			getEffortCategoryList2();
		});
		
		choiceBoxEC2.setOnAction(e -> {
			
		});
		
		startButton.setOnAction(e -> {
			startActivity();
		});
		endButton.setOnAction(e -> {
			endActivity();
		});
		
		
	}
}

