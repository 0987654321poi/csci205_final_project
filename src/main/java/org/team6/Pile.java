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
package org.team6;

import java.util.ArrayList;
import java.util.LinkedList;

public class Pile {
    private ArrayList<Card> pile;

    /**
     * When instantiating a pile for solitaire it will take in a list of cards and fill the pile,
     * setting the last card to faceUp
     */
    public Pile(ArrayList<Card> cards){
        this.pile = new ArrayList<Card>();
    }

    /**
     * Splits the pile, returning a new ArrayList
     * @param index The index of the card being selected
     * @return An ArrayList of the card selected and any cards beneath it
     */
    public ArrayList<Card> split(int index){
        ArrayList<Card> newPile = new ArrayList<Card>();
        if(this.pile.get(index).getIsFaceUP()){
            for(int i = index; i < pile.size(); i++){
                newPile.add(pile.get(i));
                pile.remove(i);
            }
        }
        return newPile;
    }

    /**
     * Simple getter method for pile
     * @return the pile of cards as an ArrayList, this should only be used for testing
     */
    public ArrayList<Card> getPile(){ return this.pile; }


    /**
     * Adds new cards to the pile from an Arraylist of cards
     * @param cards an ArrayList of cards
     */
    public void addCards(ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++)
            pile.add(cards.get(i));

    }

    /**
     * Adds a card to the pile
     * @param card The card to be added
     */
    public void addCard(Card card){
        this.pile.add(card);
    }


    /**
     * locates a card in the Pile ArrayList
     * @param card
     * @return
     */
    public int indexOf(Card card) {
        return 0;
    }

    /**
     * For testing only
     */
    public void display(){
        for(Card c : this.pile){
            if(c.getIsFaceUP() == false)
                System.out.println("UNKNOWN");
            else
                System.out.println(c.getValue() + " of " + c.getSuit());
        }
    }
}
