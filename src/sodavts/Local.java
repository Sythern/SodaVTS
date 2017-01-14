/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

/**
 *
 * @author dmpcr
 */
public class Local {
    
    //TODO eveything
    private String name;
    private int boatHistoryCount, currentBoatCount; // não está muito bem feito assim :/ 
    //o current boats podia ser o numero de barcos numa queue...
    // vai ser a classe para todos os locais, incluindo a barra
    public Local(String name){
        this.name = name;
        boatHistoryCount = 0;
        currentBoatCount = 0;
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

    public int getCurrentBoatCount() {
        return currentBoatCount;
    }

    public void setCurrentBoatCount(int currentBoatCount) {
        this.currentBoatCount = currentBoatCount;
    }
    
    // DO eveything here
    
    
}