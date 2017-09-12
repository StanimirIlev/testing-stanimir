package com.stanimiriliev.javaobjects.heterogeneoustree.products;

/** Class for products
 * @author Stanimir Iliev
 * @since 21.07.2017
 */
public class Products implements Comparable<Products>{

    public enum Packages{
        SMALL, MEDIUM, BIG
    }

    public final String make;
    public final Double price;
    public final Packages pack;

    public Products(Packages pack, String make, double price){
        this.make = make;
        this.price = price;
        this.pack = pack;
    }

    public int compareTo(Products product){
        return this.price.compareTo(product.price);
    }
}
