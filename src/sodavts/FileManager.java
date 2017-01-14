/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodavts;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.*;

/**
 *
 * @author dmpcr
 */
public class FileManager {
    
    //TODO ISTO é para ser um singleton
    //TODO Finish this shit not done yet cuz Rocha is a Scrub
    
    public static void readBoatFiles(){
    String fileName = "trafego.txt";

		//read file into stream, try-with-resources
		try(Stream<String> stream = Files.lines(Paths.get(fileName))){
			stream.forEach(System.out::println);

		}catch (IOException e) {
			e.printStackTrace();
		}
                
    }
}
