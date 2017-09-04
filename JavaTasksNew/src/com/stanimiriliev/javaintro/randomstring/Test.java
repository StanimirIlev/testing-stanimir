package com.stanimiriliev.chapterone.randomstring;

import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        RandomString rndStr = new RandomString();
        while(true){
            System.out.print("\tRandom string generator\nEnter the length of the string: ");
            try{
                int length = Integer.parseInt(in.nextLine());
                System.out.println(rndStr.randomString(length));
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. You must enter a integer.");
            }
        }
        in.close();
    }
}
