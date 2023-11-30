



package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestCaseSimulator extends Application {

   
    private TextArea textArea = new TextArea();
    private EffortLoggerSimulator simulator = new EffortLoggerSimulator(); 

    public static void main(String[] args) {
         launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Automated Test Case Simulator");

       VBox layout = new VBox(10);

       Button runTestsBtn = new Button("Run Test Cases");
        runTestsBtn.setOnAction(e -> runTestCases());

        layout.getChildren().addAll(runTestsBtn, textArea);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runTestCases() {
        String results = simulator.runTestCases();
        textArea.appendText(results);
    }
}
