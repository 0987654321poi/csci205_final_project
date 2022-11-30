/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Kevin Page
 * Section: 9:00
 * Date: 11/18/2022
 * Time: 9:03 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: Game
 *
 * Description: Class representing all the functions needed to play the game of Solitaire
 *
 * *****************************************/
package org.team6;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Game {
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
     * The foundations for our solitaire game
     */
    private Foundations theFoundations;

    /**
     * The deck for our solitaire game
     */
    private Deck theDeck;

    /**
     * The number of piles in the tableau
     */
    private final int NUM_PILES = 7;

    /**
     * Constructor for the game class, creates the stock, talon, tableau, etc. and fills them all
     * with cards
     */
    public Game() {
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
     * After a card is moved from one pile to another, check the bottom card of all piles and
     * flip if it is not already face up
     */
    public void onMove(){
        for(Pile p : this.theTab.getPiles()){
            if(!p.getTopCard().getIsFaceUp())
                p.getTopCard().flip();
        }
    }

    /**
     * Moves the card to the correct pile given indexes, and runs the logic for if a card can
     * be added to that pile, if not it is added back to its original pile
     * @param tabPos The position of the pile in the tableau
     * @param pilePos the position of a card within the pile
     * @param finalTabPos the position of the pile we are trying to add to
     */
    public void pileToPile(int tabPos, int pilePos, int finalTabPos){
        ArrayList<Card> tempArray = this.theTab.getPiles().get(tabPos).split(pilePos);
        //Adds cards to a new pile if and only if the card is one value lower and
        //the opposite colour (red 4 can only be added onto black 5)
        if(tempArray.get(0).getIntValue() == theTab.getPiles().get(finalTabPos).getTopCard().getIntValue() - 1
            && !Objects.equals(tempArray.get(0).getColor(), theTab.getPiles().get(finalTabPos).getTopCard().getColor())){
            theTab.getPiles().get(finalTabPos).addCards(tempArray);
            onMove();
        }
        else{
            theTab.getPiles().get(tabPos).addCards(tempArray);
        }
    }

    /**
     * Moves a single card to a pile in the Tableau from the stock
     * @param pilePos the position of a card within the pile
     */
    public void talonToPile(int pilePos){
        Card c = theTalon.drawCard();
        if(c.getIntValue() == theTab.getPiles().get(pilePos).getTopCard().getIntValue() &&
        !c.getColor().equals(theTab.getPiles().get(pilePos).getTopCard().getColor()))
            theTab.getPiles().get(pilePos).addCard(c);
        else
            theTalon.addCard(c);
    }

    /**
     * Adds cards from the stock to the talon
     */
    public void draw(){
        Card c = theStock.drawCard();
        c.flip();
        theTalon.addCard(c);
    }

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
        this.theStock.resetStock(this.theTalon.getCards());
        this.theTalon.emptyTalon();
    }

    /**
     * Moves a single card from a pile to the foundations, if it cannot be placed in the
     * foundations it is moved back to its original pile
     * @param tabPos
     * @param pilePos
     */
    public void pileToFoundations(int tabPos, int pilePos){
        ArrayList<Card> tempArray = this.theTab.getPiles().get(tabPos).split(pilePos);
        if(tempArray.size() == 0){
            Card c = tempArray.get(0);
            if(c.getIntValue() == theFoundations.getTopCard(c.getSuit()).getIntValue() + 1)
                theFoundations.addCard(c, c.getSuit());
            else
                theTab.getPiles().get(tabPos).addCards(tempArray);
        }
    }

    /**
     * Moves a single card from the talon to the foundations.
     */
    public void talonToFoundations(){
        Card c = theTalon.drawCard();
        if(c.getIntValue() == theFoundations.getTopCard(c.getSuit()).getIntValue() + 1)
            theFoundations.addCard(c, c.getSuit());
        else
            theTalon.addCard(c);
    }


}
