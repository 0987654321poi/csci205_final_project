/* ******************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: TEAM 6
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

package org.team6.SolitareModel;

import org.team6.SolitareModel.Card;

import java.util.ArrayList;

public class Stock {
    /**
     * Arraylist of cards to store the cards in the stock
     */
    ArrayList<Card> cards;

    /**
     * Stock Constructor class
     * Creates a new stock with all cards that need to be contained within the stock when the
     * game starts
     * @param cards - the cards that need to be added to the stock at the beginning of the game
     */
    public Stock(ArrayList<Card> cards){
        this.cards = cards;
    }

    /**
     * Draws the top card from the stock and returns it
     * @return out - the top card of the stock being returned
     */
    public Card drawCard(){
        Card out = null;
        if(!cards.isEmpty()) {
            out = this.cards.get(this.cards.size() - 1);
            this.cards.remove(this.cards.size() - 1);
        }
        return out;
    }

    /**
     * Resets the stock with more cards
     * this occurs when the talon has received all the cards contained in the stock
     * @param newStock - the array list of cards which will become the new stock
     */
    public void resetStock(ArrayList<Card> newStock){
        this.cards = newStock;
    }

    /**
     * simple boolean that determine if the stock is empty (contains no Cards)
     * @return boolean, is the stock empty
     */
    public boolean isEmpty(){
        return this.cards.size() == 0;
    }

    /**
     * Returns the top card but does not remove it (effectively 'peeks' the top card)
     * @return the top card in the stock
     */
    public Card getTopCard(){
        if(this.cards.size() > 0)
            return this.cards.get(this.cards.size()-1);
        return null;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}