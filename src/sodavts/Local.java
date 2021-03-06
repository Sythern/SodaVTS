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
public abstract class Local {

    private String name;
    private int boatHistoryCount, maxBoats;
    private int occupied;
    private ArrayList<Boat> boatQueue; // isto serve para ver se estar um barco no local ou não, para não chamar o metodo aproach

    public Local(String name, int maxBoats) {
        this.name = name;
        boatHistoryCount = 0;
        this.occupied = 0;
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

    public int getOccupied() {
        return occupied;
    }

    public synchronized void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public synchronized void addOccupied(int occupied) {
        this.occupied += occupied;
    }

    public ArrayList<Boat> getQueue() {
        return boatQueue;
    }

    public synchronized void addBoat(Boat boat) {
        boatQueue.add(boat);
        boatHistoryCount++;
    }

    public synchronized void removeBoat(Boat boat) {
        boatQueue.remove(boat);
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
