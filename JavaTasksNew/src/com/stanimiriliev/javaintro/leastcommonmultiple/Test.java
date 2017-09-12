package com.stanimiriliev.chapterone.leastcommonmultiple;

import java.util.Scanner;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LeastCommonMultiple lcm = new LeastCommonMultiple();
        while(true){
            try{
                System.out.print("\tFind least common multiple\nEnter first number: ");
                int a = Integer.parseInt(in.nextLine());
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(in.nextLine());
                System.out.printf("The least common multiple of " +
                        "%d and %d is %d", a, b, lcm.findLCM(a, b));
                in.close();
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. You must enter an integer.");
            }
        }
    }
}
