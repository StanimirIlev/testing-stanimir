package com.stanimiriliev.chapterfour.reader;

import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 6.7.2017 y..
 */
public class Reader {

     // All methods are static in order to use this class without an instance of it


    /**
     * Reads string from the console
     * @return string from the console
     */
    public static String readString(){
        Scanner in = new Scanner(System.in);// Creates new instance of the class Scanner
        String result = in.nextLine();// reads the next line
        in.close();// Close the Scanner stream
        return result;// Returns the result
    }

    /**
     * Reads integer from the console
     * @return integer from the console
     * @exception NumberFormatException if the user does not enter a valid integer
     */
    public static int readInt(){
        Scanner in = new Scanner(System.in);// Creates new instance of the class Scanner
        int result = in.nextInt();// Read integer from the console
        in.close();// Close the Scanner stream
        return result;// return the result
    }

    /**
     * Reads char from the console
     * @return char from the console
     */
    public static char readChar(){
        Scanner in = new Scanner(System.in);// Creates instance of the class Scanner
        String result = in.nextLine();// Read the next line
        in.close();// Close the Scanner stream
        return result.charAt(0);// Return only the first char from the whole string
    }

    /**
     * Reads float from the console
     * @return float from the console
     * @exception NumberFormatException if the user does not enter a valid float, for example if contains letters
     */
    public static float readFloat(){
        Scanner in = new Scanner(System.in);// Creates instance of the class Scanner
        String console = in.nextLine();// Read the next line
        in.close();// Close the Scanner stream
        console = console.replace(',', '.');// In order to avoid NumberFormatException if the user
        // uses comma instead of a point
        return Float.parseFloat(console);// Parse the string to float and return it
    }
}
