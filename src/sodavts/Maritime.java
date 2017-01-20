/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dmpcr
 */
public final class Maritime {

    private static final Maritime mrtm = new Maritime();
    private final Map<String, Local> sodaMap;

    private Maritime() {
        sodaMap = new HashMap<>();
        inicializeMap();
    }

    public static Maritime getInstance() {
        return mrtm;
    }

    private void inicializeMap() {
        //Todos os locais existentes no rio
        sodaMap.put("Boia", new Boia("Boia", -1));
        sodaMap.put("Barra", new Barra("Barra", 1));
        for (Action act : Action.values()) {
            switch (act.toString()) {
                case "Marina":
                    sodaMap.put(act.toString(), new Marina(act.toString(), -1));
                    break;
                case "Passeio":
                    sodaMap.put(act.toString(), new Passeio(act.toString(), -1));
                    break;
                case "Mar":
                    sodaMap.put(act.toString(), new Mar(act.toString(), -1));
                    break;
                case "TerminalC":
                case "TerminalQ":
                case "TerminalP":
                    sodaMap.put(act.toString(), new Terminal(act.toString(), 1));
                    break;
                case "Bacia":
                    sodaMap.put(act.toString(), new Bacia(act.toString(), 3));
                    break;
                default:
                    throw new IllegalArgumentException("Esse Local não existe");
            }
        }
    }

    public Map<String, Local> getSodaMap() {
        return sodaMap;
    }

    public Local getLocal(String local) {
        return sodaMap.get(local);
    }
}
