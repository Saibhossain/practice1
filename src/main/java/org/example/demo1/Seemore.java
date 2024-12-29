package org.example.demo1;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Seemore {
    @FXML
    private VBox universityListVBox; // Reference to the VBox in FXML

    @FXML
    void initialize() {
        // Get university data
        List<univercityDetails.University> universities = univercityDetails.getUniversities();

        // Add an HBox for each private university
        for (univercityDetails.University uni : universities) {
            if (uni.getRank() > 0 && uni.getRank() <= 5) { // Filter for private universities based on rank
                HBox hBox = new HBox(10); // 10 is spacing between TextArea and ImageView
                hBox.setPrefSize(812, 150);

                // TextArea for university details
                TextArea textArea = new TextArea();
                textArea.setEditable(false);
                textArea.setPrefSize(584, 150);

                textArea.setText(
                        "Name: " + uni.getName() + "\n" +
                                "Location: \t" + uni.getLocation() + "\n" +
                                "Established: " + uni.getEstablished() + "\n" +
                                "Programs: " + String.join(", ", uni.getPrograms()) + "\n" +
                                "Webside: \t" + uni.getWebsite() + "\n" +
                                "Rank: \t" + uni.getRank()
                );
                // Set font size to 18
                textArea.setStyle("-fx-font-size: 14;");

                // ImageView for university photo (using placeholder image)
                ImageView imageView = new ImageView();
                imageView.setFitHeight(150);
                imageView.setFitWidth(208);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image("Brac.jpg")); // Placeholder image

                // Set margin of 10 for the TextArea
                HBox.setMargin(textArea, new Insets(0,0,0,10));

                // Add TextArea and ImageView to HBox
                hBox.getChildren().addAll(textArea, imageView);

                // Add HBox to VBox
                universityListVBox.getChildren().add(hBox);
            }
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
