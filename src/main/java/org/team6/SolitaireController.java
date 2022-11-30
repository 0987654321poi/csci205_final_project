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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    /**
     * Adds the cards associated image files from the card class into their associated containers in
     * the view
     */
    public void addCards() {
        Game theGame = theModel.getTheGame();
        ImageView StockView = new ImageView();
        StockView.setImage(theGame.getTheStock().getTopCard().getAssociatedImage());

        StockView.setFitHeight(60);
        StockView.setFitWidth(50);

        StockView.preserveRatioProperty();

        VBoxStockTalon.getChildren().add(StockView);


        if(theGame.getTheTalon().getTopCard() != null) {
            ImageView TalonView = new ImageView();
            TalonView.setImage(theGame.getTheTalon().getTopCard().getAssociatedImage());

            TalonView.setFitHeight(60);
            TalonView.setFitWidth(50);

            TalonView.preserveRatioProperty();

            VBoxStockTalon.getChildren().add(TalonView);
        }


        for (int i = 0; i < theGame.getTheTab().getPiles().size(); i++){
            for(int j = 0; j < theGame.getTheTab().getPiles().get(i).getPile().size(); j++){
                ImageView imView = new ImageView();
                imView.setImage(theGame.getTheTab().getPiles().get(i).getPile().get(j).getAssociatedImage());

                imView.setFitHeight(60);
                imView.setFitWidth(50);

                imView.preserveRatioProperty();

                switch(i){
                    case 1:
                        VBoxPile1.getChildren().add(imView);
                        break;
                    case 2:
                        VBoxPile2.getChildren().add(imView);
                        break;
                    case 3:
                        VBoxPile3.getChildren().add(imView);
                        break;
                    case 4:
                        VBoxPile4.getChildren().add(imView);
                        break;
                    case 5:
                        VBoxPile5.getChildren().add(imView);
                        break;
                    case 6:
                        VBoxPile6.getChildren().add(imView);
                        break;
                    case 7:
                        VBoxPile7.getChildren().add(imView);
                        break;


                }
            }
        }
    }

    private void initEventHandlers(){

    }

    public void setModel(SolitaireModel model){
        this.theModel = model;

        initEventHandlers();

    }

}
