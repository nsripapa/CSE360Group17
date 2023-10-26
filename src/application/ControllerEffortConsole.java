package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControllerEffortConsole extends Controller implements Initializable 
{
	LocalTime startTime, endTime; int elapsedMinutes, elapsedSeconds, elapsedHours;
	LocalDate date;
	@FXML
	private ControllerMenuBar menuBarController;
	
	
	
	public void startActivity(ActionEvent e) {
		startTime = java.time.LocalTime.now();
		date = java.time.LocalDate.now();
		
		System.out.println("Activity started at time: " + startTime.toString() + " on " + date.toString());
	}
	
	
	public void endActivity(ActionEvent e) {
		if(startTime != null) {
			
		endTime = java.time.LocalTime.now();
		elapsedSeconds = endTime.getSecond() - startTime.getSecond();
		elapsedMinutes = endTime.getMinute() - startTime.getMinute();
		elapsedHours = endTime.getHour() - startTime.getHour();
		
		System.out.println(elapsedHours + ":" + elapsedMinutes + ":" + elapsedSeconds);
		
		System.out.println(date.toString());
		}
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("EffortConsole");
	}
}

