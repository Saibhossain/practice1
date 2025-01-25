package org.example.demo1.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatUI {



    @FXML
    void goProfilePage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/profile.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading profile.fxml in goBack.");
            e.printStackTrace();
        }
    }
    @FXML
    void goSearchPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/search.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading search.fxml in goBack.");
            e.printStackTrace();
        }
    }
    @FXML
    void goExplorePage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/NewLayout.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading NewLayout.fxml in goBack.");
            e.printStackTrace();
        }
    }
    @FXML
    public void goCareerPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/career.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading career.fxml in goBack.");
            e.printStackTrace();
        }
    }
}
