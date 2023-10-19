package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class ControllerEffortConsole extends Controller implements Initializable 
{
	@FXML
	private ControllerMenuBar menuBarController;
	
	
	public void startActivity(MouseEvent e)
	{
		System.out.println("Activity Started"); //just making sure the button works
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		menuBarController.manageButtons("EffortConsole");
	}
}

