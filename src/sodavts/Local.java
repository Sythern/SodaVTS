/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.util.*;

/**
 *
 * @author dmpcr
 */
public class Local {
    
    private String name;
    private int boatHistoryCount;
    private Queue<Boat> boatQueue; // isto serve para ver se estar um barco no local ou não, para não chamar o metodo aproach

    public Local(String name){
        this.name = name;
        boatHistoryCount = 0;
        boatQueue = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getBoatHistoryCount() {
        return boatHistoryCount;
    }

    public void setBoatHistoryCount(int boatHistoryCount) {
        this.boatHistoryCount = boatHistoryCount;
    }

    public Queue getQueueA() {
        return boatQueue;
    }
    
    /**
     * Método que faz a gestão das threads (barcos) quando estes entram
     * @param boatRef Referencia da thread
     */
    public synchronized void approach(Boat boatRef) {
        
    }
}