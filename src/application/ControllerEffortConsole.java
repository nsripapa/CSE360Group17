package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.RootPaneContainer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllerEffortConsole extends Controller implements Initializable 
{
	LocalTime startTime, endTime; int elapsedMinutes, elapsedSeconds, elapsedHours;
	LocalDate date;
	
	@FXML
	private ControllerMenuBar menuBarController;
	
	@FXML
	private ControllerMenuBarUserAccess menuBarControllerUser;
	
	@FXML
	private Label timerLabel;
	
	@FXML
	private Label userLabel;
	
	String username;
	DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss"); // Time format
	
	// starts logging time
	public void startActivity(ActionEvent e) {
		startTime = java.time.LocalTime.now();
		date = java.time.LocalDate.now();
		
		timerLabel.setText("Activity started at time: " + startTime.format(form) + " on " + date.toString()); 
	}
	
	// stops logging time
	public void endActivity(ActionEvent e) {
		
		if(startTime != null) {
			
		endTime = java.time.LocalTime.now();
		
		timerLabel.setText("Activity ended at time: " + endTime.format(form));
		
		}
	}
	
	public void setUser(String user) {
		username = user;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		userLabel.setText("Logged in as: " + username);
		menuBarController.manageButtons("EffortConsole");
	}
}

