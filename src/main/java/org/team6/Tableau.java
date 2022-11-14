/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Kevin Page
 * Section: 9:00
 * Date: 11/11/2022
 * Time: 9:03 AM
 *
 * Project: csci205_final_prject
 * Package: org.team6
 * Class: Tableau
 *
 * Description: Class representing the tableau, the group of piles that make up the bulk of the game
 *
 * *****************************************/
package org.team6;

import java.util.ArrayList;

public class Tableau {
    private ArrayList<Pile> piles;

    /**
     * Constructs a Tableau
     */
    public Tableau(){
        this.piles = new ArrayList<Pile>();
    }

    /**
     * Creates the piles that make up the tableau
     */
    public void createPiles(int numPiles) {
        for (int i = 0; i < numPiles; i++) {
            piles.add(new Pile(new ArrayList<Card>()));
        }
    }

    /**
     * Fills a piles in the tableau given an index
     * @param index the position of the pile within the tableau
     */
    public void fillPile(int index, ArrayList<Card> cards){
        piles.get(index).addCards(cards);
    }
}

