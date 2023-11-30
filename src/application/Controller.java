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
import javafx.scene.control.ChoiceBox;
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
	
	public Project getProjectFromChoiceBox(ChoiceBox<String> cb)
	{
		String pName = cb.getValue();
		
		for (Project p : definitions.projects)
		{
			if (p.name == pName)
			{
				return p;
			}
		}
		
		return null;
	}
	
	public LifeCycleStep getLifeCycleStepFromChoiceBox(ChoiceBox<String> cb)
	{
		String lcsName = cb.getValue();
		
		for (LifeCycleStep lcs : definitions.lifeCycleSteps)
		{
			if (lcs.name == lcsName)
			{
				return lcs;
			}
		}
		
		return null;
	}
	
	public EffortCategory getEffortCategoryFromChoiceBox(ChoiceBox<String> cb)
	{
		String ecName = cb.getValue();
		
		for (EffortCategory ec : definitions.effortCategories)
		{
			if (ec.name == ecName)
			{
				return ec;
			}
		}
		
		return null;
	}
	
	public Deliverable getDeliverableFromChoiceBox(ChoiceBox<String> cb)
	{
		String dName = cb.getValue();
		
		for (Deliverable d : definitions.deliverables)
		{
			if (d.name == dName)
			{
				return d;
			}
		}
		
		return null;
	}
	
	public EffortLog getEffortLog(Project project, int logNumber)
	{
		return project.logs.effortLogs.get(logNumber);
	}
	
	public DefectLog getDefectLog(Project project, int logNumber)
	{
		return project.logs.defectLogs.get(logNumber);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	
	


}
