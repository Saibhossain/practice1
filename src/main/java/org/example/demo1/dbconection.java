package org.example.demo1;


import org.example.demo1.chat.databaseConnection;

import java.sql.*;
import java.util.Scanner;

public class dbconection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3308/javaproject"; // Replace with your DB name
        String username = "root"; // Replace with your DB username
        String password = "";     // Replace with your DB password

        try (Connection connection = databaseConnection.connect()){
            System.out.println("Connected to the database successfully!");

            Scanner scanner = new Scanner(System.in);

            // Get student and supporter IDs
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Supporter ID: ");
            int supporterId = scanner.nextInt();

            while (true) {
                System.out.println("\n1. Student sends message");
                System.out.println("2. Supporter sends message");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice == 3) {
                    System.out.println("Exiting chat...");
                    break;
                }

                // Send a message
                System.out.print("Enter your message: ");
                String message = scanner.nextLine();
                String sender = (choice == 1) ? "Student" : "Supporter";

//                // Optionally handle image URLs
//                System.out.print("Enter image URL (or press Enter to skip): ");
//                String imageUrl = scanner.nextLine();
//                imageUrl = imageUrl.isEmpty() ? null : imageUrl;

                // Store in the database
                storeMessage(connection, studentId, supporterId, message, sender);
            }
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void storeMessage(Connection connection, int studentId, int supporterId, String message, String sender) {
        String insertQuery = "INSERT INTO Chat (student_id, supporter_id, message, sender) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, supporterId);
            preparedStatement.setString(3, message);
            //preparedStatement.setString(4, imageUrl);
            preparedStatement.setString(4, sender);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Message stored successfully!");
            } else {
                System.out.println("Failed to store the message.");
            }
        } catch (SQLException e) {
            System.out.println("Error while storing the message: " + e.getMessage());
        }
    }
}
