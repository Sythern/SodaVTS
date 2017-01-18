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
public class Terminal extends Local {

    public Terminal(String name, int maxBoats) {
        super(name, maxBoats);
    }

    @Override
    public synchronized void approach(Boat boatRef) {
        try {
            System.out.println(boatRef.getName() + " Enter");
            wait(boatRef.getActionDuration() * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(boatRef.getName() + " Exit");
    }
}
