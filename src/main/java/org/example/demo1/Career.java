package org.example.demo1;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Career {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;
    @FXML
    private Label guide,me,me1,me2,Whatjob,Whatjob1;
    @FXML
    private Button trans1,trans2,trans3,trans11,trans21,trans31;

    @FXML
    void initialize() {
        // Start dynamic gradient update
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            double currentTime = System.currentTimeMillis() % 10000 / 10000.0; // Normalize time to [0, 1]
            updateLabelGradient(currentTime);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        vbox.setStyle("-fx-background-color: black;");
        //Whatjob.setStyle("-fx-background-color: white;");
        Whatjob.setTextFill(Color.WHITE);
        Whatjob1.setTextFill(Color.WHITE);
        //trans.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");

        // Add buttons to a list
        List<Button> buttons = Arrays.asList(trans1, trans2, trans3,trans11, trans21, trans31);
        // Apply the style to each button
        for (Button button : buttons) {
            button.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7f50, #1e90ff); -fx-text-fill: white;");
        }
    }

    private void updateLabelGradient(double time) {
        // Dynamically adjust gradient colors based on time
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true, // StartX, StartY, EndX, EndY
                javafx.scene.paint.CycleMethod.REFLECT,
                new Stop(0, Color.color(1 - time, time, 0.5)), // Dynamic color
                new Stop(1, Color.color(time, 1 - time, 1))   // Dynamic color
        );
        guide.setTextFill(gradient);
        me.setTextFill(gradient);
        me1.setTextFill(gradient);
        me2.setTextFill(gradient);
        //trans1.setTextFill(gradient);
        //trans2.setTextFill(gradient);
        //trans3.setTextFill(gradient);
        //trans3.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7f50, #1e90ff); -fx-text-fill: white;");
    }

    //Scrolls to the specified label.
    private void scrollTo(Label label) {
        double layoutY = label.getLayoutY();                                                    // Get the Y-coordinate of the label relative to the VBox
        double scrollHeight = vbox.getHeight() - scrollPane.getViewportBounds().getHeight();   // Calculate the scroll position
        double scrollPosition = layoutY / scrollHeight;
        scrollPane.setVvalue(scrollPosition);                                                   // Scroll to the target position
    }
//    @FXML
//    private void scrollToLabel2() {
//        scrollTo(Whatjob12);
//    }

    @FXML
    void goCareerPage(ActionEvent event) {

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
            System.out.println("Transitioned back to profilepage");
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
