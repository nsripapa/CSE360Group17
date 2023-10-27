package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerLogin {

	
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
		String user = textFieldUN.getText();
		String password = String.valueOf(passwordField.getText());
		
		if(usersAndPasswords.loginInfo.containsKey(user))
		{
			if(usersAndPasswords.loginInfo.get(user).equals(password))
			{
				root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
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
