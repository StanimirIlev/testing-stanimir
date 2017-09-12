package com.stanimiriliev.javaobjects.heterogeneoustree;

import com.stanimiriliev.javaobjects.heterogeneoustree.products.*;
import com.stanimiriliev.javaobjects.heterogeneoustree.products.Products.Packages;
import com.stanimiriliev.javaobjects.heterogeneoustree.products.Coffee.Types;

/**
 * Class to test the functionality of the heterogeneous tree
 * @author      Stanimir Iliev
 * @since       20.07.2017
 */
public class Test {
    public static void main(String[] args){

        Milk vereia = new Milk(Packages.MEDIUM, "Vereia", 15);
        Milk bozhentsi = new Milk(Packages.BIG, "Bozhentsi", 16);

        Coffee brazilia = new Coffee(Packages.SMALL, Types.BEANS, "Nova Brazilia", 25);
        Coffee jacobs = new Coffee(Packages.BIG, Types.GROUND, "Jacobs", 26);

        Egg stoevtsi = new Egg(Packages.MEDIUM, "Stoevtsi", 35);
        Egg gabrovo = new Egg(Packages.MEDIUM, "Gabrovo", 36);

        Tree<Products> shop = new Tree<>(brazilia);

        shop.add(vereia);
        shop.add(jacobs);
        shop.add(stoevtsi);
        shop.add(gabrovo);
        shop.add(bozhentsi);

        Products search = new Products(Packages.MEDIUM, "", 15);
        if(shop.getElement(search) == null){
            System.out.println("There is no product with this price");
        }
        else{
            System.out.println(shop.getElement(search).make);
        }
    }
}
