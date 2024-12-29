package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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

    private NewLayout newLayout;


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
            UniDetails.setText(details.toString());
        } else {
            System.out.println("UniDetails or University is null");
        }
    }
    // Set NewLayout for accessing current stage
    public void setNewLayout(NewLayout controller) {
        this.newLayout = controller;
    }

    @FXML
    private void handleAddWishButtonClick(ActionEvent event) {
        try {
            URL fxmlFile = getClass().getResource("NewLayout.fxml");
            if (fxmlFile == null) {
                System.out.println("FXML file not found!");
            } else {
                System.out.println("FXML file found at: " + fxmlFile);
            }
            // Load the Newlayout scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Users/mdsaibhossain/code/java/practice1/target/classes/org/example/demo1/NewLayout.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("New Layout");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load NewLayout.fxml");
        }
    }


    @FXML
    void goCareerPage(ActionEvent event) {
        try {
            System.out.println("in CareerPage");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("career.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            if (stage == null) {
                System.out.println("Stage is null in CareerPage");
                return;
            }
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Transitioned back to career.fxml");
        } catch (IOException e) {
            System.out.println("Error loading career.fxml in goBack.");
            e.printStackTrace();
        }
    }

    @FXML
    void goProfilePage(ActionEvent event) {
        try {
            System.out.println("in profilePage");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            if (stage == null) {
                System.out.println("Stage is null in profile.fxml");
                return;
            }
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Transitioned back to profile page");
        } catch (IOException e) {
            System.out.println("Error loading profile.fxml in goBack.");
            e.printStackTrace();
        }
    }

    @FXML
    void goSearchPage(ActionEvent event) {
        try {
            System.out.println("in searchPage");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            if (stage == null) {
                System.out.println("Stage is null in search.fxml");
                return;
            }
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Transitioned back to Search");
        } catch (IOException e) {
            System.out.println("Error loading search.fxml in goBack.");
            e.printStackTrace();
        }
    }
    @FXML
    void goExplorePage(ActionEvent event) {
        try {
            System.out.println("in NewLayout.fxml--Explore ");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewLayout.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            if (stage == null) {
                System.out.println("Stage is null in NewLayout.fxml--Explore");
                return;
            }
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Transitioned back to NewLayout.fxml");
        } catch (IOException e) {
            System.out.println("Error loading NewLayout.fxml in goBack.");
            e.printStackTrace();
        }

    }

}
