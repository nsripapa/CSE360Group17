package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


//every controller should inherit this class
//write methods in this class that will be used in multiple different scenes
public class Controller implements Initializable
{

	protected Definitions definitions = Definitions.getInstance();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public String username;
	
	public void setUser(String user) {
		username = user;
	}
	public String getUser() {
		return username;
	}
	
	public void save() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("definitions.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		//save definitions
		Definitions definitions = Definitions.getInstance();
		oos.writeObject(definitions);
		
		
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("definitions.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Definitions definitions = (Definitions)ois.readObject();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	
	


}
