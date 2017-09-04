package com.stanimiriliev.testing.warehousemanagement;

import com.stanimiriliev.products.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WarehouseManagementTest {

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void duplicateSetsTest(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 15),
                new WarehouseManagement.ProductItem("milk", 15));
    }

    @org.junit.Test
    public void addSetTest(){
        WarehouseManagement shop = new WarehouseManagement();
        assertEquals(0, shop.itemsCount());
        shop.addSet(new WarehouseManagement.ProductItem("Milk", 50));
        shop.addSet(new WarehouseManagement.ProductItem("Coffee", 70));
        shop.addSet(new WarehouseManagement.ProductItem("Egg", 10));
        assertEquals(3, shop.itemsCount());
        assertEquals(10, shop.freeSets("Egg"));
    }

    @org.junit.Test
    public void freeSetsTest(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20),
                new WarehouseManagement.ProductItem("Egg", 40),
                new WarehouseManagement.ProductItem("Coffee", 30));

        assertEquals(20, shop.freeSets("milk"));
        assertEquals(40, shop.freeSets("egg"));
        assertEquals(30, shop.freeSets("coffee"));

        shop.orderProducts("Milk", new Milk(Products.Packages.BIG, "Vereia", 2.59), 7);

        assertEquals(13, shop.freeSets("milk"));
    }

    @org.junit.Test
    public void orderProductsTest(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Products.Packages.SMALL, "Bozhentsi", 1.1);

        assertEquals(true, shop.orderProducts("Milk", vereia, 10));
        //  Not enough space
        assertEquals(false, shop.orderProducts("Milk", bozhentsi, 30));
        assertEquals(true, shop.orderProducts("Milk", bozhentsi, 5));
    }

    @org.junit.Test
    public void getProductsSortedTest(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Products.Packages.SMALL, "Bozhentsi", 1.1);

        shop.orderProducts("Milk", vereia, 1);
        shop.orderProducts("Milk", bozhentsi, 1);

        List<Products> sortedProducts = new ArrayList<>();

        sortedProducts.add(bozhentsi);
        sortedProducts.add(vereia);

        assertThat(sortedProducts, is(equalTo(shop.getProductsSorted())));
    }

    @org.junit.Test
    public void sellProductsTest(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);

        shop.orderProducts("Milk", vereia, 10);

        List<Products> products = new ArrayList<>();
        for(int i = 0; i < 7; i++)
            products.add(vereia);
        assertEquals(products, shop.sellProducts(
                "Milk", "vereia", Products.Packages.MEDIUM, 2, 7));
        assertEquals(null, shop.sellProducts(
                "Milk", "vereia", Products.Packages.MEDIUM, 2,  20));
    }

    @org.junit.Test
    public void containsProductTest() {
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        shop.orderProducts("Milk", new Milk(Products.Packages.MEDIUM, "Vereia", 2), 3);

        assertEquals(3, shop.containsProduct("milk", "vereia", 2, Products.Packages.MEDIUM));
    }

}