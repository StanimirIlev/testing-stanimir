package com.stanimiriliev.javaobjects.heterogeneoustree.products;

/**
 * @author Stanimir Iliev
 * @since 21.07.2017
 */

public class Coffee extends Products {

    public enum Types{
            GROUND, BEANS
    }

    public final Types type;

    public Coffee(Packages pack, Types type, String make, double price){
        super(pack, make, price);
        this.type = type;
    }
}
