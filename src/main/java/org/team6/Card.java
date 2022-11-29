
/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Section: 9:00
 * Date: 11/4/2022
 * Time: 9:34 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: org.team6.card
 *
 * Description: Class representing a single org.team6.card
 *
 * *****************************************/
package org.team6;

/**
 * Class representing a single card that can be used in any standard card game
 */
public class Card {
    /** Enum representing the suit of the .card (clubs,spades,diamonds,hearts) */
    private suit suit;
    /** Integer value representing the value on the card with 1 being ace and 13 being King */
    private int value;
    /** String representing the color of the card, red or black */
    private String color;
    /** Boolean representing whether the card is face up or face down */
    private boolean isFaceUp;

    /** Holds a reference to which pile the Card is in. **/
    private Pile inPile;

    /** Boolean representing if the card is in a 'selected' state **/
    private boolean isSelected;

    /**
     * Creates a card given information about the suit and value
     * @param value The value of the card being created
     * @param suit the suit of the card being created
     */
    public Card(int value, suit suit){
        this.suit = suit;
        this.value = value;
        if(suit.equals(suit.SPADE) || suit.equals(suit.CLUB))
            this.color = "black";
        else
            this.color = "red";
        this.isFaceUp = false;
        this.inPile = null;
        this.isSelected = false;
    }

    /**
     * Simple getter method for color
     * @return The color of the card
     */
    public String getColor(){
        return this.color;
    }

    /**
     * Represents flipping the card, switches the boolean value isFaceUP
     */
    public void flip(){
        this.isFaceUp = !isFaceUp;
    }

    /**
     * returns which way the card is facing
     * @return isFaceUP, the boolean representing whether the card is face up or down
     */
    public boolean getIsFaceUP(){
        return this.isFaceUp;
    }


    /**
     * Returns the value of the card as a String, if the card is a face card it will return a word,
     * otherwise it will return a number in the form of a String
     * @return
     */
    public String getValue(){
        switch(this.value){
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
        }
        return this.value + "";
    }

    /**
     * Simple getter method for value
     * @return The value of the card (1-13)
     */
    public int getIntValue(){
        return this.value;
    }

    /**
     * Returns the suit of the card in the form of a String
     * @return The suit of the card
     */
    public String getSuit() {
        switch(this.suit){
            case CLUB:
                return "Clubs";
            case HEART:
                return "Hearts";
            case SPADE:
                return "Spades";
            case DIAMOND:
                return "Diamonds";
        }
        return "";
    }

    /** getter method for inPile **/
    public Pile getInPile() {
        return this.inPile;
    }
}



/** Enum representing the suit of the card (Clubs,Spades,Diamonds,Hearts) */
enum suit{
    SPADE,
    DIAMOND,
    CLUB,
    HEART
}