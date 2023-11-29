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
    private TextArea defectSymptoms;

	private List<String> defectList = null;
    private List<String> projectList = definitions.getProjectNames();
    
    
    public void getDefectsList() {
    	if (projectChoiceBox.getValue() == null) return;
    	Project project = getProjectFromChoiceBox(projectChoiceBox);
    	List<DefectLog> defLogs = project.getLogs().getDefectLogs();
    	
    	for(int i = 0; i < defLogs.size(); i ++) {
    		defectList.add(defLogs.get(i).name);
    		System.out.println(defLogs.get(i).name);
    	}
    	
    	if (defectList == null) return;
    	
    	defectChoiceBox.setItems(FXCollections.observableArrayList(defectList));
    	
    	
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
    
    public void getDefectCategoryList() {
    	defectCatChoiceBox.setItems(FXCollections.observableArrayList(definitions.getDefectCategoryNames()));
    }
    
    public void addDefLog() {
    	DefectLog defectLog = new DefectLog();
    	defectLog.name = defectNameTextField.getText();
    	defectLog.injected = stepWhenInjectedChoiceBox.getValue();
    	defectLog.removed = stepWhenRemovedChoiceBox.getValue();
    	defectLog.fix = fixDefectChoiceBox.getValue();
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
    	Project project = definitions.projects.get(i);
    	project.getLogs().getDefectLogs().remove(i);
    	System.out.println("Defect Deleted");
    }
    
    public void fixDefect(int i) {
    	
    }

    public void createDefect() {
    	addDefLog();
    	System.out.println("Defect Created");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuBarController.manageButtons("DefectConsole");
        
        
        projectChoiceBox.getItems().addAll(definitions.getProjectNames());
        
        projectChoiceBox.setOnAction(e -> {
        	getDefectsList();
        	getStepsList();
        	// getDefectCategoryList();
        });
        createDefectButton.setOnAction(e-> {
        	createDefect();
        });
        
        
    }
}
