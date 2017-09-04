package com.stanimiriliev.chapterfour.writetextfile;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * Created by Stanimir Iliev on 7.7.2017 y..
 */
public class WriteTextFile {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);// Creates new instance of the class Scanner
        System.out.println("Enter the name of the text file you want to write text:");
        String fileName = in.nextLine();// Stores the file name
        try{
            PrintStream writer = new PrintStream(fileName);// Creates new instance of the class PrintStream
            System.out.println("Write the text file.");
            while(true){// Infinity loop so the program will loop until the user enters a dot on a new line
                String line = in.nextLine();// Read the next line from the console
                if(line.equals("."))// If the red line contains only dot, breaks the loop
                    break;
                writer.println(line);// Write the red line to the text file
            }
            in.close();// Close the Scanner stream
            writer.close();// Close the PrintStream stream
        }
        catch(java.io.FileNotFoundException e){
            e.printStackTrace();// Prints detailed information about the exception that is occur
        }
    }
}
