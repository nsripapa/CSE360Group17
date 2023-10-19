package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControllerDefinitions extends Controller implements Initializable
{
	@FXML
	private ControllerMenuBar menuBarController;
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("Definitions");
	}
}
