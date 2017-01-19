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
public class Bacia extends Local {

    public Bacia(String name, int maxBoats) {
        super(name, maxBoats);
    }

    @Override
    public void approach(Boat boatRef) {
        //recebo meto em pausa e vou vendo todos
        //se há um barco a ir para o mesmo sitio com uma prioridade maior
        super.getQueue().add(boatRef);
        System.out.println(boatRef.getName() + " waiting at: " + getName() + "\n");
    }

    public synchronized int checkOpening(Boat boatRef, int mode) {
        switch (mode) {
            case 0:
                int i = 1;
                int ind = getQueue().indexOf(boatRef);
                
                //FIX THIS
                for (Boat b : getQueue()) {
                    
                    int queuePosition = getQueue().indexOf(b);
                    if (!(b.getDestination().equals(boatRef.getDestination()) && queuePosition < ind && !b.equals(boatRef))) {
                        i = 0;
                    }
                }
                return i;
            case 1:
                approach(boatRef);
                break;
            case 2:
                removeBoat(boatRef);
                break;
        }
        return 0;
    }
}
