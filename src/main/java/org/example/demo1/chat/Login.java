//package org.example.demo1.chat;
//import org.example.demo1.chat.databaseConnection;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class Login {
//    @FXML
//    private TextField UserEmail;
//
//    @FXML
//    private PasswordField userPass;
//
//    @FXML
//    void login(ActionEvent event) {
//        String email = UserEmail.getText();
//        String password = userPass.getText();
//
//        if (email.isEmpty() || password.isEmpty()) {
//            // Show an alert if fields are empty
//            showAlert("Error", "Please enter your email and password.");
//            return;
//        }
//
//        try {
//            // Get database connection
//            Connection connection = databaseConnection.connect();
//
//            // Prepare SQL query to validate user
//            String query = "SELECT user_id FROM users WHERE email = ? AND password = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, email);
//            statement.setString(2, password);
//
//            // Execute the query
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                // Login successful, retrieve the user ID
//                int userId = resultSet.getInt("user_id");
//
//                // Load the ChatUI.fxml and pass the user ID
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/chat/chatUI.fxml"));
//                Parent root = loader.load();
//
//                // Pass user ID to ChatUI controller
//                ChatUI chatController = loader.getController();
//                chatController.setUserId(userId);
//
//                // Switch to the ChatUI scene
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(new Scene(root));
//                stage.show();
//            } else {
//                // Show an alert if login fails
//                showAlert("Login Failed", "Invalid email or password.");
//            }
//
//            // Close resources
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert("Error", "An error occurred while trying to log in.");
//        }
//
//    }
//    // Helper method to show alerts
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//    //Closed login
//
//    @FXML
//    void goExplorePage(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/NewLayout.fxml")); // Load layout.fxml to go back
//            Parent root = loader.load();
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException e) {
//            System.out.println("Error loading NewLayout.fxml in goBack.");
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void goProfilePage(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/profile.fxml")); // Load layout.fxml to go back
//            Parent root = loader.load();
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException e) {
//            System.out.println("Error loading profile.fxml in goBack.");
//            e.printStackTrace();
//        }
//    }
//}
