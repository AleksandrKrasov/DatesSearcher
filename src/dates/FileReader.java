/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Саня
 */
public class FileReader {
    
    private String text;

    public FileReader(File file) throws FileNotFoundException {
        readFile(file);
    }
    
    private void readFile(File file) throws FileNotFoundException{
        Scanner scn = new Scanner(file);
        text = "";
        while(scn.hasNext())
            text = text + scn.next() + " ";
    }

    public String getText() {
        return text;
    }
}
