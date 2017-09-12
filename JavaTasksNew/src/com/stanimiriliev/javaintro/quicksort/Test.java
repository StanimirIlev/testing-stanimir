package com.stanimiriliev.chapterone.quicksort;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        int[] array = new int[] {5, 8, 6, 4, 2, 3, 7, 5, 6, 2, 1, 5, 9, 34};
        QuickSort myArr = new QuickSort(array);
        myArr.sort(0, array.length - 1);
        myArr.printArray();
    }
}
