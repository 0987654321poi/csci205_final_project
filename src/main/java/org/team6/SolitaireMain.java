package org.team6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SolitaireMain extends Application {

    private SolitaireModel theModel;

    private SolitaireController theController;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.theModel = new SolitaireModel();

        // Load in file form resource
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/solitaire.fxml"));
        Parent root = loader.load();
        this.theController = loader.getController();
        this.theController.setModel(theModel);

        // Set up our stage
        primaryStage.setTitle("Solitaire");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
