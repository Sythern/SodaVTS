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
public class Mar extends Local {
    
    private Maritime mari;

    public Mar(String name, int maxBoats) {
        super(name, maxBoats);
        mari = Maritime.getInstance();
    }

    @Override
    public void approach(Boat boatRef) {
        try {
            System.out.println(boatRef.getName() + " just started trip to: " + getName() + "\n");
            super.addBoat(boatRef);
            Thread.sleep(boatRef.getActionDuration() * 1000);
            Local barra = mari.getLocal("Barra");
            barra.approach(boatRef);
            super.removeBoat(boatRef);
        } catch (InterruptedException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(boatRef.getName() + " just go to: " + getName() + "\n");
    }
}
