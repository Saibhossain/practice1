package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Search {
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
