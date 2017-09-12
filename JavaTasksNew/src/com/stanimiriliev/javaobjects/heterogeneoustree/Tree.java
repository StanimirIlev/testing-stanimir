package com.stanimiriliev.javaobjects.heterogeneoustree;

/**
 * Heterogeneous tree
 * @author      Stanimir Iliev
 * @since       22.06.2017
 */
import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>>{

    class Node{

        public final T value;
        public Node left;
        public Node right;


        Node(T value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    private final Node root;

    public Tree(T root){
        this.root = new Node(root);
    }

    public void add(T element){
        add(this.root, element);
    }

    private void add(Node root, T element){
        if(element.compareTo(root.value) < 0){
            if(root.left == null)
                root.left = new Node(element);
            else
                add(root.left, element);
        }
        else if(element.compareTo(root.value) > 0) {
            if(root.right == null)
                root.right = new Node(element);
            else
                add(root.right, element);
        }
        else
            throw new IllegalArgumentException("Duplicating keys");
    }

    public T getElement(T element){
        return getElement(this.root, element);
    }
    private T getElement(Node root, T element){
        if(element.compareTo(root.value) == 0)
            return root.value;
        else if(element.compareTo(root.value) < 0) {
            if (root.left != null)
                return getElement(root.left, element);
            else
                return null;//There is no such a element
        }
        else{
            if (this.root.right != null)
                return getElement(root.right, element);
            else
                return null;//There is no such a element
        }
    }
}