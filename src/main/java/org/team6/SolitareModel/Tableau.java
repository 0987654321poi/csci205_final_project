/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: TEAM 6
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
package org.team6.SolitareModel;

import org.team6.SolitareModel.Card;
import org.team6.SolitareModel.Pile;

import java.util.ArrayList;

public class Tableau {
    private ArrayList<Pile> piles;

    /**
     * constructor for the Tableau class
     * creates an ArrayList holding Pile classes
     */
    public Tableau(){
        this.piles = new ArrayList<Pile>();
    }

    /**
     * Getter method for piles
     * @return piles
     */
    public ArrayList<Pile> getPiles(){
        return this.piles;
    }

    /**
     * instantiates an 'numPiles' amount of Pile Classes to append to the Tableau
     */
    public void createPiles(int numPiles) {
        for (int i = 0; i < numPiles; i++) {
            piles.add(new Pile(new ArrayList<Card>()));
        }
    }

    /**
     * fills the referenced pile with the given array list of Cards
     * @param index the indexed position of the pile within the Tableau
     */
    public void fillPile(int index, ArrayList<Card> cards){
        piles.get(index).addCards(cards);
    }

    public Card getTopCardFromPile(int index){
        return piles.get(index).getTopCard();
    }
}

