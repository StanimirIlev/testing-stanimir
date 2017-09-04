package com.stanimiriliev.testing.warehousemanagement;

import com.stanimiriliev.products.*;
import com.stanimiriliev.products.Products.Packages;

import java.util.*;

/**
 * @author Stanimir Iliev
 * @since 01.08.2017
 */
public class WarehouseManagement {

    public static class ProductItem{

        public final String name;
        public List<Products> product = null;
        public int count = 0;
        public final int max;

        public ProductItem(String name, int maxQuantity){
            this.name = name.toLowerCase();
            max = maxQuantity;
        }
    }

    private List<ProductItem> inventory = new ArrayList<>();

    public WarehouseManagement(ProductItem... sets){
        List<String> names = new LinkedList<>();
        for(ProductItem set : sets) {
            if (names.contains(set.name)) {
                throw new IllegalArgumentException("Duplicate names of sets");
            }
            names.add(set.name);
        }
        inventory.addAll(Arrays.asList(sets));
    }

    public int setsCount(){
        return inventory.size();
    }

    /**
     * Adds new set in the inventory
     * @param set -> the new item
     */
    public void addSet(ProductItem set){
        if(getProductByName(set.name) != null) {
            throw new IllegalArgumentException("This set exist already");
        }
        inventory.add(set);
    }

    /**
     * Gets product in specific quantity from the warehouse
     * @param nameOfSet -> The type of the product you want to get
     * @param make ->  The make of the product (not case sensitive)
     * @param pack -> The enum package of the product (SMALL, MEDIUM, BIG)
     * @param quantity -> The quantity of the product to get
     * @return list with the quantity of the product
     * or null if there is no such a product or not enough quantity of it
     */
    public List<Products> sellProducts(String nameOfSet, String make,
                                       Packages pack, double price, int quantity){
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive integer");
        }
        ProductItem item = getProductByName(nameOfSet);
        if(item == null) {
            throw new IllegalArgumentException("Product with such a name is not found");
        }
        List<Products> output = new ArrayList<>();
        int matches = 0;
        if(quantity > containsProduct(nameOfSet, make, price, pack)) {
            return null;
        }
        for(int i = 0; i < item.product.size() && matches < quantity; i++){
            if(item.product.get(i).make.equalsIgnoreCase(make) && item.product.get(i).pack == pack &&
                    item.product.get(i).price == price){
                output.add(item.product.get(i));
                item.product.remove(i--);
                matches++;
            }
        }
        return output.size() != 0 ? output : null;
    }

    /**
     * Adds specific quantity of product in the warehouse
     * @param nameOfSet -> The type of the product you want to add
     * @param product -> The actual product you want to add
     * @param quantity -> The quantity of this product you want to add
     * @return true if the product is added successfully
     * or false if there is not enough space in the warehouse
     */
    public boolean orderProducts(String nameOfSet, Products product, int quantity){
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive integer");
        }
        ProductItem item = getProductByName(nameOfSet);
        if(item == null) {
            throw new IllegalArgumentException("Product with such a name is not found");
        }
        if(item.count + quantity <= item.max){
            if(item.product == null) {
                item.product = new ArrayList<>();
            }
            for(int i = 0; i < quantity; i++) {
                item.product.add(product);
            }
            item.count += quantity;
            return true;
        }
        return false;
    }

    /**
     * Returns all products in the warehouse sorted by their price (Returns without removing from the warehouse)
     * @return list with the products in the warehouse sorted by price
     * or null if there is not any products in the warehouse
     */
    public List<Products> getProductsSorted(){
        List<Products> output = new ArrayList<>();
        for(ProductItem item : inventory) {
            output.addAll(item.product);
        }
        Collections.sort(output);
        return output;
    }

    /**
     * Shows how many free sets the specific product type has
     * @param nameOfSet -> The type of the product
     * @return the number of the free sets of the product
     */
    public int freeSets(String nameOfSet){
        ProductItem item = getProductByName(nameOfSet);
        if(item == null) {
            throw new IllegalArgumentException("Product with such a name is not found");
        }
        return item.max - item.count;
    }

    /**
     * Gets the index in the inventory of the product by name
     * @param name -> The name of the product
     * @return the  the product or null if the product is not found
     */
    private ProductItem getProductByName(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equalsIgnoreCase(name)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    /**
     * Shows how many products the warehouse has with the same description
     * @param nameOfSet -> The type of product
     * @param make -> The make of the product (not case sensitive)
     * @param pack -> The enum package of the product (SMALL, MEDIUM, BIG)
     * @return integer that presents how many times this product is found
     */
    private int containsProduct(String nameOfSet, String make, double price, Packages pack){
        ProductItem item = getProductByName(nameOfSet);
        if(item == null) {
            throw new IllegalArgumentException("Product of this set is not found");
        }
        int matches = 0;
        for (int i = 0; i < item.product.size(); i++) {
            if (item.product.get(i).make.equalsIgnoreCase(make) && item.product.get(i).pack == pack &&
                    item.product.get(i).price == price) {
                matches++;
            }
        }
        return matches;
    }
}
