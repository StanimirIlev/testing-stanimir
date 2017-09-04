package com.stanimiriliev.javaobjects.sumator;
/**
 * Created by Stanimir Iliev on 16.6.2017 y..
 */

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sumator {
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static int sum(int a, int b){
        return a + b;
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static double sum(double a, double b){
        return a + b;
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @throws NumberFormatException when one of the strings does not contain a valid integers
     * @return the sum of the two numbers
     */
    public static int sum(String a, String b) throws NumberFormatException{
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static BigInteger sum(BigInteger a, BigInteger b){
        return a.add(b);
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static BigDecimal sum(BigDecimal a, BigDecimal b){
        return a.add(b);
    }
}
