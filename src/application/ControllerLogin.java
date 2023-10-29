//AUTHOR: JACOB FETT
//This is the controller for the login screen of EffortLogger V2. When you launch the program, you will be brought to the login screen.
//Once logged in, you will be brought to the main program.

//Design Alignment:
//The implementation aligns with the design by offering a user-friendly login experience.
//It verifies user credentials, demonstrating the design goal of user authentication.

//Results and Goal Satisfaction:
//Successful login demonstrates that the design goal of authenticating users is satisfied.
//Invalid login provides feedback for incorrect credentials, satisfying the design goal of handling incorrect input.


package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerLogin 
{

	
	@FXML
	private TextField textFieldUN;
	@FXML
	private Button buttonLogin;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label labelMessage;
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	UNandPW usersAndPasswords = new UNandPW();
	
	//on login button click
	public void login(MouseEvent e) throws IOException
	{
		
		//get user and password from text fields
		String user = textFieldUN.getText();
		String password = String.valueOf(passwordField.getText());
		
		//if user exists
		if(usersAndPasswords.loginInfo.containsKey(user))
		{
			//if correct password
			if(usersAndPasswords.loginInfo.get(user).equals(password))
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortConsole.fxml"));
				root = loader.load();
				ControllerEffortConsole ec = loader.getController();
				ec.setUser(user);
				ec.setUserLabelText(user);
				
				stage = (Stage)((Node)e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

				
				
				
			} else
			{
				//username matches, not password
				labelMessage.setText("Incorrect Password");
				labelMessage.setVisible(true);
			}
		} else
		{
			//username does not match
			labelMessage.setText("Username Not Found");
			labelMessage.setVisible(true);
		}
	}
	

}
