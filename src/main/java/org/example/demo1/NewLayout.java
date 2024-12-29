package org.example.demo1;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx. scene. image. Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;


import java.awt.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class NewLayout {
    @FXML
    private Button printB,Displayinfo;
    @FXML
    private Label seeMoreTopView;
    @FXML
    private ImageView image;
    @FXML
    private HBox topBox;
    @FXML
    private VBox layoutVBox;
    private Stage currentStage;



    @FXML
    public void initialize() {
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

        // Fetch the list of universities
        List<univercityDetails.University> universities = univercityDetails.getUniversities();
        // Sort universities by rank
        Collections.sort(universities, Comparator.comparingInt(univercityDetails.University::getRank));

        // Add buttons for each university to the HBox
        for (univercityDetails.University university : universities) {
            Button button = createUniversityButton(university);
            topBox.getChildren().add(button);
        }
    }

    public void goBack(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        System.out.println("Error loading layout.fxml in goBack.");
        e.printStackTrace();    }
    }
    @FXML
    void seeMore(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("seemore.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading seemore.fxml in goBack.");
            e.printStackTrace();
        }


    }

    @FXML
    public void goCareerPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("career.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading career.fxml in goBack.");
            e.printStackTrace();
        }
    }
    @FXML
    public void goSearchPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading search.fxml in goBack.");
            e.printStackTrace();}
    }
    @FXML
    public void goProfilePage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading profile.fxml in goBack.");
            e.printStackTrace();}
    }


    public void printhello(ActionEvent event) {
        System.out.println("hello button press");
        image.setDisable(true);
    }
    public void imgDisableTrue(ActionEvent event) {

        image.setVisible(true);
        System.out.println("image.setDisable(true);");
    }
    public void imgDisableFalse(ActionEvent event) {
        image.setVisible(false);
        System.out.println("image.setDisable(false);");
    }

    public void uni_details(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("uniDetails.fxml"));
            Parent root = loader.load();
            UniDetails uniDetailsController = loader.getController();       // Get the controller of uniDetails.fxml

            uniDetailsController.setNewLayout(this);      // Pass the HelloController to UniDetails controller
            univercityDetails.University uni = null;
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
    }

    private Button createUniversityButton(univercityDetails.University university) {
        // Main button
        Button mainButton = new Button();
        mainButton.setPrefSize(221, 286);
        mainButton.setStyle("-fx-font-size: 8; -fx-text-fill: white; " +
                "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc); -fx-padding: 10;");

        // Create VBox for button content
        VBox vbox = new VBox(5);
        vbox.setStyle("-fx-alignment: center;");
        vbox.setSpacing(3);

        // University Name
        Button nameButton = new Button(university.getName());
        nameButton.setPrefSize(203, 23);
        nameButton.setStyle("-fx-font-size: 14; ");
        nameButton.setOnAction(event -> showUniversityDetails(university));

        // University Image (Placeholder)
        ImageView imageView = new ImageView(new Image("Brac.jpg")); // Replace with actual URL or file path
        imageView.setFitWidth(211);
        imageView.setFitHeight(159);
        imageView.setPreserveRatio(true);

        // Rank Button
        Button rankButton = new Button("RANK : " + university.getRank());
        rankButton.setPrefSize(257, 25);
        rankButton.setStyle("-fx-font-size: 14;");

        // Details Button
        Button detailsButton = new Button(university.getKeyHighlights());
        detailsButton.setPrefSize(257, 25);
        //detailsButton.setWrapText(true);
        detailsButton.setStyle("-fx-font-size: 10; -fx-text-alignment: center;");

        // HBox for action buttons
        HBox hbox = new HBox(4);
        hbox.setPrefSize(214, 16);
        hbox.setSpacing(4);

        // Action buttons with icons
        Button bellButton = createIconButton("bell.png", 24, 27, this::goBack);
        Button callButton = createIconButton("call.png", 48, 31, this::goBack);
        Button calendarButton = createIconButton("calender.png", 48, 31, this::imgDisableFalse);
        Button messageButton = createIconButton("message.jpg", 48, 31, this::imgDisableTrue);


        hbox.getChildren().addAll(bellButton, callButton, calendarButton, messageButton);   // Add action buttons to HBox
        vbox.getChildren().addAll(nameButton, imageView, rankButton, detailsButton,hbox);  // Add components to VBox
        mainButton.setGraphic(vbox);

        // Set VBox as the graphic of the main button
        mainButton.setOnAction(event -> {
            System.out.println("Selected: " + university.getName());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("uniDetails.fxml"));
                Parent root = loader.load();
                UniDetails uniDetailsController = loader.getController();       // Get the controller of uniDetails.fxml

                uniDetailsController.setNewLayout(this);      // Pass the HelloController to UniDetails controller
                uniDetailsController.displayUniversityDetails(university);// Call a method from UniDetails

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
        return mainButton;
    }
    private void showUniversityDetails(univercityDetails.University university) {
        System.out.println("University Name: " + university.getName());
        System.out.println("Location: " + university.getLocation());
        System.out.println("Established: " + university.getEstablished());
        System.out.println("Programs: " + university.getPrograms());
        System.out.println("Key Highlights: " + university.getKeyHighlights());
        System.out.println("Website: " + university.getWebsite());
        System.out.println("Total Seats: " + university.getTotalSeats());
    }
    private Button createIconButton(String imagePath, double width, double height, EventHandler<ActionEvent> action) {
        Button button = new Button();
        button.setPrefSize(width, height);
        button.setStyle("-fx-background-color: transparent;");
        ImageView icon = new ImageView(new Image(imagePath));
        icon.setFitWidth(47);
        icon.setFitHeight(31);
        icon.setPreserveRatio(true);
        button.setGraphic(icon);
        button.setOnAction(action);
        button.setPrefHeight(31.0);
        button.setPrefWidth(48.0);
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
