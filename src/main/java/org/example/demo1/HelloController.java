package org.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HelloController {
    @FXML
    private Button Button,Button1;

    @FXML
    private Button PrivateUni1,PrivateUni2,PrivateUni3;

    @FXML
    private ColumnConstraints RankedSeeMore;

    @FXML
    private Button publicUni1;

    @FXML
    private Text seeMoreTopUni ,seeMorePrivate,seeMorePUblic;
    @FXML
    private VBox layoutVBox;

    @FXML
    private HBox topBox;
    private Stage currentStage;



    @FXML
    void ButtonPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        String text = button.getText();
        System.out.println(text);
    }
    @FXML
    void PrivateUniPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        String text = button.getText();
        System.out.println(text);

    }
    @FXML
    void publicUniPress(ActionEvent event) {
        Button button = (Button) event.getSource(); // Cast the source to a Button
        String text = button.getText();             // Get the text of the button
        System.out.println(text);
    }

    @FXML
    void seeMoreTopUni(MouseEvent event) {
        try {
            System.out.println("seeMoreTopUni called.");

            // Load NewLayout.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewLayout.fxml"));
            Parent root = loader.load();

            // Get the controller for NewLayout.fxml
            NewLayout newLayoutController = loader.getController();
            System.out.println("NewLayoutController initialized.");

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (stage == null) {
                System.out.println("Stage is null in seeMoreTopUni.");
                return;
            }

            // Set the new scene
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Transitioned to NewLayout.fxml.");
        } catch (IOException e) {
            System.out.println("Error loading NewLayout.fxml in seeMoreTopUni.");
            e.printStackTrace();
        }


    }
    @FXML
    void seeMorePrivate(MouseEvent event) {
        System.out.println("list all university from Private");

    }
    @FXML
    void seeMorePUblic(MouseEvent event) {
        System.out.println("list all university from Public");

    }


    public void initialize() throws IOException{
        // Check if layoutVBox is null
        if (layoutVBox == null) {
            System.out.println("layoutVBox is null in initialize()");
            return; // Exit to avoid further null pointer exceptions
        }

        // Check if layoutVBox is part of a Scene
        if (layoutVBox.getScene() == null) {
            System.out.println("Scene for layoutVBox is null in initialize()");
        }

        // Add a listener to detect when the VBox is added to a Scene
        layoutVBox.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                Stage stage = (Stage) newScene.getWindow();
                currentStage = stage;
                System.out.println("Stage successfully initialized in initialize()");
            }
        });

        // Ensure delayed execution after UI is loaded
        Platform.runLater(() -> {
            if (layoutVBox.getScene() != null) {
                Stage stage = (Stage) layoutVBox.getScene().getWindow();
                currentStage = stage;
                System.out.println("Stage retrieved successfully in Platform.runLater");
            }
        });

        // Check if the HBox is properly injected
        if (topBox == null) {
            throw new IllegalStateException("topBox is null. Ensure fx:id in FXML matches the variable name in the controller.");
        }

        // Fetch the list of universities
        List<univercityDetails.University> universities = univercityDetails.getUniversities();

        // Sort universities by rank
        Collections.sort(universities, Comparator.comparingInt(univercityDetails.University::getRank));

        // Add buttons for each university to the HBox
        for (univercityDetails.University uni : universities) {
            Button button = createUniversityButton(uni);
            topBox.getChildren().add(button);
        }
    }

    // Method to create a button for each university
    private Button createUniversityButton(univercityDetails.University uni) throws IOException {
        Button button = new Button(uni.getName());
        button.setPrefWidth(132.0);
        button.setPrefHeight(115.0);
        button.setStyle("-fx-font-size: 8; -fx-font-weight: bold; -fx-text-fill: white; " +
                "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); -fx-padding: 10;");
        button.setOnAction(event -> {
            System.out.println("Selected: " + uni.getName());
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("uniDetails.fxml"));
            Parent root = loader.load();
            UniDetails uniDetailsController = loader.getController();       // Get the controller of uniDetails.fxml

            //uniDetailsController.setHelloController(this);      // Pass the HelloController to UniDetails controller
            uniDetailsController.displayUniversityDetails(uni);// Call a method from UniDetails

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                if (stage == null) {
                    System.out.println("Stage is null in createUniversityButton.");
                } else {
                    System.out.println("Stage retrieved successfully in createUniversityButton: " + stage);
                }
            stage.setScene(new Scene(root));
            stage.show();
            } catch (IOException e) {
                e.printStackTrace();  // Handle the error if the FXML file cannot be loaded
            }
        });
        return button;

    }

    // Getter for current stage, so it can be used in UniDetails.java
    public Stage getCurrentStage() {
        if (currentStage == null && layoutVBox != null && layoutVBox.getScene() != null) {
            currentStage = (Stage) layoutVBox.getScene().getWindow();
        }
        return currentStage;
    }

}
