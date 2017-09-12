package com.stanimiriliev.chapterone.greatestcommondivisor;

import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        while(true){
            try{
                System.out.print("\tFind greatest common divisor\nEnter first number: ");
                int a = Integer.parseInt(in.nextLine());
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(in.nextLine());
                System.out.printf("The greatest common divisor of " +
                        "%d and %d is %d", a, b, gcd.findGCD(a, b));
                in.close();
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. You must enter an integer.");
            }
        }
    }
}
