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

    public SolitaireModel(){
        theDeck = new Deck();
        theDeck.fillStandardDeck();
        theDeck.shuffle();
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

    }

    public static void main(String[] args) {
        SolitaireModel model = new SolitaireModel();
        for (int i = 0; i < model.NUM_PILES; i++) {
            model.theTab.piles.get(i).display();
            System.out.println();
        }
        System.out.println(model.theDeck.getDeck().size());
    }

}