package com.stanimiriliev.javaintro.arraysettings;

/**
 * Class for modifying array of integers
 * @author  Stanimir
 * @since   18.7.2017
 */
public class ArraySettings {
    private int[] array;

    /**
     * Constructor for the new instance of this class
     * @param array -> The array to modify
     */
    public ArraySettings(int[] array){
        if(array.length == 0)
            throw new IllegalArgumentException("This array is empty");
        this.array = array;
    }
    /**
     * Gets the minimal element of an array
     * @return the smallest element of an array
     */
    public int getMinElement(){
        int minValue = Integer.MAX_VALUE;
        for(int number : this.array){
            if(number < minValue){
                minValue = number;
            }
        }
        return minValue;
    }

    /**
     * Sum all elements of an array
     * @return the sum of all elements in the array
     */
    public int getSum(){
        int sum = 0;
        for(int number : this.array){
            sum += number;
        }
        return sum;
    }

    /**
     * Prints the array
     */
    public void printArray(){
        System.out.print("[");
        for(int i = 0; i < this.array.length; i++){
            if(i < this.array.length - 1){
                System.out.printf("%d, ", this.array[i]);//                                                              with comma
                continue;
            }
            System.out.printf("%d]\n", this.array[i]);
        }
    }
}
