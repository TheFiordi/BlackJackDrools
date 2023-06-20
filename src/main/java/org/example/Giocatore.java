
package org.example;

import java.util.ArrayList;
import java.util.Collections;



public class Giocatore {
    private ArrayList<Carta> mano;
    public int punteggio;

    public Giocatore() {
        mano = new ArrayList<>();
        punteggio = 0;
    }

    public void riceviCarta(Carta carta) {
        mano.add(carta);
        punteggio += carta.getValore();
    }

    public int getPunteggio() {
        return punteggio;
    }
}