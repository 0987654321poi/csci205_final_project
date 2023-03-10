
/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Section: 9:00
 * Date: 11/4/2022
 * Time: 9:43 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: org.team6.SolitareModel.Deck
 *
 * Description: Class representing a deck of cards
 *
 * *****************************************/

package org.team6.SolitareModel;

import org.team6.SolitareModel.Card;
import org.team6.SolitareModel.Suit;

import java.util.ArrayList;


public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
    }
    /**
     * Preforms an imperfect shuffle of the deck of cards by swapping a card at each index with one in a
     * random position;
     */
    public void shuffle(){
        for(int i = 0; i < deck.size(); i++){
            Card temp = deck.get(i);
            int newPos = (int)(Math.random()*deck.size());
            deck.set(i, deck.get(newPos));
            deck.set(newPos,temp);
        }
    }

    /**
     * Simulates adding a card to the deck
     * @param c a card
     */
    public void addCard(Card c){
        deck.add(c);
    }

    /**
     * Fills a deck with the 52 standard cards used for all card games
     */
    public void fillStandardDeck(){
        for(int i = 1; i <= 13; i++) {
            deck.add(new Card(i, Suit.SPADE));
            deck.add(new Card(i, Suit.CLUB));
            deck.add(new Card(i, Suit.HEART));
            deck.add(new Card(i, Suit.DIAMOND));
        }
    }

    /**
     * Simple getter method for deck
     * @return An Arraylist of cards representing a deck
     */
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    /**
     * Simulates drawing a card from the deck, returns the card and removes it from the deck
     */
    public Card draw() {
        Card temp = deck.get(deck.size()-1);
        deck.remove(deck.size() - 1);
        return temp;
    }

}

