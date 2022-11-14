/* ******************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Alejandro Vargas
 * Section: 9:00
 * Date: 11/11/2022
 * Time: 10:35 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: Stock
 *
 * Description: Class representing the Stock pile
 *
 ********************************************
 */

package org.team6;

import java.util.ArrayList;

public class Stock {
    /**
     * Arraylist to store the cards in the stock
     */
    ArrayList<Card> cards;

    /**
     * Creates a new stock with all of the cards that need to be in the stock when the
     * game starts
     * @param cards - the cards that need to be added to the stock at the beginning of the game
     */
    public Stock(ArrayList<Card> cards){
        this.cards = cards;
    }

    /**
     * Draws the top card from the stock
     * @return
     */
    public Card drawCard(){
        Card out = this.cards.get(this.cards.size()-1);
        this.cards.remove(this.cards.size()-1);
        return out;
    }

    /**
     * Resets the stock with more cards
     * @param newStock - the array list of cards which will become the new stock
     */
    public void resetStock(ArrayList<Card> newStock){
        this.cards = newStock;
    }

    /**
     *
     * @return boolean, is the stock empty
     */
    public boolean isEmpty(){
        return this.cards.size() == 0;
    }

    /**
     * Returns the top card but does not remove it
     * @return the top card in the stock
     */
    public Card getTopCard(){
        return this.cards.get(this.cards.size()-1);
    }

}