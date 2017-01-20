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
public class SodaVTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Obtem os barcos
        FileManager fm = FileManager.getInstance();
        ArrayList<Boat> boats = fm.getBoatsFromFile();

        //Inicia os barcos de acordo com a hora de chegada
        for (int i = 0; i < boats.size(); i++) {
            boats.get(i).startThread();
            if (i != boats.size() - 1) {
                try {
                    Thread.sleep((boats.get(i + 1).getArrivalTime() - boats.get(i).getArrivalTime()) * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SodaVTS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        

        /*boats.stream().forEach((ahoy) -> {
            System.out.println(ahoy);
        });*/

    }

}
