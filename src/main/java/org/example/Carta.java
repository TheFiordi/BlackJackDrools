

package org.example;

import java.util.ArrayList;
import java.util.Collections;


public class Carta {
    public enum Seme {
        CUORI, QUADRI, FIORI, PICCHE
    }

    private Seme seme;
    private int valore;

    public Carta(Seme seme, int valore) {
        this.seme = seme;
        this.valore = valore;
    }

    public Seme getSeme() {
        return seme;
    }

    public int getValore() {
        return valore;
    }
}