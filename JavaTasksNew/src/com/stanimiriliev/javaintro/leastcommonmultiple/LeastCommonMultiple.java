package com.stanimiriliev.chapterone.leastcommonmultiple;
/**
 * This class finds the least common multiple of two integers
 * @author  Stanimir
 * @since   18.7.2017
 */
public class LeastCommonMultiple {

    /**
     * Finds the least common multiple of two integers.
     * @param a -> first integer.
     * @param b -> second integer.
     * @return the least common multiple of a and b.
     */
    public int findLCM(int a, int b){
        for(int i = 1;i <= a * b;i++){
            if(i % a == 0 && i % b == 0){
                return i;
            }
        }
        return -1;// Error
    }
}
