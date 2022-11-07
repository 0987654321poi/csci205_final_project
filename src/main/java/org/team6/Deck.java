
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
 * Class: org.team6.Deck
 *
 * Description: Class representing a deck of cards
 *
 * *****************************************/

package org.team6;

import org.team6.card;
import org.team6.suit;

import java.util.ArrayList;


public class Deck {
    private ArrayList<card> deck;

    public Deck(){
        this.deck = new ArrayList<card>();
    }
    /**
     * Preforms an imperfect shuffle of the deck of cards by swapping a card at each index with one in a
     * random position;
     */
    public void shuffle(){
        for(int i = 0; i < deck.size(); i++){
            card temp = deck.get(i);
            int newPos = (int)(Math.random()*deck.size());
            deck.set(i, deck.get(newPos));
            deck.set(newPos,temp);
        }
    }

    /**
     * Fills a deck with the 52 standard cards used for all card games
     */
    public void fillStandardDeck(){
        for(int i = 1; i <= 13; i++) {
            deck.add(new card(i, suit.SPADE));
            deck.add(new card(i, suit.CLUB));
            deck.add(new card(i, suit.HEART));
            deck.add(new card(i, suit.DIAMOND));
        }
    }

    /**
     * Simulates drawing a card from the deck, returns the org.team6.card and removes it from the deck
     */
    public void draw() {
        System.out.println(deck.get(deck.size()-1).getValue() + " of " +
                deck.get(deck.size()-1).getSuit());
        deck.remove(deck.size() - 1);
    }

}
