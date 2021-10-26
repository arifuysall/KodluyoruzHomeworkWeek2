package com.company;

public class Buy2Take3Product extends Product{
    private final Product original;

    public Buy2Take3Product(Product original) {
        super(original);
        if (!original.canBeReduced())
            throw new IllegalArgumentException();
        else{
            this.original = original;
        }

    }

    public boolean canBeReduced() {
        return false;
    }
    public double getPrice(Cart cart) {
        long quantity=0;
        for( int i = 0; i < cart.getProducts().size() ; i++){
            if(cart.getProducts().get(i) instanceof Buy2Take3Product){
                quantity++;
            }
        }
        long total = quantity / 3;
        long extraProduct = quantity - total;
        double totalPrice = extraProduct * this.original.getPrice(cart);
        double unitPrice = totalPrice / quantity;
        return unitPrice;

    }
}


