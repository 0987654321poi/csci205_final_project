/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: TEAM 6
 * Section: 9:00
 * Date: 11/16/2022
 * Time: 12:04 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: SolitaireMain
 *
 * Description: Main class for the Solitaire JavaFX application
 *
 * *****************************************/

package org.team6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.team6.SolitareModel.SolitaireModel;

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
        Scene scene = new Scene(root, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
