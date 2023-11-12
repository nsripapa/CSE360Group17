package application;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

//Controller for the Definitions.fxml Scene
public class ControllerDefinitions extends Controller implements Initializable
{
	@FXML
	private ControllerMenuBar menuBarController;
	@FXML
	private ChoiceBox<String> choiceBoxSection, choiceBoxList, choiceBox1, choiceBox2;
	@FXML
	private Button buttonAddList, buttonDeleteList, buttonEditList, buttonDeleteChoiceBox1, buttonAddChoiceBox2;
	@FXML
	private TextField textField;
	@FXML
	private Label labelName, labelChoiceBox1, labelChoiceBox2;
	
	private String[] sections = {"Projects", "Life Cycle Steps", "Effort Categories", 
			"Plans", "Deliverables", "Interruptions", "Defect Categories"};
	
	private void setChoiceBoxList(String section)
	{
		choiceBoxList.getItems().clear();
		
		switch (section)
		{
		case ("Projects"):
			if (definitions.projects != null)
			{
					
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getProjectNames()));
				
				labelChoiceBox1.setText("Life Cycle Steps for Project");
				labelChoiceBox1.setVisible(true);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(true);
				buttonAddChoiceBox2.setVisible(true);
			}
			break;
		case ("Effort Categories"):
			if (definitions.effortCategories != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getEffortCategoryNames()));
				labelChoiceBox1.setVisible(false);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;
		case ("Life Cycle Steps"):
			if (definitions.lifeCycleSteps != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getLifeCycleStepNames()));
				
				labelChoiceBox1.setText("Effort Category Default");
				labelChoiceBox1.setVisible(true);
				labelChoiceBox2.setText("Deliverable Default");
				labelChoiceBox2.setVisible(true);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;	
		case ("Plans"):
			if (definitions.plans != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getPlanNames()));
				labelChoiceBox1.setVisible(false);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;
		case ("Deliverables"):
			if (definitions.deliverables != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getDeliverableNames()));
				labelChoiceBox1.setVisible(false);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;
		case ("Interruptions"):
			if (definitions.interruptions != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getInterruptionNames()));
				labelChoiceBox1.setVisible(false);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;
		case ("Defect Categories"):
			if (definitions.defectCategories != null)
			{
				choiceBoxList.setItems(FXCollections.observableArrayList(definitions.getDefectCategoryNames()));
				labelChoiceBox1.setVisible(false);
				labelChoiceBox2.setVisible(false);
				
				buttonDeleteChoiceBox1.setVisible(false);
				buttonAddChoiceBox2.setVisible(false);
			}
			break;
		}
		
	}
	
	public void setProjectLifeCycleSteps()
	{
		
		if (choiceBoxSection.getValue() != "Projects") return;
		
		String selectedProject = choiceBoxList.getValue();
		if (selectedProject == null) return;
		
		for (Project project : definitions.projects)
		{
			if (project.name == selectedProject)
			{
				choiceBox1.setItems(FXCollections.observableArrayList(definitions.getProjectLifeCycleStepNames(project)));
				break;
			}
		}
	}
	
	
	//When an Effort Category is selected, fill the first choice box with the list of Effort Categories
	//and select the default Effort Category
	public void setDefaultEffortCategories()
	{
		if (choiceBoxSection.getValue() != "Life Cycle Steps") return;
		
		String selectedLCS = choiceBoxList.getValue();
		if (selectedLCS == null) return;
		
		LifeCycleStep lifeCycleStep = new LifeCycleStep();
		
		for (LifeCycleStep lcs : definitions.lifeCycleSteps)
		{
			if (lcs.name == selectedLCS)
			{
				lifeCycleStep = lcs;
				break;
			}
		}
		
		choiceBox1.setItems(FXCollections.observableArrayList(definitions.getEffortCategoryNames()));
		if(lifeCycleStep.defaultEffortCategory != null) choiceBox1.getSelectionModel().select(lifeCycleStep.defaultEffortCategory.name);
	}
	
	//When a Deliverable is selected, fill the second choice box with the list of Deliverables
	//and select the default Deliverable
	public void setDefaultDeliverables()
	{
		if (choiceBoxSection.getValue() != "Life Cycle Steps") return;
		
		String selectedLCS = choiceBoxList.getValue();
		if (selectedLCS == null) return;
		
		LifeCycleStep lifeCycleStep = new LifeCycleStep();
		
		for (LifeCycleStep lcs : definitions.lifeCycleSteps)
		{
			if (lcs.name == selectedLCS)
			{
				lifeCycleStep = lcs;
				break;
			}
		}
		
		choiceBox2.setItems(FXCollections.observableArrayList(definitions.getDeliverableNames()));
		if(lifeCycleStep.defaultDeliverable != null) choiceBox2.getSelectionModel().select(lifeCycleStep.defaultDeliverable.name);
	}
	
	public void addListItem(MouseEvent e)
	{
		
		String name = textField.getText();
		textField.clear();
		
		if (name.length() == 0) return;
		
		switch(choiceBoxSection.getValue())
		{
		
		case ("Projects"):
			
			Project project = new Project();
			project.name = name;
			definitions.projects.add(project);
			setChoiceBoxList("Projects");
			break;
			
		case ("Life Cycle Steps"):
			
			LifeCycleStep lifeCycleStep = new LifeCycleStep();
			lifeCycleStep.name = name;
			definitions.lifeCycleSteps.add(lifeCycleStep);
			setChoiceBoxList("Life Cycle Steps");
			break;
			
		case ("Effort Categories"):
			
			EffortCategory effortCategory = new EffortCategory();
			effortCategory.name = name;
			definitions.effortCategories.add(effortCategory);
			setChoiceBoxList("Effort Categories");
			break;
			
		case ("Plans"):
			
			Plan plan = new Plan();
			plan.name = name;
			definitions.plans.add(plan);
			setChoiceBoxList("Plans");
			break;
			
		case ("Deliverables"):
			
			Deliverable deliverable = new Deliverable();
			deliverable.name = name;
			definitions.deliverables.add(deliverable);
			setChoiceBoxList("Deliverables");
			break;
			
		case ("Interruptions"):
			
			Interruption interruption = new Interruption();
			interruption.name = name;
			definitions.interruptions.add(interruption);
			setChoiceBoxList("Interruptions");
			break;
			
		case ("Defect Categories"):
			
			DefectCategory defectCategory = new DefectCategory();
			defectCategory.name = name;
			definitions.defectCategories.add(defectCategory);
			setChoiceBoxList("Defect Categories");
			break;
			
		}
		
	}
	
	public void deleteListItem(MouseEvent e)
	{
		String name = choiceBoxList.getValue();
		textField.clear();
		
		if (name.length() == 0) return;
		
		switch(choiceBoxSection.getValue())
		{
		
		case ("Projects"):
			
			for (Project project : definitions.projects)
			{
				if (project.name == name)
				{
					definitions.projects.remove(project);
					break;
				}
			}
			setChoiceBoxList("Projects");
			break;
			
		case ("Life Cycle Steps"):
			
			for (LifeCycleStep lcs : definitions.lifeCycleSteps)
			{
				if (lcs.name == name)
				{
					definitions.lifeCycleSteps.remove(lcs);
					break;
				}
			}
			setChoiceBoxList("Life Cycle Steps");
			break;
			
		case ("Effort Categories"):
			
			for (EffortCategory ec : definitions.effortCategories)
			{
				if (ec.name == name)
				{
					definitions.effortCategories.remove(ec);
					break;
				}
			}
			setChoiceBoxList("Effort Categories");
			break;
			
		case ("Plans"):
			
			for (Plan plan : definitions.plans)
			{
				if (plan.name == name)
				{
					definitions.plans.remove(plan);
					break;
				}
			}
			setChoiceBoxList("Plans");	
			break;
			
		case ("Deliverables"):
			
			for (Deliverable deliverable : definitions.deliverables)
			{
				if (deliverable.name == name)
				{
					definitions.deliverables.remove(deliverable);
					break;
				}
			}
			setChoiceBoxList("Deliverables");
			break;
			
		case ("Interruptions"):
			
			for (Interruption interruption : definitions.interruptions)
			{
				if (interruption.name == name)
				{
					definitions.interruptions.remove(interruption);
					break;
				}
			}
			setChoiceBoxList("Interruptions");
			break;
			
		case ("Defect Categories"):
			
			for (DefectCategory dc : definitions.defectCategories)
			{
				if (dc.name == name)
				{
					definitions.defectCategories.remove(dc);
					break;
				}
			}
			setChoiceBoxList("Defect Categories");
			break;
			
		}
	}

	public void addLCStoProject()
	{
		if (choiceBoxSection.getValue() != "Projects") return;
		if (choiceBoxList.getValue() == null) return;
		if (choiceBox2.getValue() == null) return;
		
		//get the current project
		
		Project project = getProjectFromChoiceBox(choiceBoxList);
		
		//get the to-be-added life cycle step
		project.lifeCycleSteps.add(getLifeCycleStepFromChoiceBox(choiceBox2));
		
		
		setChoiceBox2LCS();
		setProjectLifeCycleSteps();
	}
	
	public void deleteLCSfromProject()
	{
		if (choiceBoxSection.getValue() != "Projects") return;
		if (choiceBoxList.getValue() == null) return;
		if (choiceBox1.getValue() == null) return;
		
		//get the current project
		
		Project project = getProjectFromChoiceBox(choiceBoxList);
		
		//get the to-be-deleted life cycle step
		project.lifeCycleSteps.remove(getLifeCycleStepFromChoiceBox(choiceBox1));
		setProjectLifeCycleSteps();
		setChoiceBox2LCS();
	}
	
	public void changeDefaultEffortCategory()
	{
		if (choiceBoxSection.getValue() != "Life Cycle Steps") return;
		if (choiceBoxList.getValue() == null) return;
		if (choiceBox1.getValue() == null) return;
		
		//get the life cycle step
		LifeCycleStep lifeCycleStep = getLifeCycleStepFromChoiceBox(choiceBoxList);
		
		//find the effort category and assign it to the LCS's default
		lifeCycleStep.defaultEffortCategory = getEffortCategoryFromChoiceBox(choiceBox1);
		
	}

	public void changeDefaultDeliverable()
	{
		if (choiceBoxSection.getValue() != "Life Cycle Steps") return;
		if (choiceBoxList.getValue() == null) return;
		if (choiceBox2.getValue() == null) return;
		
		//get the life cycle step
		LifeCycleStep lifeCycleStep = getLifeCycleStepFromChoiceBox(choiceBoxList);
		
		//find the deliverable and assign it to the LCS's default
		lifeCycleStep.defaultDeliverable = getDeliverableFromChoiceBox(choiceBox2);
		
	}
	
	public void setChoiceBox2LCS()
	{
		if (choiceBoxSection.getValue() != "Projects") return;
		if (choiceBoxList.getValue() == null) return;
		
		//get project
		Project project = getProjectFromChoiceBox(choiceBoxList);
		
		List<String> lifeCycleSteps = new ArrayList<>(); //the life cycle steps not mapped to the project
		for (LifeCycleStep lcs : definitions.lifeCycleSteps)
		{
			if(!project.lifeCycleSteps.contains(lcs))
			{
				lifeCycleSteps.add(lcs.name);
			}
		}
		
		choiceBox2.setItems(FXCollections.observableArrayList(lifeCycleSteps));
	}
	
	@Override	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//darken the Definitions Button
		menuBarController.manageButtons("Definitions");
		
		//add the sections to the first ChocieBox
		choiceBoxSection.getItems().addAll(sections);
		
		choiceBoxSection.setOnAction(e -> {

			String section = choiceBoxSection.getValue();
			setChoiceBoxList(section);
		});
		
		choiceBoxList.setOnAction(e -> {
			
			if (choiceBoxSection.getValue() == "Projects")
			{
				setProjectLifeCycleSteps();
				setChoiceBox2LCS();
			} else if (choiceBoxSection.getValue() == "Life Cycle Steps")
			{
				setDefaultEffortCategories();
				setDefaultDeliverables();
			} else
			{
				choiceBox1.getSelectionModel().clearSelection();
				choiceBox2.getSelectionModel().clearSelection();
			}
		});
		
		choiceBox1.setOnAction(e -> {

			changeDefaultEffortCategory();
		});
		
		choiceBox2.setOnAction(e -> {

			changeDefaultDeliverable();
		});
	}
}
