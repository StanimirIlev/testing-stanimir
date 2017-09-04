package com.stanimiriliev.chapterone.reversearray;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ReverseArray myArr = new ReverseArray(array);
        myArr.reverse();
        myArr.print();
    }
}
