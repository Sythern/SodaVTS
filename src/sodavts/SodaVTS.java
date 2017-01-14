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
public class SodaVTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Aqui fica a criação dos barcos e a gestão dos barcos que 
        // estão na bacia e os que entram primeiro
        
        //Obtem os barcos
        FileManager fm = FileManager.getInstace();
        ArrayList<Boat> boats = fm.getBoatsFromFile();
        
        //Todos os locais existentes no rio
        Map<String, Local> sodaMap = new HashMap<>();
        sodaMap.put("Barra", new Local("Barra"));
        for(Action act : Action.values()){
            sodaMap.put(act.toString(), new Local(act.toString()));
        }

        boats.stream().forEach((ahoy) -> {
            System.out.println(ahoy);
        });
    }
    
}
