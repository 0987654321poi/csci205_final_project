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
     * which card was selected first during a moveset
     */
    private static Pile selectedFirst;


    /**
     * which card was selected second (last) during a moveset
     */
    private static Pile selectedSecond;

    /** the game instance being interacted with by the Model */
    private static Game theGame;

    /**
     * the constructor for the Solitaire Model
     */
    public SolitaireModel() {
        this.selectedFirst=null;
        this.selectedSecond=null;
        this.theGame = new Game();
    }

    /**
     * determines based on the piles class instance if the new location is valid
     * @param from the selected pile
     * @param to the new location pile
     * @return true if the move is valid
     * @return false if invalid
     */
    private static boolean isValidLocation( Card from, Card to) {
        return false; //TODO isValidLocation
       // if (to.getIsIn() instanceof )
    }

    /**
     * Attempts to move a selected pile to a new location, if valid
     * @param from the selected pile
     * @param to the new location pile
     * @return true if the move is successful,
     * @return false if unsuccessful
     */
    public static boolean moveTo( Pile from, Pile to) {
        return false; //TODO MAKE moveTo
    }

    /**
     * takes the selected card and flips it if the card is face down
     * @param selectedCard
     */
    public static void flipCard(Card selectedCard) {
        selectedCard.flip();
    }

    /**
     * @return the Game object
     */
    public Game getTheGame(){
        return this.theGame;
    }

    /**
     * Searches a new placement for the selected card.
     * The game attempts to do this automatically, only requiring the clicking of the card.
     * @param selectedCard
     * @return
     */
    public static boolean autoMoveCard(Card selectedCard) {
        //temporary: is the card on top? continue if yes, return false if no
        //TODO check for valid position to move
        //Can it be placed in Foundations?
        //TODO check for valid Foundation spots
        //Can it be moved to somewhere else in the Tableau?
        //TODO check for valid Tableau spots
        //if neither is true, return false
        return false;
    }




    //----------------------------------=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-



    /**
     * undoes all actions made in the current instance, and reverts it to the previous instance.
     */
    public static void undo() {

    }
    /*
    /**
     * 'selects' a card, currently unsure how this will function later

    public static void select(Card selectedCard) {
        //Create a Pile of Cards from the selected Card by splitting its pile location downward

        Object pileOfSelectedCard = selectedCard.getIsIn(); //a fast reference to the Cards OG Pile Location

        //gather the cards beneath the selected card in an arraylist
        ArrayList<Card> selectedCards = pileOfSelectedCard.split(pileOfSelectedCard.getPile().indexOf(selectedCard));

        
        for (Card card : selectedCards) {

        }
        if (selectedFirst == null) {

        }
        else if(selectedFirst != null) {
           // selectedSecond = selectedCards;
            /*if(isValidLocation(selectedFirst.getInPile(),selectedSecond.getInPile())){
                moveTo(selectedFirst.getInPile(),selectedSecond.getInPile());
            }
            moveTo(selectedFirst, selectedSecond);
            selectedFirst=null;
            selectedSecond=null;
        }
    }
    */
}