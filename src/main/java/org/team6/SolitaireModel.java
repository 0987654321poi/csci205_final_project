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

    /**
     * the constructor for the Solitaire Model
     */
    public SolitaireModel() {
        this.selectedFirst=null;
        this.selectedSecond=null;
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
     * determines based on the piles class instance if the new location is valid
     * @param from the selected pile
     * @param to the new location pile
     * @return true if the move is valid
     * @return false if invalid
     */
    private static boolean isValidLocation( Pile from, Pile to) {
        return false; //TODO MAKE isValidLocation
    }

    /**
     * undoes all actions made in the current instance, and reverts it to the previous instance.
     */
    public static void undo() {

    }

    /**
     * 'selects' a card, currently unsure how this will function later
     */
    public static void select(Pile selectedCards) {
        if (selectedFirst == null) {
            selectedFirst = selectedCards;
        }
        else if(selectedFirst != null) {
            selectedSecond = selectedCards;
            /*if(isValidLocation(selectedFirst.getInPile(),selectedSecond.getInPile())){
                moveTo(selectedFirst.getInPile(),selectedSecond.getInPile());
            }*/
        }
    }
}