/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jacob Piskadlo
 * Section: 9:00
 * Date: 11/16/2022
 * Time: 12:04 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: SolitaireController
 *
 * Description: Controller class for solitaire Application
 *
 * *****************************************/


package org.team6;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.imageio.ImageIO;

public class SolitaireController {

    /**The model*/
    private SolitaireModel theModel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /** HBox representing Tableau, holds all 7 VBox piles */
    @FXML
    private HBox HBoxTableau;

    /** VBOX For the four piles in Foundations (right pane) */
    @FXML
    private VBox VBoxFoundations;

    /** VBOX For 1st Pile in Tableau */
    @FXML
    private VBox VBoxPile1;

    /** VBOX For 2nd Pile in Tableau */
    @FXML
    private VBox VBoxPile2;

    /** VBOX For 3rd Pile in Tableau */
    @FXML
    private VBox VBoxPile3;

    /** VBOX For 4th Pile in Tableau */
    @FXML
    private VBox VBoxPile4;

    /** VBOX For 5th Pile in Tableau */
    @FXML
    private VBox VBoxPile5;

    /** VBOX For 6th Pile in Tableau */
    @FXML
    private VBox VBoxPile6;

    /** VBOX For 7th Pile in Tableau */
    @FXML
    private VBox VBoxPile7;

    /** VBOX For holding both the Stock and Talon (left pane) */
    @FXML
    private VBox VBoxStockTalon;

    /** Undo Button */
    @FXML
    private Button btnUndo;

    /** Label to keep track of moves made */
    @FXML
    private Label lblMoves;

    /** Label to keep track of Time */
    @FXML
    private Label lblTime;

    @FXML
    void initialize() {
        assert HBoxTableau != null : "fx:id=\"HBoxTableau\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxFoundations != null : "fx:id=\"VBoxFoundations\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile1 != null : "fx:id=\"VBoxPile1\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile2 != null : "fx:id=\"VBoxPile2\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile3 != null : "fx:id=\"VBoxPile3\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile4 != null : "fx:id=\"VBoxPile4\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile5 != null : "fx:id=\"VBoxPile5\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile6 != null : "fx:id=\"VBoxPile6\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxPile7 != null : "fx:id=\"VBoxPile7\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert VBoxStockTalon != null : "fx:id=\"VBoxStockTalon\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert lblMoves != null : "fx:id=\"lblMoves\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'solitaire.fxml'.";

    }
    private void initEventHandlers(){
    }

    public void setModel(SolitaireModel model){
        this.theModel = model;
        initEventHandlers();

    }

}
