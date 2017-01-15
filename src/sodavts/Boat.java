package sodavts;

/**
 * Classe que caracteriza um barco da aplicação.
 *
 * @author Diogo Cruz_150221045 e Diogo Rocha_140275059
 */
public class Boat implements Runnable {

    private String name;
    private Action action;
    private int arrivalTime, actionDuration, buoyWaitTime, bayWaitTime, exitWaitTime;
    private Thread boatT;

    public Boat(String name, int arrivalTime, Action action, int actionDuration) {
        this.name = name;
        this.action = action;
        this.arrivalTime = arrivalTime;
        this.actionDuration = actionDuration;
        this.bayWaitTime = 0;
        this.buoyWaitTime = 0;
        this.exitWaitTime = 0;
        this.boatT = new Thread();
    }

    //Coment this
    public void startThread() {
        boatT.start();
    }

    //Coment this
    @Override
    public void run() {
        //Dependendo da acção chama-se um local, ?? Apagar action? o local é que importa? precisa de saber um local?
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
