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
 * Class: SolitaireController
 *
 * Description: Controller class for solitaire Application
 *
 * *****************************************/


package org.team6;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.team6.SolitareModel.Card;
import org.team6.SolitareModel.SolitaireModel;

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
        if(theModel.isGameFinished()){
            ImageView imView1 = new ImageView(new Image(getClass().getResourceAsStream("/Y.png")));
            imView1.setFitHeight(50);
            imView1.setFitWidth(40);
            VBoxPile1.getChildren().add(imView1);
            ImageView imView2 = new ImageView(new Image(getClass().getResourceAsStream("/O.png")));
            imView2.setFitHeight(50);
            imView2.setFitWidth(40);
            VBoxPile1.getChildren().add(imView2);
            ImageView imView3 = new ImageView(new Image(getClass().getResourceAsStream("/U.png")));
            imView3.setFitHeight(50);
            imView3.setFitWidth(40);
            VBoxPile1.getChildren().add(imView3);
            ImageView imView4 = new ImageView(new Image(getClass().getResourceAsStream("/W.png")));
            imView4.setFitHeight(50);
            imView4.setFitWidth(40);
            VBoxPile2.getChildren().add(imView4);
            ImageView imView5 = new ImageView(new Image(getClass().getResourceAsStream("/I.png")));
            imView5.setFitHeight(50);
            imView5.setFitWidth(40);
            VBoxPile2.getChildren().add(imView5);
            ImageView imView6 = new ImageView(new Image(getClass().getResourceAsStream("/N.png")));
            imView6.setFitHeight(50);
            imView6.setFitWidth(40);
            VBoxPile2.getChildren().add(imView6);
        }
        else {
            addStock(theModel);

            addTalon(theModel);

            addTableau(theModel);

            addFoundations(theModel);
        }
    }

    /**
     * Adds the top card of each of the foundations piles to the Vbox associated with the Foundations
     * @param theModel
     */
    private void addFoundations(SolitaireModel theModel){
        for(int i = 0; i < 4; i++) {
            ImageView imView = new ImageView();
            switch (i) {
                case 0:
                    if(theModel.getTheFoundations().getTopHeart()!= null)
                        imView.setImage(theModel.getTheFoundations().getTopHeart().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 1:
                    if(theModel.getTheFoundations().getTopSpade()!= null)
                        imView.setImage(theModel.getTheFoundations().getTopSpade().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 2:
                    if(theModel.getTheFoundations().getTopDiamond()!= null)
                        imView.setImage(theModel.getTheFoundations().getTopDiamond().getAssociatedImage());
                    else
                        imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
                    break;
                case 3:
                    if(theModel.getTheFoundations().getTopClub()!= null)
                        imView.setImage(theModel.getTheFoundations().getTopClub().getAssociatedImage());
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

    /**
     * Adds all Cards associated to the Tableau into the corresponding to the Tableau
     * @param theModel
     */
    private void addTableau(SolitaireModel theModel) {
        ImageView imageView = new ImageView();
        for (int i = 0; i < theModel.getTheTab().getPiles().size(); i++)
            addPile(theModel,i);
    }

    /**
     * Adds the cards associated with a Pile into the Vbox corresponding to that pile
     * @param theModel
     * @param pileIndex The Index of the Pile within the Tableau
     */
    private void addPile(SolitaireModel theModel, int pileIndex){
        if(theModel.getTheTab().getPiles().get(pileIndex).getPile().size() == 0) {
            ImageView imView = new ImageView();
            imView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));

            addImageToPile(pileIndex, imView);
        }
        for(int j = 0; j < theModel.getTheTab().getPiles().get(pileIndex).getPile().size(); j++) {
            ImageView imView = new ImageView();
            imView.setImage(theModel.getTheTab().getPiles().get(pileIndex).getPile().get(j).getAssociatedImage());

            addImageToPile(pileIndex, imView);
        }
    }

    /**
     * Method for adding images to the pile given an Imageview Object and the index of the Pile
     * @param pileIndex the Index of the pile within the Tableau
     * @param imView An ImageView object
     */
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

    /**
     * Method for adding the Image associated with the top card of the Talon to the Vbox associated
     * with Talon
     * @param theModel
     */
    private void addTalon(SolitaireModel theModel) {
        if(theModel.getTheTalon().getTopCard() != null) {
            ImageView TalonView = new ImageView();
            TalonView.setImage(theModel.getTheTalon().getTopCard().getAssociatedImage());

            TalonView.setFitHeight(50);
            TalonView.setFitWidth(40);

            TalonView.preserveRatioProperty();

            VBoxStockTalon.getChildren().add(TalonView);
        }
    }

    /**
     * Method for adding the Image associated with the top card of the Stock to the Vbox associated
     * with Stock
     * @param theModel
     */
    private void addStock(SolitaireModel theModel) {
        ImageView StockView = new ImageView();
        if(theModel.getTheStock().getTopCard() != null) {
            StockView.setImage(theModel.getTheStock().getTopCard().getAssociatedImage());
        }
        else{
            StockView.setImage(new Image(getClass().getResourceAsStream("/Empty.png")));
        }
        StockView.setFitHeight(50);
        StockView.setFitWidth(40);

        StockView.preserveRatioProperty();

        VBoxStockTalon.getChildren().add(StockView);
    }

    /**
     * Method for clearing all card images out of all piles and resetting them with the new
     * cards that occupy the associated piles in the model
     */
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
        initEventHandlers(theModel);
    }

    /**
     * Sets the events for clicking on cards within the Stock, all piles of the Tableau, and Talon,
     * as well as the Foundations
     * @param theGame
     */
    private void initEventHandlers(SolitaireModel theGame){
        initPileLogic(VBoxPile1, theGame, 0);
        initPileLogic(VBoxPile2, theGame, 1);
        initPileLogic(VBoxPile3, theGame, 2);
        initPileLogic(VBoxPile4, theGame, 3);
        initPileLogic(VBoxPile5, theGame, 4);
        initPileLogic(VBoxPile6, theGame, 5);
        initPileLogic(VBoxPile7, theGame, 6);
        initStockLogic(theModel);
        initTalonLogic(theModel);
        VBoxFoundations.getChildren().forEach(child -> child.setOnMouseClicked(event -> {
            lblMoves.setText(Integer.toString(theModel.getMoveCounter()));
            if(theModel.getSecondClick()) {
                theModel.addToFoundations();
                clear();
            }
            else
                theModel.setSecondClickFalse();
        }));

    }

    /**
     * Initializes logic for first and second click of cards within the talon
     * @param theModel
     */
    private void initTalonLogic(SolitaireModel theModel) {
        //The talon
        lblMoves.setText(Integer.toString(theModel.getMoveCounter()));
        if(VBoxStockTalon.getChildren().size() > 1) {
            VBoxStockTalon.getChildren().get(1).setOnMouseClicked(event -> {
                //You can not make moves to the talon, only from, so a click on the talon will set
                //secondClick to true
                if(!theModel.getSecondClick()) {
                    theModel.setSecondClickTrue();
                    ArrayList<Card> temp = new ArrayList<Card>();
                    temp.add(theModel.getTheTalon().drawCard());
                    VBoxStockTalon.getChildren().get(1).setEffect(new DropShadow(20, Color.GOLD));
                    theModel.setTempPile(temp);
                    theModel.setLastMovedFrom(8);
                }
                else {
                    theModel.reset();
                    VBoxStockTalon.getChildren().get(1).setEffect(null);
                    clear();

                    theModel.setSecondClickFalse();
                }
            });
        }
    }

    /**
     * Initializes the logic for first and second clicks on cards within the stock
     * @param theModel
     */
    private void initStockLogic(SolitaireModel theModel) {
        //The stock
        lblMoves.setText(Integer.toString(theModel.getMoveCounter()));
        VBoxStockTalon.getChildren().get(0).setOnMouseClicked(event -> {
            if(!theModel.getSecondClick()) {
                theModel.draw();
                clear();
            }
            else {
                theModel.reset();
                clear();
                theModel.setSecondClickFalse();
            }
        });
        //Moves the cards back to the stock from the talon only if the stock is empty
        //Takes cards from the talon and reverses the array list as the input for the new
        //stock
        btnResetStock.setOnAction(event -> {
            theModel.resetStock();
            clear();
        });
    }

    /**
     * Initializes the logic for first and second clicks on cards within the Tableau Piles
     * @param VBoxPile The pile for which logic is being added
     * @param theModel the model
     * @param index The index of the pile within the Tableau
     */
    private void initPileLogic(VBox VBoxPile, SolitaireModel theModel, int index) {
        lblMoves.setText(Integer.toString(theModel.getMoveCounter()));
        VBoxPile.getChildren().forEach(node -> node.setOnMouseClicked(event ->
        {
            int ind = VBoxPile.getChildren().indexOf(node);
            if(!theModel.getSecondClick()) {
                if(!theModel.getTheTab().getPiles().get(index).getPile().get(VBoxPile.getChildren().indexOf(node)).getIsFaceUp() == false){
                    theModel.setTempPile(theModel.getTheTab().getPiles().get(index).split(VBoxPile.getChildren().indexOf(node)));
                    theModel.setSecondClickTrue();

                    //Add Card Glow
                        VBoxPile.getChildren().get(ind).setEffect(new DropShadow(20, Color.GOLD));
                        theModel.setLastMovedFrom(index);
                }
            }
            else {
                if(theModel.getLastMovedFrom() != index) {
                    VBoxPile1.getChildren().get(ind).setEffect(null);
                    theModel.addToPile(index);
                    clear();
                }
                else {
                    theModel.reset();
                    VBoxPile1.getChildren().get(ind).setEffect(null);
                }
                theModel.setSecondClickFalse();
            }
        }));
    }

    /**
     * Sets the model that will be used to control the events of the game
     * @param model an instance of SolitaireModel
     */
    public void setModel(SolitaireModel model){
        this.theModel = model;
        addCards();
        initEventHandlers(theModel);
    }

}
