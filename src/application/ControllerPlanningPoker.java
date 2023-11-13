// Author: Augustine Suter
package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerPlanningPoker extends Controller implements Initializable {

    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private ChoiceBox<String> lifeCycleStepChoiceBox;
    @FXML
    private ChoiceBox<String> effortCategoryChoiceBox;
    @FXML
    private ChoiceBox<String> specificEffortCategoryChoiceBox;
    @FXML
    private ChoiceBox<Integer> userEstimationChoiceBox;
    @FXML
    private Label yourEstimateLabel, lowestEstimateLabel, highestEstimateLabel, meanEstimateLabel, discussLabel;
    @FXML
    private Button submitButton, estimateAgainButton;

    private Definitions definitions = Definitions.getInstance();
    private List<String> projectList = definitions.getProjectNames();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        projectChoiceBox.setItems(FXCollections.observableArrayList(projectList));

        projectChoiceBox.setOnAction(e -> {
            loadLifeCycleSteps();
        });

        lifeCycleStepChoiceBox.setOnAction(e -> {
            loadEffortCategories();
        });

        effortCategoryChoiceBox.setOnAction(e -> {
            loadSpecificEffortCategories();
        });

        submitButton.setOnAction(e -> {
            submitEstimation();
        });

        estimateAgainButton.setOnAction(e -> {
            clearFields();
        });
        // Populate the userEstimationChoiceBox with values from 1 through 10
        userEstimationChoiceBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
    }
    
    
    
    
    
    
// Load all relevant data to the choice boxes for planning poker
    
    private void loadLifeCycleSteps() {
        String selectedProject = projectChoiceBox.getValue();
        Project project = getProjectFromChoiceBox(selectedProject);
        List<String> lifeCycleSteps = new ArrayList<>();

        for (LifeCycleStep lcs : definitions.lifeCycleSteps) {
            if (!project.lifeCycleSteps.contains(lcs)) {
                lifeCycleSteps.add(lcs.name);
            }
        }

        lifeCycleStepChoiceBox.setItems(FXCollections.observableArrayList(lifeCycleSteps));
    }

    private void loadEffortCategories() {
        String selectedLifeCycleStep = lifeCycleStepChoiceBox.getValue();
        LifeCycleStep lifeCycleStep = getLifeCycleStepFromChoiceBox(selectedLifeCycleStep);
        List<String> effortCategories = new ArrayList<>();

        for (EffortCategory ec : definitions.effortCategories) {
            if (isEffortCategoryAssociatedWithLifeCycleStep(ec, lifeCycleStep)) {
                effortCategories.add(ec.name);
            }
        }

        effortCategoryChoiceBox.setItems(FXCollections.observableArrayList(effortCategories));
    }

    private void loadSpecificEffortCategories() {
        String selectedEffortCategory = effortCategoryChoiceBox.getValue();
        EffortCategory effortCategory = getEffortCategoryFromChoiceBox(selectedEffortCategory);
        List<String> specificEffortCategories = new ArrayList<>();

        for (Plan plan : definitions.plans) {
            if (isPlanAssociatedWithEffortCategory(plan, effortCategory)) {
                specificEffortCategories.add(plan.name);
            }
        }

        specificEffortCategoryChoiceBox.setItems(FXCollections.observableArrayList(specificEffortCategories));
    }
    
    
    
    
    
    
    
    
// ESTIMATION LOGIC
    
    private Integer getUserEstimation() {
        return userEstimationChoiceBox.getValue();
    }


    private void displayEstimationDetails(Integer userEstimation) {
    	
        // Simulate estimations from four other team members
        List<Integer> otherEstimations = simulateOtherEstimations();
        
        // Calculate lowest, highest, and mean estimations
        int lowestEstimation = calculateLowestEstimation(userEstimation, otherEstimations);
        int highestEstimation = calculateHighestEstimation(userEstimation, otherEstimations);
        double meanEstimation = calculateMeanEstimation(userEstimation, otherEstimations);
        // Display the estimation details
        yourEstimateLabel.setText("Your estimate: " + userEstimation);
        lowestEstimateLabel.setText("Lowest estimate: " + lowestEstimation);
        highestEstimateLabel.setText("Highest estimate: " + highestEstimation);
        meanEstimateLabel.setText("Mean estimate: " + meanEstimation);
        discussLabel.setText("Discuss your Estimates with your team!");
    }


    // we will simulate other users for now
    private List<Integer> simulateOtherEstimations() {
        List<Integer> otherEstimations = new ArrayList<>();
        Random random = new Random();

        // Simulate estimations from four other team members
        for (int i = 0; i < 4; i++) {
            int randomEstimation = random.nextInt(10) + 1;
            otherEstimations.add(randomEstimation);
        }

        return otherEstimations;
    }

    private int calculateLowestEstimation(int userEstimate, List<Integer> otherEstimations) {
        int lowestEstimate = userEstimate;
        for (int estimation : otherEstimations) {
            if (estimation < lowestEstimate) {
                lowestEstimate = estimation;
            }
        }
        return lowestEstimate;
    }

    private int calculateHighestEstimation(int userEstimate, List<Integer> otherEstimations) {
        int highestEstimate = userEstimate;
        for (int estimation : otherEstimations) {
            if (estimation > highestEstimate) {
                highestEstimate = estimation;
            }
        }
        return highestEstimate;
    }

    private double calculateMeanEstimation(int userEstimate, List<Integer> otherEstimations) {
        double sum = userEstimate;
        for (int estimation : otherEstimations) {
            sum += estimation;
        }
        return sum / (otherEstimations.size() + 1);
    }

    
    
    // Check if all fields are filled out (to be implemented)
    private boolean validateFields() {
        return true; 
    }

    
    // Called when submit button is hit
    private void submitEstimation() {
    	int userEstimation = getUserEstimation();
        displayEstimationDetails(userEstimation);

    }
    

    
    
    // Clear all fields when Estimate Again button is hit.
    private void clearFields() {
        yourEstimateLabel.setText("");
        lowestEstimateLabel.setText("");
        highestEstimateLabel.setText("");
        meanEstimateLabel.setText("");
        discussLabel.setText("");

        // Clear the selections in ChoiceBoxes
        userEstimationChoiceBox.setValue(null);
        specificEffortCategoryChoiceBox.setValue(null);
        effortCategoryChoiceBox.setValue(null);
        lifeCycleStepChoiceBox.setValue(null);
        projectChoiceBox.setValue(null);
    }

    
    
    
    

    // Helper methods to get objects from Definitions based on their names
    private Project getProjectFromChoiceBox(String projectName) {
        return definitions.projects.stream().filter(p -> p.name.equals(projectName)).findFirst().orElse(null);
    }

    private LifeCycleStep getLifeCycleStepFromChoiceBox(String lifeCycleStepName) {
        return definitions.lifeCycleSteps.stream().filter(lcs -> lcs.name.equals(lifeCycleStepName)).findFirst().orElse(null);
    }

    private EffortCategory getEffortCategoryFromChoiceBox(String effortCategoryName) {
        return definitions.effortCategories.stream().filter(ec -> ec.name.equals(effortCategoryName)).findFirst().orElse(null);
    }

    private boolean isEffortCategoryAssociatedWithLifeCycleStep(EffortCategory effortCategory, LifeCycleStep lifeCycleStep) {
        return lifeCycleStep != null; 
    }

    private boolean isPlanAssociatedWithEffortCategory(Plan plan, EffortCategory effortCategory) {
        return effortCategory != null; 
    }
}
