package com.stanimiriliev.javaobjects.homogeneoustree;

/**
 * Binary Ordered Tree, Homogeneous Tree
 * @author  Stanimir
 * @since 18.6.2017
 */
public class Tree {

    private Node root;

    /**
     * Constructor for the new instance of this class
     */
    public Tree(int root) {
        this.root = new Node(root);
    }

    /**
     * Finds if the tree contains this element
     * Calls the next contains method
     * @param element -> The element to search for
     * @return true if the element is found and false if it is not
     */
    public boolean contains(int element) {
        return contains(this.root, element);
    }
    /**
     * Finds if the tree contains this element
     * @param element -> The element to search for
     * @param root -> In which node to search for
     * @return true if the element is found and false if it is not
     */
    public boolean contains(Node root, int element) {
        if(element == root.getValue())
            return true;
        else if(element < root.getValue()) {
            if(root.getLeft() != null)
                return contains(root.getLeft(), element);
            else
                return false;
        }
        else {
            if(root.getRight() != null)
                return contains(root.getRight(), element);
            else
                return false;
        }
    }

    /**
     * Adds new element to the tree
     * Calls next add method
     * @param value -> The element which would be added in the tree
     */
    public void add(int value){
        add(this.root, value);
    }
    /**
     * Adds new element to the tree
     * If the value is already in the tree, it will be not added
     * If this is the first add, the value is the root of the tree
     * @param value -> The element which would be added in the tree
     * @param root -> In which node the element will be added
     */
    public void add(Node root, int value) {
        if(contains(value))
            return;
        if(value < root.getValue()) {
            if (root.getLeft() == null)
                root.setLeft(new Node(value));
            else
                add(root.getLeft(), value);
        }
        else {
            if (root.getRight() == null)
                root.setRight(new Node(value));
            else
                add(root.getRight(), value);
        }
    }
    /**
     * Prints the elements of the tree
     * Calls the next printElements method
     */
    public void printElements(){printElements(this.root);}
    /**
     * Prints the elements of the tree
     * First the root of the tree, then left nodes and right nodes
     */
    public void printElements(Node root) {
        System.out.println(root.value);
        if(root.left != null)
            printElements(root.getLeft());
        if(root.right != null)
            printElements(root.getRight());
    }
    /**
     * Inner class for Tree
     */
    class Node {
        private final int value;
        public Node left;
        private Node right;

        /**
         * Constructor for new instances of this class
         * @param value -> root of the tree
         */
        public Node(int value){
            this(value, null, null);
        }

        /**
         * Constructor for new instances of this class
         * @param value -> root of the tree
         * @param left -> left node of the tree
         * @param right -> right node of the tree
         */
        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * Getter for the root of the tree
         * @return the root
         */
        public int getValue(){return this.value;}

        /**
         * Getter for the left node of the tree
         * @return the left node
         */
        public Node getLeft(){return this.left;}

        /**
         * Setter for the left node of the tree
         * @param value -> the new left node
         */
        public void setLeft(Node value){this.left = value;}

        /**
         * Getter for the right node of the tree
         * @return the right node
         */
        public Node getRight(){return this.right;}

        /**
         * Setter for the right node of the tree
         * @param value -> the new right node
         */
        public void setRight(Node value){this.right = value;}


    }
}
