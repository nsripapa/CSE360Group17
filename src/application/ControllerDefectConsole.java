//The DefectConsole intends to capture the information about the defects found in the projects and do so in a very straightforward manner. 

package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;

public class ControllerDefectConsole extends Controller implements Initializable {
    @FXML
    private ControllerMenuBar menuBarController;
    @FXML
    private Label selectProjectLabel, defectAttributesLabel;
    @FXML
    private Button clearLogButton, createDefectButton,
    closeButton, openButton, updateButton, deleteButton;
    @FXML
    private ChoiceBox<String> projectChoiceBox, defectChoiceBox,
    defectCatChoiceBox, stepWhenInjectedChoiceBox, stepWhenRemovedChoiceBox,
    fixDefectChoiceBox;
    @FXML
    private TextField defectNameTextField; 
    @FXML
    private Text statusText;
    @FXML
    private TextArea defectSymptoms;

    private List<String> projectList = definitions.getProjectNames();
    
    
    public void getDefectsList() {
    	if (projectChoiceBox.getValue() == null) return;
    	
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	List<String> defects = new ArrayList<>();
    	
    	for(int i = 0; i < project.getLogs().getDefectLogs().size(); i ++) {
    		DefectLog dl = getDefectLog(project, i); 
    		
    		defects.add(dl.name);
    	}
    	
    	defectChoiceBox.setItems(FXCollections.observableArrayList(defects));
    }
    public void getStepsList() {
    	if (projectChoiceBox.getValue() == null) return;
    	
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	
    	List<String> lifeCycleSteps = new ArrayList<>();
    	for(LifeCycleStep lcs : definitions.lifeCycleSteps) {
    		if(!project.lifeCycleSteps.contains(lcs)) {
    			lifeCycleSteps.add(lcs.name);
    		}
    	}
    	
    	stepWhenInjectedChoiceBox.setItems(FXCollections.observableArrayList(lifeCycleSteps));
    	stepWhenRemovedChoiceBox.setItems(FXCollections.observableArrayList(lifeCycleSteps));
    }
    public void addDefLog() {
    	DefectLog defectLog = new DefectLog();
    	defectLog.name = defectNameTextField.getText();
    	defectLog.injected = stepWhenInjectedChoiceBox.getValue();
    	defectLog.removed = stepWhenRemovedChoiceBox.getValue();
    	defectLog.category = defectCatChoiceBox.getValue();
    	defectLog.detail = defectSymptoms.getText();
    	if(statusText.getText() == "Open") defectLog.status = "Open";
    	else if(statusText.getText() == "Closed") defectLog.status = "Closed";
    	
    	int index = 0;
    	for(int i = 0; i < projectList.size(); i++) {
    		if(projectChoiceBox.getValue() == projectList.get(i)) {
    			index = i;
    		}
    	}
    	
    	Project project = definitions.projects.get(index);
    	project.getLogs().getDefectLogs().add(defectLog);
    }
    public void deleteDefect(int i) {
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	project.getLogs().getDefectLogs().remove(i);
    	defectAttributesLabel.setText("Defect removed from database.");
    }
    public int getCurrentDefectIndex() { // utlity method to get current index of defect within a project's defect log list
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	
    	int index = 0;
    	for(int i = 0; i < project.getLogs().getDefectLogs().size(); i++) {
    		if(project.getLogs().getDefectLogs().get(i).name == defectNameTextField.getText()) {
    			index = i;
    		}
    	}
    	return index;
    }
    public void updateDefect() {
    	deleteDefect(getCurrentDefectIndex());
    	addDefLog();
    	defectAttributesLabel.setText("Attributes have been saved.");
    }   
    public void createDefect() {
    	defectNameTextField.setText("New Defect");
    	defectSymptoms.setText("Defect Symptoms: ");
    	statusText.setText("Open");
    	defectAttributesLabel.setText("Attributes not saved yet.");
    	addDefLog();
    }
    public void closeStatus() {
    	statusText.setText("Closed");
    	defectAttributesLabel.setText("Attributes not saved yet.");
    }
    public void openStatus() { 
    	statusText.setText("Open");
    	defectAttributesLabel.setText("Attributes not saved yet.");
    }
    public void clearFields() { 
    	defectNameTextField.setText("");
    	defectSymptoms.setText("");
    }
    public void updateFields() { // updates all relevant fields with info from selected defect in dropdown box
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	DefectLog dl = project.getLogs().getDefectLogs().get(getCurrentDefectIndex());
    	defectNameTextField.setText(dl.name);
    	defectSymptoms.setText(dl.detail);
    	stepWhenInjectedChoiceBox.getSelectionModel().select(dl.injected);
    	stepWhenRemovedChoiceBox.getSelectionModel().select(dl.removed);
    	defectCatChoiceBox.getSelectionModel().select(dl.category);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuBarController.manageButtons("DefectConsole");
        
        projectChoiceBox.getItems().addAll(definitions.getProjectNames());
        defectCatChoiceBox.getItems().addAll(definitions.getDefectCategoryNames());
        
        statusText.setText("Closed");
        
        projectChoiceBox.setOnAction(e -> {
        	getDefectsList();
        	getStepsList();
        });
        defectChoiceBox.setOnAction(e-> {
        	updateFields();
        });
        createDefectButton.setOnAction(e-> {
        	createDefect();
        	getDefectsList();
        });
        updateButton.setOnAction(e-> {
        	updateDefect();
        	getDefectsList();
        });
        deleteButton.setOnAction(e-> {
        	deleteDefect(getCurrentDefectIndex());
        	getDefectsList();
        	clearFields();
        });
        closeButton.setOnAction(e-> {
        	closeStatus();
        });
        openButton.setOnAction(e-> {
        	openStatus();
        });
        
    }
}
