package com.company;

public class DiscountedProduct extends Product {
    private final Product original;
    private final double discount = 0.20;


    public DiscountedProduct(Product original, double discount) {
        super(original);
        this.original = original;
    }
    public double getPrice(Cart cart) {
        double discountedPrice = (original.getPrice(cart)-((original.getPrice(cart)*discount)));
        return discountedPrice;
    }

    @Override
    public String toString() {
        return original.getName() + "[Discounted by " + discount +"]" +" Price: "+ original.getPrice(null)+" Sold By: "+ original.getSeller();
    }

}
