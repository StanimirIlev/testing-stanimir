package com.stanimiriliev.chapterthree.mylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanimir Iliev on 6.7.2017 y..
 */
public class MyList {
    private int length = 0,// stores how much elements the list has
            size;// stores the set maximum of elements
    private List<Object> list = null;// the list with elements

    /**
     * Creates new instance of this class with set size of the list
     * @param size
     */
    public MyList(int size){
        list = new ArrayList<>(size);// creates instance of the class ArrayList with the specific size
        this.size = size;// stores the size
    }

    /**
     * Adding new element at the end of the list
     * @param element -> the new element
     * @throws IllegalStateException if the list is full
     */
    public void add(Object element){
        if(this.length == this.size){// If the list is full throw exception
            throw new IllegalStateException("The list is already full!");
        }
        this.length++;// else increase the length
        this.list.add(element);// and add the new element
    }

    /**
     * Removes the last element of the list
     * @throws IllegalStateException if the list is empty
     */
    public void remove(){
        if(this.length == 0){// If the list is empty throw exception
            throw new IllegalStateException("Cannot remove item from an empty list!");
        }
        this.list.remove(--length);// else remove the last element from the list and decrease the length
    }

    /**
     * Print all elements to the console
     */
    public void printAllElements(){
        for(int i = 0; i < this.length; i++){// Iterates every element in the list
            System.out.println(this.list.get(i).toString());// Convert it to string and print it to the console
        }
    }
}
