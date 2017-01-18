/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.*;

/**
 *
 * @author dmpcr
 */
public final class FileManager {

    private static final FileManager fileManager = new FileManager();
    private final ArrayList<String> boatList;

    private FileManager() {
        boatList = new ArrayList<>();
    }

    public static FileManager getInstance() {
        return fileManager;
    }

    /**
     * Método que lê um ficheiro com informações dos barcos e devolve uma Lista de Barcos
     *
     * @return Lista de Barcos
     */
    public ArrayList<Boat> getBoatsFromFile() {
        //TODO Add correction for empty lines
        ArrayList<Boat> boats = new ArrayList<>();
        readFile();
        for (String str : boatList) {
            String[] splitStr = str.trim().split("\\s+");
            boats.add(new Boat(splitStr[0], convertStringTime(splitStr[1]), Action.getEnum(splitStr[2]), convertStringTime(splitStr[3])));
        }
        return boats;
    }

    /**
     * Método auxiliar que lê o ficheiro com informações dos barcos
     */
    private void readFile() {

        String fileName = "trafego.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            boatList.addAll(stream.collect(Collectors.toList()));

        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método auxiliar que transforma a string com as horas para a escala de tempo da simulação
     *
     * @return tempo convertido
     */
    private int convertStringTime(String time) {

        int[] splitTime = new int[2];
        int i = 0;

        for (String str : time.split("h")) {
            splitTime[i++] = Integer.parseInt(str);
        }

        return ((splitTime[0] * 60) + (splitTime[1])) / 10;
    }
}
