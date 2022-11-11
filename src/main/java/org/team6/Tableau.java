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
    private GameType gameType;
    private ArrayList<Pile> piles;

    /**
     * Constructs a Tableau
     * @param gt sets the private variable for the type of game, as this will impact how many
     *          cards go in the tableau
     */
    public Tableau(GameType gt){
        this.gameType = gt;
    }

    /**
     * Creates the piles that make up the tableau
     */
    public void createPiles(Deck d) {
        if(this.gameType.equals(GameType.CLASSIC)) {
            for (int i = 0; i < 7; i++) {
                piles.add(new Pile(new ArrayList<Card>()));
            }
            int limit = 1;
            for (Pile p : this.piles) {
                for (int i = 0; i < 1; i++) {
                    p.addCard(d.draw());
                }
                limit++;
            }
        }
    }
}

enum GameType{
    CLASSIC
}

