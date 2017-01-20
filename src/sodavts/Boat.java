package sodavts;

import static java.lang.Math.toIntExact;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que caracteriza um barco da aplicação.
 *
 * @author Diogo Cruz_150221045 e Diogo Rocha_140275059
 */
public class Boat implements Runnable {

    private String name;
    private Action action;
    private int arrivalTime, actionDuration, buoyWaitTime, bayWaitTime;
    private Thread boatT;
    private Maritime mari;
    private Local destination;

    public Boat(String name, int arrivalTime, Action action, int actionDuration) {
        this.name = name;
        this.action = action;
        this.arrivalTime = arrivalTime;
        this.actionDuration = actionDuration;
        this.bayWaitTime = 0;
        this.buoyWaitTime = 0;
        this.boatT = new Thread(this, name);
        this.mari = Maritime.getInstance();
        this.destination = mari.getLocal(action.toString());
    }

    /**
     * Método que ....
     *
     */
    public void startThread() {
        boatT.start();
    }

    /**
     * Método que ....
     *
     */
    @Override
    public void run() {
        //Dependendo da acção chama-se um local
        //Criar uma classe com o map onde os barcos podem pedir a localização do destino
        if (destination.isFull()) {
            enterBacia();
        } else {
            destination.approach(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thread getBoatT() {
        return boatT;
    }

    public Local getDestination() {
        return destination;
    }

    /**
     * Método que retorna a hora de início da ação de um barco.
     *
     * @return hora de inicio da ação do barco.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Método que define a hora de início da ação de um barco.
     *
     * @param arrivalTime hora de inicio da ação do barco.
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Método que retorna o tempo que um barco vai efetuar a sua ação.
     *
     * @return o tempo que o barco vai efetuar a ação.
     */
    public int getActionDuration() {
        return actionDuration;
    }

    /**
     * Método que define o tempo que um barco vai efetuar a sua ação.
     *
     * @param actionDuration o tempo que um barco vai efetuar a sua ação.
     */
    public void setActionDuration(int actionDuration) {
        this.actionDuration = actionDuration;
    }

    /**
     * Método retorna o tempo que um barco fica à espera na boia.
     *
     * @return tempo que o barco fica à espera na boia.
     */
    public int getBuoyWaitTime() {
        return buoyWaitTime;
    }

    /**
     * Método que define o tempo que um barco fica à espera na boia.
     *
     * @param buoyWaitTime tempo que o barco fica à espera na boia.
     */
    public void setBuoyWaitTime(int buoyWaitTime) {
        this.buoyWaitTime = buoyWaitTime;
    }

    /**
     * Método que retorna o tempo que o barco fica à espera na bacia.
     *
     * @return tempo que o barco fica a espera na bacia.
     */
    public int getBayWaitTime() {
        return bayWaitTime;
    }

    /**
     * Método que define o tempo que o barco fica à espera na bacia.
     *
     * @param bayWaitTime tempo que o barco fica à espera na bacia.
     */
    public void setBayWaitTime(int bayWaitTime) {
        this.bayWaitTime = bayWaitTime;
    }

    private boolean enterBacia() {
        Long begin, end;
        Bacia checkpoint = (Bacia) mari.getLocal(Action.BACIA.toString());
        Local barra = mari.getLocal("Barra");
        if (!checkpoint.isFull()) {
            barra.approach(this);
            checkpoint.checkOpening(this, 1);
            begin = System.currentTimeMillis();
            int i = 1;
            while (destination.isFull() || i == 1) {
                i = checkpoint.checkOpening(this, 0);
                if (i == 1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            checkpoint.checkOpening(this, 2);
            end = System.currentTimeMillis();
            bayWaitTime = toIntExact((end-begin)/1000);
            destination.approach(this);
        } else {
            enterBoia();
            return false;
        }
        return true;
    }

    private boolean enterBoia() {
        Long begin, end;
        Boia checkpointB = (Boia) mari.getLocal("Boia");
        Bacia checkpoint = (Bacia) mari.getLocal(Action.BACIA.toString());
        checkpointB.checkOpening(this, 1);
        begin = System.currentTimeMillis();
        int i = 1;
        while (checkpoint.isFull() || i == 1) {
            i = checkpointB.checkOpening(this, 0);
            if (i == 1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        checkpointB.checkOpening(this, 2);
        end = System.currentTimeMillis();
        buoyWaitTime = toIntExact((end-begin)/1000);
        enterBacia();
        return true;
    }

    /**
     * Método que retorna uma string com a descrição do barco
     *
     * @return string com a descrição
     */
    @Override
    public String toString() {
        return "\nNome: " + name + " Acção: " + action + " Chegada: " + arrivalTime + " Duração: " + actionDuration;
    }
}
