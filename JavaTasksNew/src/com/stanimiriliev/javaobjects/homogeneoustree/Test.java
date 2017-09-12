package com.stanimiriliev.javaobjects.homogeneoustree;

/**
 * Test for homogeneous tree
 * @author Stanimir Iliev
 * @since 19.07.2017
 */
public class Test {
    public static void main(String[] args){
        Tree tree = new Tree(30);
        tree.add(30);
        tree.add(45);
        tree.add(12);
        tree.add(70);
        tree.add(457);
        tree.add(12);
        tree.printElements();
        System.out.println(tree.contains(12));
        System.out.println(tree.contains(14));
    }
}
