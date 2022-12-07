/* ******************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: TEAM 6
 * Date: 11/14/2022
 * Time: 9:15 AM
 *
 * Project:csci205_final_prject
 * Package:org.team6
 * Class: Foundations
 *
 * Description: Class representing the foundations piles, a set of four piles, one for each suit
 *
 ********************************************
 */

package org.team6.SolitareModel;

import org.team6.SolitareModel.Card;
import org.team6.SolitareModel.Suit;

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
     * Foundations Constructor
     * creates new ArrayLists containing Cards for each suit (clubs, diamonds, hearts, spades)
     */
    public Foundations(){
        clubs = new ArrayList<Card>();
        diamonds = new ArrayList<Card>();
        hearts = new ArrayList<Card>();
        spades = new ArrayList<Card>();
    }

    /**
     * Method for adding a card to the proper foundation
     * the model will handle if the card cannot be added by the game rules
     *
     * @param card to be added to the foundation
     */
    public void addCard(Card card, Suit suit) {
        if (suit.equals(suit.HEART)) {
            this.hearts.add(card);
        } else if (suit.equals(suit.DIAMOND)) {
            this.diamonds.add(card);
        } else if (suit.equals(suit.SPADE)) {
            this.spades.add(card);
        } else if (suit.equals(suit.CLUB))
            this.clubs.add(card);
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

    /**
     * Method to pull a card from the foundation so that it can be moved back onto
     * a tableau pile
     * @param type, the suit of the foundation you want to pull from
     * @return the card at the top of that foundation
     */
    public Card getCard(Suit type){
        Card out = null;
        if(type.equals(Suit.HEART)){
            if(this.hearts.size() !=0) {
                out = getTopHeart();
                this.hearts.remove(this.hearts.size() - 1);
            }
        }
        else if(type.equals(Suit.DIAMOND)){
            if(this.diamonds.size() != 0) {
                out = getTopDiamond();
                this.diamonds.remove(this.diamonds.size() - 1);
            }
        }
        else if(type.equals(Suit.SPADE)){
            if(this.spades.size() !=0) {
                out = getTopSpade();
                this.spades.remove(this.spades.size() - 1);
            }
        }
        else{
            if(this.clubs.size() != 0) {
                out = getTopClub();
                this.clubs.remove(this.clubs.size() - 1);
            }
        }
        return out;
    }

    /**
     * Returns the top card from the foundations of a given suit
     * @param Suit the suit of the card
     * @return a card object
     */
    public Card getTopCard(Suit Suit){
        if (hearts.size() > 0 && Suit.equals(org.team6.SolitareModel.Suit.HEART)) {
            return hearts.get(hearts.size()-1);
        }
        else if (diamonds.size() > 0 && Suit.equals(org.team6.SolitareModel.Suit.DIAMOND)) {
            return diamonds.get(diamonds.size()-1);
        }
        else if (spades.size() > 0 && Suit.equals(org.team6.SolitareModel.Suit.SPADE)) {
            return spades.get(spades.size()-1);
        }
        else if (clubs.size() > 0 && Suit.equals(org.team6.SolitareModel.Suit.CLUB)) {
            return clubs.get(clubs.size()-1);
        }
        return null;
    }

    public Card getTopHeart() {
        if(hearts.size() > 0)
            return hearts.get(hearts.size()-1);
        return null;
    }

    public Card getTopDiamond() {
        if(diamonds.size() > 0)
            return diamonds.get(diamonds.size()-1);
        return null;
    }

    public Card getTopSpade() {
        if(spades.size() > 0)
            return spades.get(spades.size()-1);
        return null;
    }

    public Card getTopClub() {
        if(clubs.size() > 0)
            return clubs.get(clubs.size()-1);
        return null;
    }
}