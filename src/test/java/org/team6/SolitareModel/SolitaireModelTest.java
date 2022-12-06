package org.team6.SolitareModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolitaireModelTest {

    /**
     * The SolitaireModel to be used in our unit tests
     */
    private SolitaireModel model;

    private ArrayList<Card> tempPile;

    @BeforeEach
    void setUp() {
        this.model = new SolitaireModel();
        this.tempPile = new ArrayList<>();
        this.tempPile.add(new Card(9, Suit.HEART));
        this.tempPile.add(new Card(8, Suit.CLUB));
        this.model.setTempPile(tempPile);
    }
    @Test
    void getMoveCounter() {
    }

    @Test
    void getLastMovedFrom() {
    }

    @Test
    void setLastMovedFrom() {
    }

    @Test
    void setSecondClickFalse() {
    }

    @Test
    void setSecondClickTrue() {
    }

    @Test
    void getSecondClick() {
    }

    @Test
    void onMove() {
    }

    @Test
    void draw() {
        int stockSize = this.model.getTheStock().getCards().size();
        assertEquals(stockSize, 24);
        this.model.draw();
        assertEquals(this.model.getTheStock().getCards().size(), stockSize-1);
        assertEquals(this.model.getTheTalon().getCards().size(), 1);

    }

    @Test
    void addToPile() {

    }

    @Test
    void reset() {
    }

    @Test
    void addToPileFree() {
    }

    @Test
    void getTheStock() {
    }

    @Test
    void getTheFoundations() {
    }

    @Test
    void getTheTalon() {
    }

    @Test
    void getTheTab() {
    }

    @Test
    void resetStock() {
    }

    @Test
    void setTempPile() {
        assertEquals(this.tempPile, this.model.getTempPile());
    }

    @Test
    void addToFoundations() {
    }
}