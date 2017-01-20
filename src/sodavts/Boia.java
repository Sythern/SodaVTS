/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

/**
 *
 * @author Diogo
 */
public class Boia extends Local {

    public Boia(String name, int maxBoats) {
        super(name, maxBoats);
    }

    @Override
    public void approach(Boat boatRef) {
        super.getQueue().add(boatRef);
        System.out.println(boatRef.getName() + " is waiting at: " + getName() + "\n");
    }

    public synchronized int checkOpening(Boat boatRef, int mode) {
        synchronized (this) {
            switch (mode) {
                case 0:
                    int i = 0;
                    int index = getQueue().indexOf(boatRef);
                    int queuePosition;
                    String bStr,
                     boatStr;
                    for (Boat b : getQueue()) {
                        bStr = b.getDestination().getName();
                        boatStr = boatRef.getDestination().getName();
                        queuePosition = getQueue().indexOf(b);
                        if (bStr.equals(boatStr) && queuePosition < index) {
                            i = 1;
                        }
                    }
                    return i;
                case 1:
                    approach(boatRef);
                    break;
                case 2:
                    removeBoat(boatRef);
                    System.out.println(getName() + " is no longer waiting at: " + getName() + "\n");
                    break;
            }
            return 0;
        }
    }
}
