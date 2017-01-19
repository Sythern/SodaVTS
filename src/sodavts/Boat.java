package sodavts;

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
    private int arrivalTime, actionDuration, buoyWaitTime, bayWaitTime, exitWaitTime, ocupied;
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
        this.exitWaitTime = 0;
        this.ocupied = 0;
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

            Bacia checkpoint = (Bacia) mari.getLocal(Action.BACIA.toString());
            if (!checkpoint.isFull()) {
                checkpoint.checkOpening(this, 1);
                int i = 1;
                while (destination.isFull() || i == 1) {
                    i = checkpoint.checkOpening(this, 0);
                }
                checkpoint.checkOpening(this, 2);
                //System.out.println(getName() + " is no longer waiting at: " + checkpoint.getName() + "\n");
                destination.approach(this);
            } else {
                //checkpoint = mari.getLocal("Boia");
                //checkpoint.approach(this);
            }
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

    /*private synchronized int checkOpening(Local checkpoint, int mode) {
        switch (mode) {
            case 0:
                while (checkpoint.getOccupied() == 1) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                checkpoint.setOccupied(1);
                int i = 0;
                int ind = checkpoint.getQueue().indexOf(this);

                for (Boat b : checkpoint.getQueue()) {
                    int p = checkpoint.getQueue().indexOf(b);
                    if (b.getDestination().equals(getDestination()) && p < ind && !b.equals(this)) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
                checkpoint.setOccupied(0);
                notifyAll();
                return i;
            case 1:
                checkpoint.setOccupied(1);
                checkpoint.approach(this);
                checkpoint.setOccupied(0);
                notifyAll();
                break;
            case 2:
                checkpoint.setOccupied(1);
                checkpoint.removeBoat(this);
                checkpoint.setOccupied(0);
                notifyAll();
                break;
        }
        return 0;
    }*/

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

    /**
     * Método que retorna o tempo que o barco fica à espera de sair do estuário.
     *
     * @return tempo que o barco fica à espera de sair do estuário.
     */
    public int getExitWaitTime() {
        return exitWaitTime;
    }

    /**
     * Método que define o tempo que o barco fica à espera de sair do estuário.
     *
     * @param exitWaitTime tempo que o barco fica à espera de sair do estuário.
     */
    public void setExitWaitTime(int exitWaitTime) {
        this.exitWaitTime = exitWaitTime;
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
