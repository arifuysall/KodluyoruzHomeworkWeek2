package com.company;

public class Product {
    private final String seller;
    private final String name;
    private final double price;

    public Product(String seller, String name, double price) {
        this.seller = seller;
        this.name = name;
        this.price = price;
    }
    public Product(Product original) {
        this.seller = original.seller;
        this.name = original.name;
        this.price = original.price;
    }
    public final String getSeller() {
        return seller;
    }
    public final String getName() {
        return name;
    }
    public double getPrice(Cart cart) {
        return price;
    }
    public boolean canBeReduced() {
        return true;
    }
    public String toString() {
        return name+", Seller: "+seller+", Price: "+price;
    }
}
