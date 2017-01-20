/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import static java.lang.Math.toIntExact;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo
 */
public class Terminal extends Local {

    private long begin, end;
    private Maritime mari;

    public Terminal(String name, int maxBoats) {
        super(name, maxBoats);
        mari = Maritime.getInstance();
        begin = 0;
        end = 0;
    }

    @Override
    public synchronized void approach(Boat boatRef) {
        try {
            System.out.println(boatRef.getName() + " docked at: " + getName() + "\n");
            super.addBoat(boatRef);
            wait(boatRef.getActionDuration() * 1000);
            Local barra = mari.getLocal("Barra");
            begin = System.currentTimeMillis();
            barra.approach(boatRef);
            end = System.currentTimeMillis();
            this.addOccupied(toIntExact((end-begin)/1000));
            super.removeBoat(boatRef);
        } catch (InterruptedException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(boatRef.getName() + " undoked from: " + getName() + "\n");
    }
}
