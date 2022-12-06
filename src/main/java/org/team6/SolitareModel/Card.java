
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
package org.team6.SolitareModel;

import javafx.scene.image.Image;

/**
 * Class representing a single card that can be used in any standard card game
 */
public class Card {
    /** Enum representing the suit of the .card (clubs,spades,diamonds,hearts) */
    private Suit suit;
    /** Integer value representing the value on the card with 1 being ace and 13 being King */
    private int value;
    /** String representing the color of the card, red or black */
    private String color;
    /** Boolean representing whether the card is face up or face down */
    private boolean isFaceUp;

    private Image associatedImage;
    private Image cardBack;


    /**
     * Creates a card given information about the suit and value
     * @param value The value of the card being created
     * @param suit the suit of the card being created
     */
    public Card(int value, Suit suit){
        this.suit = suit;
        this.value = value;
        if(suit.equals(suit.SPADE) || suit.equals(suit.CLUB))
            this.color = "black";
        else
            this.color = "red";
        this.isFaceUp = false;
        associatedImage = new Image(getClass().getResourceAsStream("/" + getValue() + "of" + getSuitAsString() +".png"));
        cardBack = new Image(getClass().getResourceAsStream("/CardBack.png"));
    }

    /**
     * Returns the image file representing the Card if it is face up or the back of the card
     * if it is face down
     * @return associatedImage or CardBack
     */
    public Image getAssociatedImage(){
        if(isFaceUp){
            return this.associatedImage;
        }
        return this.cardBack;
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
    public boolean getIsFaceUp(){
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
     * Returns the suit of the card
     * @return The suit of the card
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * returns The suit of the card as a String
     * @return A String representing the suit of the card
     */
    public String getSuitAsString(){
        switch(suit){
            case CLUB:
                return "Clubs";
            case HEART:
                return "Hearts";
            case DIAMOND:
                return "Diamonds";
            case SPADE:
                return "Spades";
        }
        return "";
    }
}



/** Enum representing the suit of the card (Clubs,Spades,Diamonds,Hearts) */
enum Suit {
    SPADE,
    DIAMOND,
    CLUB,
    HEART
}