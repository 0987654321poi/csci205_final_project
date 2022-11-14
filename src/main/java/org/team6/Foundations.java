/* ******************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Alejandro Vargas Altamirano
 * Date: 11/14/2022
 * Time: 9:15 AM
 *
 * Project:csci205_final_prject
 * Package:org.team6
 * Class: Foundations
 *
 * Description: Class representing the foundations
 *
 ********************************************
 */

package org.team6;

import java.util.ArrayList;

public class Foundations {

    /**
     * Array list holding all of the cards that have been added to the foundation of each suit
     */
    private ArrayList<Card> hearts;
    private ArrayList<Card> diamonds;
    private ArrayList<Card> spades;
    private ArrayList<Card> clubs;

    /**
     * Method for adding a card to the proper foundation
     * the model will handle if the card cannot be added by the game rules
     * @param card to be added to the foundation
     */
    public void addCard(Card card){
        if(card.getSuit().equals(suit.HEART)){
            this.hearts.add(card);
        }
        else if(card.getSuit().equals(suit.DIAMOND)){
            this.diamonds.add(card);
        }
        else if(card.getSuit().equals(suit.SPADE)){
            this.spades.add(card);
        }
        else{
            this.clubs.add(card);
        }
    }

    /**
     * Method to tell whether the game has been completed and all the foundations are full
     * @return true if game finished, false otherwise
     */
    public boolean gameFinished(){
        if(this.hearts.size() == 13 &&
                this.diamonds.size() == 13 &&
                this.spades.size() == 13 &&
                this.clubs.size() == 13){
            return true;
        }
        else{
            return false;
        }
    }
}