

package org.example;

import java.util.ArrayList;
import java.util.Collections;



public class Mazzo {
    private ArrayList<Carta> carte;

    public Mazzo() {
        carte = new ArrayList<>();
        for(Carta.Seme s : Carta.Seme.values()) {
            for(int v = 1; v <= 13; v++) {
                carte.add(new Carta(s, v));
            }
        }
        Collections.shuffle(carte);
    }

    public Carta pesca() {
        return carte.remove(carte.size() - 1);
    }
}