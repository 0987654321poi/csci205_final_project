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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

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

    /**Reset Stock Button */
    @FXML
    private Button btnResetStock;

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
        assert btnResetStock != null : "fx:id=\"btnResetStock\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert lblMoves != null : "fx:id=\"lblMoves\" was not injected: check your FXML file 'solitaire.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'solitaire.fxml'.";
    }

    /**
     * Adds the cards associated image files from the card class into their associated containers in
     * the view
     */
    public void addCards() {
        Game theGame = theModel.getTheGame();
        addStock(theGame);

        addTalon(theGame);

        addTableau(theGame);

        addFoundations(theGame);
    }

    private void addFoundations(Game theGame){
        for(int i = 0; i < 4; i++) {
            ImageView imView = new ImageView();
            switch (i) {
                case 0:
                    if(theGame.getTheFoundations().getTopHeart()!= null)
                        imView.setImage(theGame.getTheFoundations().getTopHeart().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 1:
                    if(theGame.getTheFoundations().getTopSpade()!= null)
                        imView.setImage(theGame.getTheFoundations().getTopSpade().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 2:
                    if(theGame.getTheFoundations().getTopDiamond()!= null)
                        imView.setImage(theGame.getTheFoundations().getTopDiamond().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 3:
                    if(theGame.getTheFoundations().getTopClub()!= null)
                        imView.setImage(theGame.getTheFoundations().getTopClub().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
            }
            imView.setFitHeight(50);
            imView.setFitWidth(40);

            imView.preserveRatioProperty();
            VBoxFoundations.getChildren().add(imView);
        }
    }

    private void addTableau(Game theGame) {
        ImageView imageView = new ImageView();
        for (int i = 0; i < theGame.getTheTab().getPiles().size(); i++)
            addPile(theGame,i);
    }

    private void addPile(Game theGame, int pileIndex){
        if(theGame.getTheTab().getPiles().get(pileIndex).getPile().size() == 0) {
            ImageView imView = new ImageView();
            imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));

            addImageToPile(pileIndex, imView);
        }
        for(int j = 0; j < theGame.getTheTab().getPiles().get(pileIndex).getPile().size(); j++) {
            ImageView imView = new ImageView();
            imView.setImage(theGame.getTheTab().getPiles().get(pileIndex).getPile().get(j).getAssociatedImage());

            addImageToPile(pileIndex, imView);
        }
    }

    private void addImageToPile(int pileIndex, ImageView imView) {
        imView.setFitHeight(50);
        imView.setFitWidth(40);

        imView.preserveRatioProperty();
        switch (pileIndex) {
            case 0:
                VBoxPile1.getChildren().add(imView);
                break;
            case 1:
                VBoxPile2.getChildren().add(imView);
                break;
            case 2:
                VBoxPile3.getChildren().add(imView);
                break;
            case 3:
                VBoxPile4.getChildren().add(imView);
                break;
            case 4:
                VBoxPile5.getChildren().add(imView);
                break;
            case 5:
                VBoxPile6.getChildren().add(imView);
                break;
            case 6:
                VBoxPile7.getChildren().add(imView);
                break;
        }
    }

    private void addTalon(Game theGame) {
        if(theGame.getTheTalon().getTopCard() != null) {
            ImageView TalonView = new ImageView();
            TalonView.setImage(theGame.getTheTalon().getTopCard().getAssociatedImage());

            TalonView.setFitHeight(50);
            TalonView.setFitWidth(40);

            TalonView.preserveRatioProperty();

            VBoxStockTalon.getChildren().add(TalonView);
        }
    }

    private void addStock(Game theGame) {
        ImageView StockView = new ImageView();
        if(theGame.getTheStock().getTopCard() != null) {
            StockView.setImage(theGame.getTheStock().getTopCard().getAssociatedImage());
        }
        else{
            StockView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
        }
        StockView.setFitHeight(50);
        StockView.setFitWidth(40);

        StockView.preserveRatioProperty();

        VBoxStockTalon.getChildren().add(StockView);
    }

    private void clear(){
        VBoxPile1.getChildren().clear();
        VBoxPile2.getChildren().clear();
        VBoxPile3.getChildren().clear();
        VBoxPile4.getChildren().clear();
        VBoxPile5.getChildren().clear();
        VBoxPile6.getChildren().clear();
        VBoxPile7.getChildren().clear();
        VBoxStockTalon.getChildren().clear();
        VBoxFoundations.getChildren().clear();
        addCards();
        initEventHandlers(theModel.getTheGame());
    }

    private void initEventHandlers(Game theGame){
        initPileLogic(VBoxPile1, theGame, 0);
        initPileLogic(VBoxPile2, theGame, 1);
        initPileLogic(VBoxPile3, theGame, 2);
        initPileLogic(VBoxPile4, theGame, 3);
        initPileLogic(VBoxPile5, theGame, 4);
        initPileLogic(VBoxPile6, theGame, 5);
        initPileLogic(VBoxPile7, theGame, 6);
        initStockLogic(theGame);
        initTalonLogic(theGame);
        VBoxFoundations.getChildren().forEach(child -> child.setOnMouseClicked(event -> {
            if(theGame.getSecondClick()) {
                theGame.addToFoundations();
                clear();
            }
            else
                theGame.setSecondClickFalse();
        }));

    }

    private void initTalonLogic(Game theGame) {
        //The talon
        if(VBoxStockTalon.getChildren().size() > 1) {
            VBoxStockTalon.getChildren().get(1).setOnMouseClicked(event -> {
                //You can not make moves to the talon, only from, so a click on the talon will set
                //secondClick to true
                if(!theGame.getSecondClick()) {
                    theGame.setSecondClickTrue();
                    ArrayList<Card> temp = new ArrayList<Card>();
                    temp.add(theGame.getTheTalon().drawCard());
                    theGame.setTempPile(temp);
                    theGame.setLastMovedFrom(8);
                }
                else {
                    theGame.reset();
                    clear();
                    theGame.setSecondClickFalse();
                }
            });
        }
    }

    private void initStockLogic(Game theGame) {
        //The stock
        VBoxStockTalon.getChildren().get(0).setOnMouseClicked(event -> {
            if(!theGame.getSecondClick()) {
                theGame.draw();
                clear();
            }
            else {
                theGame.reset();
                clear();
                theGame.setSecondClickFalse();
            }
        });
        //Moves the cards back to the stock from the talon only if the stock is empty
        //Takes cards from the talon and reverses the array list as the input for the new
        //stock
        btnResetStock.setOnAction(event -> {
            if(theGame.getTheStock().isEmpty()) {
                ArrayList<Card> tempToBeMovedToStock = theGame.getTheTalon().getCards();
                Collections.reverse(tempToBeMovedToStock);
                for(Card card: tempToBeMovedToStock) {
                    if(card != null) {
                        card.flip();
                    }
                }
                theGame.getTheTalon().emptyTalon();
                theGame.getTheStock().resetStock(tempToBeMovedToStock);
                clear();
            }
        });
    }

    private void initPileLogic(VBox VBoxPile1, Game theGame, int index) {
        VBoxPile1.getChildren().forEach(node -> node.setOnMouseClicked(event ->
        {
            if(!theGame.getSecondClick()) {
                if(!theGame.getTheTab().getPiles().get(index).getPile().get(VBoxPile1.getChildren().indexOf(node)).getIsFaceUp() == false){
                    theGame.setTempPile(theGame.getTheTab().getPiles().get(index).split(VBoxPile1.getChildren().indexOf(node)));
                    theGame.setSecondClickTrue();
                    theGame.setLastMovedFrom(index);
                }
            }
            else {
                if(theGame.getLastMovedFrom() != index) {
                    theGame.addToPile(index);
                    clear();
                }
                else
                    theGame.reset();
                theGame.setSecondClickFalse();
            }
        }));
    }

    public void setModel(SolitaireModel model){
        this.theModel = model;
        addCards();
        initEventHandlers(theModel.getTheGame());
    }

}
