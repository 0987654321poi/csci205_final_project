package org.team6.SolitareModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class for our SolitaireModel class. Indirectly tests all other classes in the SolitareModel
 * package because they are used in SolitaireModel
 */
class SolitaireModelTest {

    /**
     * The SolitaireModel to be used in our unit tests
     */
    private SolitaireModel model;

    /**
     * The temp pile that will be made into the model's temp pile
     * used in the setTempPile test
     */
    private ArrayList<Card> tempPile;

    @BeforeEach
    void setUp() {
        this.model = new SolitaireModel();
        this.tempPile = new ArrayList<>();
        this.tempPile.add(new Card(9, Suit.HEART));
        this.tempPile.add(new Card(8, Suit.CLUB));
        this.model.setTempPile(tempPile);
        //Sets the last moved from to a valid index, this would be done in the controller in a real game
        this.model.setLastMovedFrom(0);
    }

    /**
     * Tests the get move counter by drawing a card and ensuring that the move counter did indeed
     * increment by one
     */
    @Test
    void getMoveCounter() {
        assertEquals(this.model.getMoveCounter(), 0);
        this.model.draw();
        assertEquals(this.model.getMoveCounter(), 1);
    }

    /**
     * Tests that draw functionality to ensure that after drawing a card the stocksize goes down by one
     * and the talon size increase by one
     */
    @Test
    void draw() {
        int stockSize = this.model.getTheStock().getCards().size();
        assertEquals(stockSize, 24);
        this.model.draw();
        assertEquals(this.model.getTheStock().getCards().size(), stockSize-1);
        assertEquals(this.model.getTheTalon().getCards().size(), 1);

    }

    /**
     * Tests the add to pile functionality by finding the first tableau pile that does not have
     */
    @Test
    void addToPile() {
        //Ensures that the assertion actually is checked, should always be checked, because
        //at least one pile should not have an ace as its top card
        boolean checked = false;
        //We will create c to be a card that can be added to a given pile based on solitaire rules
        Card c;
        //Run through the top card in each tableau pile and see if we can add to it
        //Don't go to the first(0th index) pile because lastMovedFrom is set to 0
        for (int i = 1; i < 7; i++) {
            //Top card in the i+1th pile
            Card topCardInPile = this.model.getTheTab().getPiles().get(i).getTopCard();
            int topCardValue = topCardInPile.getIntValue();
            String topCardColor = topCardInPile.getColor();

            //If the top card is not an ace we will try to add a card to it
            //If it is, an ace we can't add anything to it because thats how solitaire works
            if( topCardValue!= 1){
                //Create a card that is one value less than the topcard in the pile and a
                //different color so that it can be added to the pile by solitaire rules
                if(topCardColor.equals("black")) {
                    c = new Card(topCardValue - 1, Suit.HEART);
                }
                else{
                    c = new Card(topCardValue -1, Suit.CLUB);
                }
                //Make the card face up and then try to add it to the pile, the pile should end up with
                //one more card than it had before
                c.flip();
                ArrayList<Card> cardToBeAdded = new ArrayList<>();
                cardToBeAdded.add(c);
                int currPileSize = this.model.getTheTab().getPiles().get(i).getPile().size();
                assertEquals(currPileSize, i+1);
                this.model.setTempPile(cardToBeAdded);
                this.model.addToPile(i);
                currPileSize = this.model.getTheTab().getPiles().get(i).getPile().size();
                assertEquals(currPileSize, i+2);

                //Try to add the same card again, this should fail
                this.model.addToPile(i);
                currPileSize = this.model.getTheTab().getPiles().get(i).getPile().size();
                assertEquals(currPileSize, i+2);
                checked = true;
                break;
            }
        }
        //Make sure the add test actually ran
        assertTrue(checked);
    }

    /**
     * Check the addToPileFree method by adding a random pile to  one of the tableau piles
     * this should end up adding the cards regardless of whether they follow the rules or not
     */
    @Test
    void addToPileFree() {
        this.model.addToPileFree(6);
        //Get the size of the array of cards in the seventh pile object in the tableau
        //ie the pile object at index 6
        int pileSevenLength = this.model.getTheTab().getPiles().get(6).getPile().size();
        //tempPile has two cards so after adding it to pile 7, pile 7 should have 9 cards
        assertEquals(pileSevenLength, 9);
    }


    /**
     * Draws all cards from the stock and checks that after resetting the stock it is back to its initial
     * length and the topCard is what it was before drawing
     */
    @Test
    void resetStock() {
        Card topCard = this.model.getTheStock().getTopCard();
        for (int i = 0; i < 24; i++) {
            this.model.draw();
        }
        assertEquals(this.model.getTheStock().getCards().size(), 0);
        this.model.resetStock();
        assertEquals(this.model.getTheStock().getCards().size(), 24);
        assertEquals(this.model.getTheStock().getTopCard(), topCard);
    }

    /**
     * Simple test for the setTempPile method
     */
    @Test
    void setTempPile() {
        assertEquals(this.tempPile, this.model.getTempPile());
    }

    /**
     * Test for the addToFoundation method that first tries to add an ace of hearts to an empty foundation
     * which should work and then tries to add another card which should not get added
     */
    @Test
    void addToFoundations() {
        Card topHeart = this.model.getTheFoundations().getTopHeart();
        assertEquals(topHeart, null);
        System.out.println(tempPile);

        this.model.addToFoundations();
        topHeart = this.model.getTheFoundations().getTopHeart();
        //The top card in temp pile is not an ace of hearts so it should not be added to the foundation
        assertEquals(topHeart, null);

        //Try adding the ace of hearts to the foundation, should be able to be added

        //Make an ace of hearts
        Card aceHeart = new Card(1, Suit.HEART);
        ArrayList<Card> aceHeartList = new ArrayList<>();
        aceHeartList.add(aceHeart);
        //Add the ace of hearts to the tempPile which is the pile that is selected
        this.model.setTempPile(aceHeartList);
        //Add to foundation attempts to add tempPile to foundations
        this.model.addToFoundations();
        topHeart = this.model.getTheFoundations().getTopHeart();
        //The top card in the heart foundation should now be the ace of hearts
        assertEquals(topHeart, aceHeart);


    }
}