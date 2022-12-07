/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: TEAM 6
 * Section: 9:00
 * Date: 11/18/2022
 * Time: 9:03 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: SolitaireModel
 *
 * Description: Class representing all the functions needed to play the game of Solitaire
 *
 * *****************************************/
package org.team6.SolitareModel;

import java.util.ArrayList;
import java.util.Collections;

public class SolitaireModel {
    /**
     * The stock for our solitaire game
     */
    private Stock theStock;

    /**
     * The talon for our solitaire game
     */
    private Talon theTalon;

    /**
     * The tableau for our solitaire game
     */
    private Tableau theTab;

    /**
     * A pile to hold cards that are in the process of being moved
     */
    private ArrayList<Card> tempPile = new ArrayList<Card>();

    /**
     * The foundations for our solitaire game
     */
    private Foundations theFoundations;

    /**
     * The deck for our solitaire game
     */
    private Deck theDeck;

    private boolean secondClick = false;

    /**
     * The number of piles in the tableau
     */
    private final int NUM_PILES = 7;

    /** Stores a record of which pile was last moved from, in order to return tempPile to
     * its previous position upon failure to be moved to a new position
     */
    private int lastMovedFrom = -1;

    /** Counter to keep track of moves */
    private int moveCounter = 0;

    /**
     * Constructor for the game class, creates the stock, talon, tableau, etc. and fills them all
     * with cards
     */
    public SolitaireModel() {
        theDeck = new Deck();
        theDeck.fillStandardDeck();
        theDeck.shuffle();
        theStock = new Stock(theDeck.getDeck());
        theTab = new Tableau();
        theTalon = new Talon();
        theFoundations = new Foundations();
        //Creates the 7 piles that form the stock in a game of Solitaire, fills them with 1, 2, 3,
        //4, 5, 6, and 7 cards according to their position, flips the final card in the pile
        theTab.createPiles(NUM_PILES);
        for (int i = 0; i < NUM_PILES; i++) {
            ArrayList<Card> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(theStock.drawCard());
            }
            theTab.fillPile(i, temp);
            theTab.getTopCardFromPile(i).flip();
        }
    }

    /**
     * Method to check if the game is over if the Foundations is Full
     * @return Boolean representing if the game is finished
     */
    public boolean isGameFinished(){
        return theFoundations.gameFinished();
    }

    /**
     * Simple getter method for Move counter
     * @return getMoveCounter
     */
    public int getMoveCounter() { return moveCounter; }

    /**
     * Simple getter method for LastMovedFrom
     * @return lastMovedFrom
     */
    public int getLastMovedFrom(){
        return lastMovedFrom;
    }

    /**
     * Simple setter Method for lastMovedFrom
     * @param PilePos an Integer representing what pile was moved From
     */
    public void setLastMovedFrom(int PilePos){
        lastMovedFrom = PilePos;
    }

    /**
     * Method for setting secondClick to False
     */
    public void setSecondClickFalse(){
        secondClick = false;
    }

    /**
     * Method for setting secondClick to True
     */
    public void setSecondClickTrue(){
        secondClick = true;
    }

    /**
     * Simple getter method for secondClick
     * @return secondClick
     */
    public Boolean getSecondClick(){
        return this.secondClick;
    }

    /**
     * After a card is moved from one pile to another, check the top card of all piles and
     * flip if it is not already face up
     */
    public void onMove(){
        for(Pile p : this.theTab.getPiles()){
            if(p.getTopCard()!= null && !p.getTopCard().getIsFaceUp())
                p.getTopCard().flip();
        }
    }

    /**
     * Method for drawing a card from the stock to the talon and flipping it
     */
    public void draw(){
        if(!theStock.isEmpty()) {
            moveCounter++;
            Card c = theStock.drawCard();
            c.flip();
            theTalon.addCard(c);
        }
    }


    /**
     * Moves the contents of tempPile to a new given index of pile
     * @param pilePos the index of a pile within the tableau
     */
    public boolean addToPile(int pilePos){
        if(tempPile.size() > 0) {
            Card c = tempPile.get(0);
            if(theTab.getPiles().get(pilePos).getPile().size() == 0 && tempPile.get(0).getIntValue() == 13 &&
            c.getIsFaceUp()){
                moveCounter++;
                theTab.getPiles().get(pilePos).addCards(tempPile);
                setSecondClickFalse();
                onMove();
                return true;
            }
            else if (theTab.getPiles().get(pilePos).getPile().size() != 0 && c.getIntValue() == theTab.getPiles().get(pilePos).getTopCard().getIntValue() - 1 &&
                    !c.getColor().equals(theTab.getPiles().get(pilePos).getTopCard().getColor()) &&
                    c.getIsFaceUp()) {
                moveCounter++;
                theTab.getPiles().get(pilePos).addCards(tempPile);
                setSecondClickFalse();
                onMove();
                return true;
            }
        }
            setSecondClickFalse();
            reset();
            return false;
    }

    /** Adds the contents of tempPile back to its previous position as determined by
     * the integer value lastMovedFrom
      */
    public void reset(){
        //add functionality for moving cards back to the talon as well
        if(lastMovedFrom < 7)
            addToPileFree(lastMovedFrom);
        else if(lastMovedFrom == 8){
            theTalon.addCard(tempPile.get(0));
        }
    }


    /**
     * Add cards to a pile with no check for what those cards are
     */
    public void addToPileFree(int pilePos){
        theTab.getPiles().get(pilePos).addCards(tempPile);
    }

    /**
     * Adds cards from the stock to the talon
     */

    /**
     * Simple getter method for the Stock
     * @return theStock
     */
    public Stock getTheStock() {
        return theStock;
    }

    /**
     * Simple getter method for the Foundations
     * @return theFoundations
     */
    public Foundations getTheFoundations() {
        return theFoundations;
    }

    /**
     * Simple getter method for the Talon
     * @return theTalon
     */
    public Talon getTheTalon() {
        return theTalon;
    }

    /**
     * Simple getter method for the Tableau
     * @return theTab
     */
    public Tableau getTheTab() {
        return theTab;
    }

    /**
     * When the Stock is empty, we should have the ability to fill it with all of the cards from the
     * talon
     */
    public void resetStock(){
        if(theStock.isEmpty()) {
            moveCounter++;
            ArrayList<Card> tempToBeMovedToStock = this.theTalon.getCards();
            Collections.reverse(tempToBeMovedToStock);
            for (Card card : tempToBeMovedToStock) {
                if (card != null) {
                    card.flip();
                }
            }
            theTalon.emptyTalon();
            theStock.resetStock(tempToBeMovedToStock);
        }
    }

    /**
     * Setter method for the tempPile
     * @param c an Arraylist of one or more cards
     */
    public void setTempPile(ArrayList<Card> c){
        this.tempPile = c;
    }

    /**
     * Simple getter method for tempPile
     * @return tempPile
     */
    public ArrayList<Card> getTempPile(){
        return this.tempPile;
    }

    /**
     * Moves the contents of tempPile to Foundations and returns true upon success or false upon failure
     */
    public boolean addToFoundations() {
        if(tempPile.size() == 1 && theFoundations.getTopCard(tempPile.get(0).getSuit()) == null &&
        tempPile.get(0).getIntValue() == 1){
            moveCounter++;
            theFoundations.addCard(tempPile.get(0), tempPile.get(0).getSuit());
            setSecondClickFalse();
            onMove();
            return true;
        }
        else if (tempPile.size() == 1 && theFoundations.getTopCard(tempPile.get(0).getSuit()) != null &&
                tempPile.get(0).getIntValue() == theFoundations.getTopCard(tempPile.get(0).getSuit()).getIntValue() + 1){
            theFoundations.addCard(tempPile.get(0), tempPile.get(0).getSuit());
            setSecondClickFalse();
            onMove();
            moveCounter++;
            return true;
        }
        else {
            setSecondClickFalse();
            reset();
            return false;
        }
    }


}
