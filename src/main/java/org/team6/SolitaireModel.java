/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Kevin Page
 * Section: 9:00
 * Date: 11/8/2022
 * Time: 10:14 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: Pile
 *
 * Description: Class representing the entire game of Solitaire
 *
 * *****************************************/
package org.team6;

import java.util.ArrayList;

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
     * Creates a new solitaire model with a full shuffled deck and a properly sized
     * tableau. Also instantiates a new talon, stock, and the foundations.
     */
    public SolitaireModel(){
        theDeck = new Deck();
        theDeck.fillStandardDeck();
        //theDeck.shuffle();
        theStock = new Stock(theDeck.getDeck());
        theTab = new Tableau();
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
        theFoundations = new Foundations();
        theTalon = new Talon();

    }

    /**
     * Moves a given card into a tableau pile if the card is the appropriate type
     * @param pile - the pile being added to the tableau
     * @param tabNumber - the number of the tableau pile that the card is being added to
     */
    public void moveCardToTableau(Pile pile, int tabNumber) {
        Card card = pile.getBottomCard();
        Card topCard = theTab.piles.get(tabNumber).getTopCard();
        if(!(topCard.getColor().equals(card.getColor()))
        &&  topCard.getIntValue() == card.getIntValue()+1){
            if(!card.getIsFaceUp()){
                card.flip();
            }
            theTab.piles.get(tabNumber).addCards(pile.getPile());
        }
    }

    public static void main(String[] args) {
        SolitaireModel model = new SolitaireModel();
        Card sample = new Card(6, suit.HEART);
        Pile sampPile = new Pile();
        sampPile.addCard(sample);
        Card card2 = new Card(5, suit.SPADE);
        card2.flip();
        sampPile.addCard(card2);
        model.moveCardToTableau(sampPile, 6);
        for (int i = 0; i < model.NUM_PILES; i++) {
            model.theTab.piles.get(i).display();
            System.out.println();
        }

    }

}