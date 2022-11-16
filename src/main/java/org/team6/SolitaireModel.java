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

    public SolitaireModel(){
        theDeck = new Deck();
        theDeck.fillStandardDeck();
        theStock = new Stock(theDeck.getDeck());

    }

}