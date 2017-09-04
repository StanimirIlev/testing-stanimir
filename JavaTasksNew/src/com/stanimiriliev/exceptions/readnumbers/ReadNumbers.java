package com.stanimiriliev.chapterthree.readnumbers;

import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 6.7.2017 y..
 */

public class ReadNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);// Creating instance of the class Scanner
        System.out.println("Enter the lower bound of the range: ");
        int lowerBound = input.nextInt();// Reads the lower bound from the console
        System.out.println("Enter the upper bound of the range: ");
        int upperBound = input.nextInt();// Reads the upper bound from the console
        while(true){// Infinity loop so the program loops until the user types 'quit'
            String console = null;
            System.out.println("Enter number in range: ");
            try{
                console = input.next();// Read from the console
                int num = Integer.parseInt(console);// try to parse it in num
                if(num < lowerBound || num > upperBound){// if the num is out of range throw exception
                    throw new IndexOutOfBoundsException("The number is out of range!");
                }
            }
            catch(NumberFormatException e){// if the input is not valid number
                if(console.toLowerCase().equals("quit")){// if the input is quit
                    break;// quit
                }
                else
                    System.out.println("Invalid numbers!");// if the input is invalid number and is not quit
            }
        }
    }
}
