package com.stanimiriliev.chapterone.quicksort;
/**
 * This class sorts array of integers by method "Quick Sort"
 * @author  Stanimir
 * @since   18.7.2017
 */
public class QuickSort {
    private int[] array;

    /**
     * Constructor for the instance of this class
     * @param array -> The array which is being sorted
     */
    public QuickSort(int[] array){
        this.array = array;
    }
    /**
     * Sorts array by quickSort method
     * @param left -> The beginning of the array that is sorted
     * @param right -> The ending of the array that is sorted
     */
    public void sort(int left, int right){
        if(this.array.length == 1 || this.array.length == 0){
            return;
        }
        int i = left, j = right, pivot = this.array[left + (right - left) / 2];
        while(i <= j){
            while(this.array[i] < pivot)
                i++;
            while(this.array[j] > pivot)
                j--;
            if(i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }
        if(left < j)
            sort(left, j);
        if(i < right)
            sort(i, right);
    }

    /**
     * Swap two elements inside the array
     * @param a -> the index of the one element
     * @param b -> the index of the other element
     */
    public void swap(int a, int b){
        int temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;
    }

    /**
     * Prints the array to the console
     */
    public void printArray(){
        System.out.print("[");
        for(int i = 0; i < this.array.length - 1; i++){
            System.out.printf("%d, ", this.array[i]);
        }
        System.out.printf("%d]\n", this.array[this.array.length - 1]);
    }
}
