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

public class mainfortesting {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.fillStandardDeck();
        d.shuffle();
        for(int i = 0; i < 52; i++){
            d.draw();
        }
    }
}
