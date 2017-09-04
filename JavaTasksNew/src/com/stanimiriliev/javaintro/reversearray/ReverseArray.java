package com.stanimiriliev.chapterone.reversearray;

/**
 * This class reverse array of integers
 * @author  Stanimir
 * @since   18.7.2017
 */
public class ReverseArray {
    private int[] array;

    /**
     * Constructor for the new instance of this class
     * @param array -> The array to reverse it
     */
    public ReverseArray(int[] array){
        this.array = array;
    }
    /**
     * Reversing elements of the array
     */
    public void reverse(){
        int i = 0,
                j = this.array.length - 1;
        while(i <= j){
            swap(i, j);
            i++;
            j--;
        }
    }

    /**
     * Swaps two elements in an array
     * @param a -> The index of the first element to swap
     * @param b -> The index of the second element to swap
     */
    public void swap(int a, int b){
        int temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;
    }

    /**
     * Prints the array to the console
     */
    public void print(){
        System.out.print("[");
        for(int i = 0; i < this.array.length - 1; i++){
            System.out.printf("%d, ", this.array[i]);
        }
        System.out.printf("%d]\n", this.array[this.array.length - 1]);
    }
}
