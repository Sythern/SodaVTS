/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.io.IOException;
import java.nio.file.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.*;

/**
 *
 * @author dmpcr
 */
public final class FileManager {
    
    //TODO ISTO é para ser um singleton
    //TODO Finish this shit not done yet cuz Rocha is a Scrub
    private static final FileManager fileManager = new FileManager();
    private final ArrayList<String> boatList;
    
    private FileManager(){
        boatList = new ArrayList<>();
    }
    
    public static FileManager getInstace(){
        return fileManager;
    }
    
        public ArrayList<Boat> getBoatsFromFile(){
        ArrayList<Boat> boats = new ArrayList<>();
        readFile();
        for(String str : boatList){
            String[] splitStr = str.trim().split("\\s+");
            boats.add(new Boat(splitStr[0],convertStringTime(splitStr[1]),splitStr[2],convertStringTime(splitStr[3])));
        }
        return null;
    }
    
    private void readFile(){
    String fileName = "trafego.txt";

		try(Stream<String> stream = Files.lines(Paths.get(fileName))){
			boatList.addAll(stream.collect(Collectors.toList()));

		}catch (IOException ex) {
			Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
		}
        
    }
    
    private int convertStringTime(String time){
        
        int[] splitTime = new int[2];
        int i = 0;
        
        for(String str : time.split("h")){
            splitTime[i++] = Integer.parseInt(str);
        }

        return (splitTime[0]*60*60)+(splitTime[1]*60);
    }
}