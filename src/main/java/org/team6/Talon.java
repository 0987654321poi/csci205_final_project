/* ******************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Alejandro Vargas
 * Section: 9:00
 * Date: 11/11/2022
 * Time: 9:00 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: Talon
 *
 * Description: Class representing the Talon pile
 *
 ********************************************
 */

package org.team6;

import java.util.ArrayList;

/**
 * A class to encapsulate the talon object in a solitaire game
 */
public class Talon {
    /**
     * Array list holding all of the cards in the talon
     */
    private ArrayList<Card> cards;

    /**
     * Constructs a new Talon with an empty cards list
     */
    public Talon(){
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card from the stock to the talon
     * @param drawnCard - the card drawn from the stock that is to be added
     */
    public void addCard(Card drawnCard){
        this.cards.add(drawnCard);
    }

    /**
     * Returns the top card on the talon represented by the card at the last index in the cards list
     * @return the card at the top of the talon or null if the talon is empty
     */
    public Card getTopCard(){
        if(this.cards.size() > 0){
            return this.cards.get(this.cards.size()-1);
        }
        else{
            return null;
        }
    }

    /**
     * Returns the top card on the talon and removes it, or returns null if talon is empty
     * @return the top card on the talon or null if the talon is empty
     */
    public Card drawCard(){
        Card out = getTopCard();
        if(out!= null){
            this.cards.remove(this.cards.size()-1);
        }
        return out;
    }

    /**
     * Empties the talon so that the cards can be returned to the stock
     */
    public void emptyTalon(){
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}