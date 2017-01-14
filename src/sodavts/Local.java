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
    private Queue<Boat> boatQueue;

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
    
    public synchronized void aproach(Boat boatRef) {
        
    }
}