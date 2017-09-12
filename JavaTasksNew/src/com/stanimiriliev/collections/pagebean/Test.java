package com.stanimiriliev.collections.pagebean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Test functionality of class pagebean
 * @author Stanimir Iliev
 * @since 24.07.2017
 */
public class Test {
    public static void main(String[] args){
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        PageBean<Integer> pb = new PageBean<>(myList, 3);
        List<Integer> list;
        Scanner in = new Scanner(System.in);
        while(true){
            String console = in.nextLine();
            switch(console){
                case "n":// next
                    if(pb.hasNext()){
                        list = pb.next();
                        for(int num : list)
                            System.out.println(num);
                        System.out.println("\nPage: " + pb.getCurrentPageNumber());
                    }
                    break;
                case "p":// previous
                    if(pb.hasPrevious()){
                        list = pb.previous();
                        for(int num : list)
                            System.out.println(num);
                        System.out.println("\nPage: " + pb.getCurrentPageNumber());
                    }
                    break;
                case "f":// first page
                    list = pb.firstPage();
                    for(int num : list)
                        System.out.println(num);
                    System.out.println("\nPage: " + pb.getCurrentPageNumber());
                    break;
                case "l":// last page
                    list = pb.lastPage();
                    for(int num : list)
                        System.out.println(num);
                    System.out.println("\nPage: " + pb.getCurrentPageNumber());
                    break;
                case "exit":
                    in.close();
                    return;

            }
        }
    }
}
