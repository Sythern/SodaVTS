/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmpcr
 */
public abstract class Local {

    private String name;
    private int boatHistoryCount, maxBoats;
    private ArrayList<Boat> boatQueue; // isto serve para ver se estar um barco no local ou não, para não chamar o metodo aproach

    public Local(String name, int maxBoats) {
        this.name = name;
        boatHistoryCount = 0;
        this.maxBoats = maxBoats;
        boatQueue = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setMaxBoats(int maxBoats) {
        this.maxBoats = maxBoats;
    }

    public int getBoatHistoryCount() {
        return boatHistoryCount;
    }

    public void setBoatHistoryCount(int boatHistoryCount) {
        this.boatHistoryCount = boatHistoryCount;
    }

    //Try not to use this
    public ArrayList<Boat> getQueue() {
        return boatQueue;
    }

    public boolean isFull() {
        if (maxBoats == -1) {
            return false;
        }
        return boatQueue.size() >= maxBoats;
    }

    /**
     * Método que faz a gestão das threads (barcos) quando estes entram
     *
     * @param boatRef Referencia da thread
     */
    public abstract void approach(Boat boatRef);
}
