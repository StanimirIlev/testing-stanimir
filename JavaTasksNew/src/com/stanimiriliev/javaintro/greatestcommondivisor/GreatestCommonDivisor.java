package com.stanimiriliev.chapterone.greatestcommondivisor;
/**
 * The GreatestCommonDivisor class is used to find
 * the greatest common divisor of two numbers
 * @author  Stanimir Iliev
 * @since   18.7.2017
 */

public class GreatestCommonDivisor {
    /**
     * Finds the greatest common divisor of two integers.
     * @param a -> first integer.
     * @param b -> second integer.
     * @return the greatest common divisor of a and b.
    */
    public int findGCD(int a, int b){
        int gcd = 1;
        int smaller = a < b ? a : b;
        for(int i = 2; i <= smaller; i++){
            if(a % i == 0 && b % i == 0 && i > gcd){
                gcd = i;
            }
        }
        return gcd;
    }
}
