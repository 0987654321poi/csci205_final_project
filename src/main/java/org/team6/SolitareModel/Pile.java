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
 * Description: Class representing a pile of cards, where selecting any face up card
 *
 * *****************************************/
package org.team6.SolitareModel;

import org.team6.SolitareModel.Card;

import java.util.ArrayList;

/**
 * A class to encapsulate the idea of a pile of cards. Will be used to represent each pile in the tableau
 * as well as piles of cards being moved around from one location in the tableau to another.
 */
public class Pile {
    private ArrayList<Card> pile;

    /**
     * Constructs a new pile of cards, filing our pile field with an arraylist of cards representing the
     * cards in the pile
     */
    public Pile(ArrayList<Card> cards){
        this.pile = cards;
    }

    /**
     * Creates a new pile, but makes the pile empty
     */
    public Pile(){
        this.pile = new ArrayList<Card>();
    }

    /**
     * Splits the pile at a given index, returning a new ArrayList representing the cards that are being removed
     * from the original pile
     * @param index The index of the card being selected
     * @return An ArrayList of the card selected and any cards beneath it
     */
    public ArrayList<Card> split(int index){
        ArrayList<Card> newPile = new ArrayList<Card>();
        for(int i = index; i < pile.size(); i++){
                newPile.add(pile.get(i));
        }
        pile.subList(index,pile.size()).clear();
        return newPile;
    }

    /**
     * Simple getter method for pile, the ArrayList of cards representing the cards in our pile object
     * @return the pile of cards as an ArrayList, this should only be used for testing
     */
    public ArrayList<Card> getPile(){ return this.pile; }


    /**
     * Adds new cards to the pile from an Arraylist of cards
     * @param cards the ArrayList of cards to be added
     */
    public void addCards(ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++)
            pile.add(cards.get(i));

    }

    /**
     * Adds a single card to the pile
     * @param card The card to be added
     */
    public void addCard(Card card){
        this.pile.add(card);
    }



    /**
     * Returns the top card on the pile, which is represented by the card with the last index in the pile
     * ArrayList
     * @return the top card on the pile
     */
    public Card getTopCard(){
        if(pile.size() > 0)
            return pile.get(pile.size()-1);
        return null;
    }

    /**
     * Returns the bottom card on the pile, which is represented by the card at the 0th index in the pile
     * ArrayList
     * @return the bottom card on the pile
     */
    public Card getBottomCard(){
        if(pile.size() > 0)
            return pile.get(0);
        return null;
    }

}
