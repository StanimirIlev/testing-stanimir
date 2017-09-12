package com.stanimiriliev.chapterfour.reversetextfile;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 7.7.2017 г..
 */
public class ReversTextFile {
    public static void main(String[] args){
        File file = new File("test.txt");// Creates new instance of the class File
        try{
            Scanner in = new Scanner(file);// Open file via Scanner
            StringBuilder line;// Stores red line
            StringBuilder reverseText = new StringBuilder();// Stores the done text
            while(in.hasNext()) {// Read the file until the end
                line = new StringBuilder(in.nextLine());// Read next line of the text
                reverseText.append(line.reverse() + System.lineSeparator());// Append the red line reversed
                // to the done text
            }
            in.close();// Close Scanner stream
            PrintStream writer = new PrintStream("test.txt");// Creates new instance of the class PrintStream
            writer.print(reverseText.toString());// Write the reversed text to the file
            writer.close();// Close PrintStream stream
        }
        catch(java.io.FileNotFoundException e){
            e.printStackTrace();// Prints detailed information about exception that is occur
        }
    }
}
