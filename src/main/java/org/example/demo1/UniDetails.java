package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UniDetails {

    @FXML
    private TextArea UniDetails;
    @FXML
    private Button Apply,homePage,wish;

    @FXML
    private TitledPane titledPane;

    @FXML
    private Label universityNameLabel;

    @FXML
    private Label universityRankLabel;

    @FXML
    private Label universityLocationLabel;
    private HelloController helloController;


    public void displayUniversityDetails(univercityDetails.University university) {
        UniDetails.clear();
        if (UniDetails != null && university != null) {
            // Clear the existing content in the TextArea
            UniDetails.clear();

            // Build the details string
            StringBuilder details = new StringBuilder();
            details.append("University Name: ").append(university.getName()).append("\n")
                    .append("Rank: ").append(university.getRank()).append("\n")
                    .append("Location: ").append(university.getLocation()).append("\n")
                    .append("programs: ").append(university.getPrograms()).append("\n")
                    .append("Details: ").append(university.getKeyHighlights()).append("\n")
                    .append("website: ").append(university.getWebsite()).append("\n")
                    .append("Established: ").append(university.getEstablished()).append("\n");

            // Set the text to the TextArea
            UniDetails.setText(details.toString());
        } else {
            System.out.println("UniDetails or University is null");
        }
    
    }


    // Method to handle going back to the layout scene
    public void goBackToLayout(ActionEvent event) throws Exception{
        try {
            if (helloController == null) {
                System.err.println("HelloController is not set. Cannot retrieve the stage.");
                return;
            }
            // Get the original stage from the HelloController
            Stage stage = helloController.getCurrentStage();
            if (stage == null) {
                System.err.println("Stage is null. Ensure HelloController is properly initialized.");
                return;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Set HelloController for accessing current stage
    public void setHelloController(HelloController controller) {
        this.helloController = controller;
    }

}
