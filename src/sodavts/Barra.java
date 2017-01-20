/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo
 */
public class Barra extends Local {

    public Barra(String name, int maxBoats) {
        super(name, maxBoats);
    }

    @Override
    public synchronized void approach(Boat boatRef) {
        try {
            super.addBoat(boatRef);
            Thread.sleep(1000);
            super.removeBoat(boatRef);
        } catch (InterruptedException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
