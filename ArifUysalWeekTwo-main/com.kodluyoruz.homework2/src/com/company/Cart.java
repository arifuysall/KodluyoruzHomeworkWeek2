package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products;

    public Cart(){
        products = new ArrayList<>();
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);

    }
    public void addProduct(Product product, int howManyTimes) {

        for (int i = 1; i <= howManyTimes ; i++) {
            products.add(product);
        }
    }
    public double totalPrice(){
        double totalPrice = 0;
        for ( int i = 0; i < products.size(); i++) {
            double prices = products.get(i).getPrice(this);
            totalPrice += prices;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        String info="";
        for (int i = 0 ; i < products.size(); i++) {
            info = products.get(i).getName()+products.get(i).getPrice(this)+" Sold by " +products.get(i).getSeller() + " \n ";}
        return info;
    }
}
