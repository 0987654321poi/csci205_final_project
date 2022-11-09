/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Kevin Page
 * Section: 9:00
 * Date: 11/7/2022
 * Time: 9:07 AM
 *
 * Project: csci205_final_prject
 * Package: PACKAGE_NAME
 * Class: org.team6.mainfortesting
 *
 * Description: Class for doing some testing of functionality
 *
 * *****************************************/

package org.team6;

import org.team6.Deck;

import java.util.ArrayList;

public class mainfortesting {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.fillStandardDeck();
        d.shuffle();
        ArrayList<Card> temp = new ArrayList<Card>();
        for(int i = 0; i < 10; i++){
            temp.add(d.draw());
        }
        Pile p = new Pile(temp);
        Pile p2 = new Pile(new ArrayList<Card>());
        p2.addCards(p.split(p.getPile().size()-1));

        System.out.println("PILE 1");
        p.display();
        System.out.println("PILE 2");
        p2.display();
    }
}
