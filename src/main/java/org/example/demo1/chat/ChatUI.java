package org.example.demo1.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ChatUI extends Application {
    @FXML
    private TextArea chatDisplay;

    @FXML
    private TextField messageInput;

    @FXML
    private Button sendButton;

    private PrintWriter writer;
    private BufferedReader reader;

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatUI.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Chat Application");
        stage.show();

        // Initialize UI elements
        chatDisplay = (TextArea) scene.lookup("#chatDisplay");
        messageInput = (TextField) scene.lookup("#messageInput");
        sendButton = (Button) scene.lookup("#sendButton");

        // Connect to server
        connectToServer();

        // Send message on button click
        sendButton.setOnAction(event -> sendMessage());
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 12345); // Connect to the server
            writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Thread to receive messages
            new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        String finalMessage = message;
                        // Update the UI thread
                        javafx.application.Platform.runLater(() -> chatDisplay.appendText(finalMessage + "\n"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageInput.getText();
        if (!message.isEmpty()) {
            writer.println(message); // Send message to server
            chatDisplay.appendText("You: " + message + "\n"); // Show sent message in UI
            messageInput.clear();
        }
    }

//
//    private int studentId = 1; // Example student ID
//    private int supporterId = 2;
//    //login
//    private int userId;
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//        // Use the userId for further logic (e.g., loading chat data)
//        System.out.println("User ID passed to ChatUI: " + userId);
//    }
//    //login
//    public void initialize() {
//        loadChatHistory();
//    }
//
//    @FXML
//    public void sendMessage() {
//        String message = messageInput.getText().trim();
//        if (!message.isEmpty()) {
//            try (Connection connection = databaseConnection.connect()) {
//                // Insert the message into the database
//                String query = "INSERT INTO chat_messages (sender_id, receiver_id, message, timestamp) VALUES (?, ?, ?, NOW())";
//                try (PreparedStatement statement = connection.prepareStatement(query)) {
//                    statement.setInt(1, studentId); // Sender ID
//                    statement.setInt(2, supporterId); // Receiver ID
//                    statement.setString(3, message);
//                    statement.executeUpdate();
//                }
//                // Display the message in the chat area
//                chatDisplay.appendText("You: " + message + "\n");
//                messageInput.clear();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void loadChatHistory() {
//        try (Connection connection = databaseConnection.connect()) {
//            // Fetch chat messages between the student and the supporter
//            String query = "SELECT sender_id, message FROM chat_messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY timestamp";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setInt(1, studentId);
//                statement.setInt(2, supporterId);
//                statement.setInt(3, supporterId);
//                statement.setInt(4, studentId);
//
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    while (resultSet.next()) {
//                        int senderId = resultSet.getInt("sender_id");
//                        String message = resultSet.getString("message");
//                        String sender = (senderId == studentId) ? "You" : "Supporter";
//                        chatDisplay.appendText(sender + ": " + message + "\n");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
////chat end


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
    @FXML
    void GotoLoginpage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo1/chat/login.fxml")); // Load layout.fxml to go back
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the stage and set the scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading login.fxml in goBack.");
            e.printStackTrace();
        }
    }
}
