package com.stanimiriliev.testing.warehousemanagement;

import org.junit.Test;

import com.stanimiriliev.products.*;
import com.stanimiriliev.testing.warehousemanagement.WarehouseManagement.ProductItem;
import com.stanimiriliev.products.Products.Packages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class WarehouseManagementTest {

    @Test
    public void notEnoughQuantityToSell(){
        WarehouseManagement shop = new WarehouseManagement(new ProductItem("milk", 10));
        shop.orderProducts("milk", new Milk(Packages.BIG, "Vereia", 2.5), 10);
        assertEquals(null, shop.sellProducts("milk", "vereia", Packages.BIG, 2.5, 20));
    }

    @Test
    public void orderMoreThanTheLimit(){
        WarehouseManagement shop = new WarehouseManagement(new ProductItem("milk", 10));
        assertFalse(shop.orderProducts("milk", new Milk(Packages.BIG, "Vereia", 2.5), 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void duplicateSets(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 15),
                new WarehouseManagement.ProductItem("milk", 15));
    }

    @Test
    public void setsCount(){
        WarehouseManagement shop = new WarehouseManagement();
        assertEquals(0, shop.setsCount());
    }

    @Test
    public void addSet(){
        WarehouseManagement shop = new WarehouseManagement();
        shop.addSet(new WarehouseManagement.ProductItem("Milk", 50));
        shop.addSet(new WarehouseManagement.ProductItem("Coffee", 70));
        shop.addSet(new WarehouseManagement.ProductItem("Egg", 10));
        assertEquals(10, shop.freeSets("Egg"));
    }

    @Test
    public void freeSets(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        assertEquals(20, shop.freeSets("milk"));

        shop.orderProducts("Milk", new Milk(Products.Packages.BIG, "Vereia", 2.59), 7);

        assertEquals(13, shop.freeSets("milk"));
    }

    @Test
    public void orderProducts(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Products.Packages.SMALL, "Bozhentsi", 1.1);

        assertTrue(shop.orderProducts("Milk", vereia, 10));
        assertFalse(shop.orderProducts("Milk", bozhentsi, 30));//  Not enough space
        assertTrue(shop.orderProducts("Milk", bozhentsi, 5));
    }

    @Test
    public void getProductsSorted(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Products.Packages.SMALL, "Bozhentsi", 1.1);

        shop.orderProducts("Milk", vereia, 1);
        shop.orderProducts("Milk", bozhentsi, 1);

        assertThat(shop.getProductsSorted(), is(equalTo(Arrays.asList(bozhentsi, vereia))));
    }

    @Test
    public void sellProducts(){
        WarehouseManagement shop = new WarehouseManagement(
                new WarehouseManagement.ProductItem("Milk", 20));

        Products vereia = new Milk(Products.Packages.MEDIUM, "Vereia", 2);

        shop.orderProducts("Milk", vereia, 10);

        List<Products> products = new ArrayList<>();
        products.add(vereia);
        assertEquals(products, shop.sellProducts(
                "Milk", "vereia", Products.Packages.MEDIUM, 2, 1));
        assertEquals(null, shop.sellProducts(
                "Milk", "vereia", Products.Packages.MEDIUM, 2,  20));// Not enough quantity
    }
}