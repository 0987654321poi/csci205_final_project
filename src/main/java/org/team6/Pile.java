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
    private ArrayList<Card> pile = new ArrayList<Card>();

    /**
     * When instantiating a pile for solitaire it will take in a list of cards and fill the pile,
     * setting the last card to faceUp
     */
    public Pile(ArrayList<Card> cards){
        for(int i = 0; i < cards.size(); i++) {
            this.pile.add(cards.get(i));
            if(i == cards.size() -1)
                this.pile.get(i).flip();
        }
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
     * Adds new cards to the pile if and only if the color is opposite and the value is one less.
     * @param cards an ArrayList of cards
     */
    public void addCards(ArrayList<Card> cards){
        if(this.pile.size() <= 0 || cards.get(0).getColor() != pile.get(pile.size()-1).getColor() &&
        cards.get(0).getIntValue() == pile.get(pile.size()-1).getIntValue() - 1){
            //A card can only be added to an empty pile if it is a king, so if the pile is empty
            //we must check that the first card in the list is a King
            if(this.pile.size() == 0 && cards.get(0).getIntValue() == 13) {
                for (int i = 0; i < cards.size(); i++)
                    pile.add(cards.get(i));
            }
            else if(this.pile.size() > 0){
                for (int i = 0; i < cards.size(); i++)
                    pile.add(cards.get(i));
            }
        }
    }

    /**
     * Adds new card to the pile if and only if the color is opposite and the value is one less.
     * @param card a single card
     */
    public void addCard(Card card){
        if(this.pile.size() <= 0 || card.getColor() != pile.get(pile.size()-1).getColor() &&
                card.getIntValue() == pile.get(pile.size()-1).getIntValue() - 1){
            //A card can only be added to an empty pile if it is a king
            if(this.pile.size() == 0 && card.getIntValue() == 13)
                pile.add(card);
            else if(this.pile.size() > 0)
                pile.add(card);
        }
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
