//The DefectConsole intends to capture the information about the defects found in the projects and do so in a very straightforward manner. 

package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.scene.control.Alert;

public class ControllerDefectConsole extends Controller implements Initializable {
    @FXML
    private ControllerMenuBar menuBarController;

    @FXML
    private Label selectProjectLabel;

    @FXML
    private ChoiceBox<String> projectSelectionChoiceBox, defectStatusChoiceBox;

    @FXML
    private Label defectAttributesLabel; 

    @FXML
    private TextField defectNameTextField; 
    
    @FXML
    private Button saveDefectButton;
    
    @FXML
    private Button createDefect;

    @FXML
    private TextField defectDescriptionTextField; 
    @FXML
    private Button deleteDefectButton;

    @FXML
    private Button close;  
    
    @FXML
    private Button reopen;   
    
    
    @FXML
    private Button update; 
    
    @FXML
    private Button Fix;
    
    @FXML
    private Button ProceedToEffortConsole;
    
    @FXML
    private ChoiceBox<String> stepWhenInjected;
    
    @FXML
    private ChoiceBox<String> stepWhenRemoved;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuBarController.manageButtons("DefectConsole");
        initializeProjectSelectionChoiceBox();
        saveDefectButton.setOnAction(event -> updateDefect());
        stepWhenInjected.getItems().addAll(
                "Problem Understanding",
                "Conceptual Design Plan",
                "Requirements",
                "Conceptual Design",
                "Conceptual Design Review",
                "Solution Review"
        );  
        
        stepWhenRemoved.getItems().addAll(
                "Problem Understanding",
                "Conceptual Design Plan",
                "Requirements",
                "Conceptual Design",
                "Conceptual Design Review",
                "Solution Review"
        );  
    
        
    }

    private void initializeProjectSelectionChoiceBox() {
  
        projectSelectionChoiceBox.getItems().addAll("Business Project", "Development Project");

     
        projectSelectionChoiceBox.setOnAction(event -> selectProject());
    }

    private void selectProject() {
        String selectedProject = projectSelectionChoiceBox.getValue();
        if (selectedProject != null) {
            
            System.out.println("Selected Project: " + selectedProject);
        } else {
            System.out.println("No project selected.");
        }
    }
    
    @FXML
    private void createNewDefect() {   
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create New Defect");
        dialog.setHeaderText("Create a New Defect");
        dialog.setContentText("Please enter the name of the new defect:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(defectName -> {
            if (!defectName.trim().isEmpty()) {
              
                System.out.println("New defect created: " + defectName);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Defect Name");
                alert.setContentText("The name of the defect cannot be empty.");
                alert.showAndWait();
            }
        });
    }


    
	
    
    private void updateDefect() {
        String projectName = projectSelectionChoiceBox.getValue();
        String defectName = defectNameTextField.getText();
        String defectDescription = defectDescriptionTextField.getText();
        System.out.println("Saved defect in project: " + projectName + " with name: " + defectName + ", Description: " + defectDescription);
    }
}
