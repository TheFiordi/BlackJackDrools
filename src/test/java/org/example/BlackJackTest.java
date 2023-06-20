
package org.example;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import org.junit.Assert;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class BlackJackTest {
    
    @Test
    public void testGiocatoreHaVinto() {
       Giocatore giocatore = new Giocatore();
        giocatore.riceviCarta(new Carta(Carta.Seme.CUORI, 10));
        giocatore.riceviCarta(new Carta(Carta.Seme.FIORI, 11));

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();

        kSession.insert(giocatore);
        int numeroRegoleEseguite = kSession.fireAllRules();

        Assert.assertEquals(21, giocatore.getPunteggio()); 
        Assert.assertEquals(1, numeroRegoleEseguite);
    }

     @Test
    public void testGiocatoreHaPerso() {
    	  Giocatore giocatore = new Giocatore();
        giocatore.riceviCarta(new Carta(Carta.Seme.CUORI, 10));
        giocatore.riceviCarta(new Carta(Carta.Seme.FIORI, 11));
        giocatore.riceviCarta(new Carta(Carta.Seme.PICCHE, 2));

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();

        kSession.insert(giocatore);
        int numeroRegoleEseguite = kSession.fireAllRules();

        Assert.assertEquals(23, giocatore.getPunteggio());
        Assert.assertEquals(1, numeroRegoleEseguite);
    } 

     @Test
     public void testCasaHaPerso() {
         Casa casa = new Casa();
         casa.riceviCarta(new Carta(Carta.Seme.CUORI, 10));
         casa.riceviCarta(new Carta(Carta.Seme.FIORI, 10));
         casa.riceviCarta(new Carta(Carta.Seme.PICCHE, 2));

         KieServices ks = KieServices.Factory.get();
         KieContainer kContainer = ks.getKieClasspathContainer();
         KieSession kSession = kContainer.newKieSession();

         kSession.insert(casa);
         int numeroRegoleEseguite = kSession.fireAllRules();

         Assert.assertEquals(22, casa.getPunteggio());
         Assert.assertEquals(1, numeroRegoleEseguite);
     }

     @Test
     public void testCasaHaVinto() {
         Casa casa = new Casa();
         casa.riceviCarta(new Carta(Carta.Seme.CUORI, 10));
         casa.riceviCarta(new Carta(Carta.Seme.FIORI, 9));
         casa.riceviCarta(new Carta(Carta.Seme.PICCHE, 2));

         KieServices ks = KieServices.Factory.get();
         KieContainer kContainer = ks.getKieClasspathContainer();
         KieSession kSession = kContainer.newKieSession();

         kSession.insert(casa);
         int numeroRegoleEseguite = kSession.fireAllRules();

         Assert.assertEquals(21, casa.getPunteggio());
         Assert.assertEquals(1, numeroRegoleEseguite);
     }

    
}