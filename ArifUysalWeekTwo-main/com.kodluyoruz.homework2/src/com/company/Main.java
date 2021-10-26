package com.company;

import java.util.Scanner;

public class Main {
    public static void askCustomer(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to buy a product");
            System.out.println("Enter 0 to checkout and proceed with the payment");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 0) {
                break;
            }
            System.out.print("Product name: ");
            String productName = scanner.nextLine();
            System.out.print("Seller: ");
            String sellerName = scanner.nextLine();
            System.out.print("Price: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("How many: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Discount (enter 0 if no discount applies): ");
            double discountAmount = Double.parseDouble(scanner.nextLine());
            System.out.print("Does Buy2Take3 apply? Y/N ");
            String buy2Take3Applied = scanner.nextLine();
            if (discountAmount != 0 && buy2Take3Applied.equals("Y")) {
                throw new IllegalArgumentException("You can't choose both type of discounts!");
                }
            Product product = new Product(sellerName,productName,price);
            if(product.canBeReduced() && discountAmount != 0){
                DiscountedProduct discountedProduct = new DiscountedProduct(product,discountAmount);
                cart.addProduct(discountedProduct,quantity);
            }
            else{
                Buy2Take3Product buy2Take3Product = new Buy2Take3Product(product);
                cart.addProduct(buy2Take3Product,quantity);
            }




            }
        System.out.println(cart.getProducts());
        System.out.println("In total you have to pay : "+ cart.totalPrice());
        System.out.println("Thanks for coming by, see you later!");



    }

    public static void main(String[] args) {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        Scanner scanner = new Scanner(System.in);

        String customer = scanner.nextLine();
        System.out.println("Hi " + customer + ". Please choose one of the following options:");
        System.out.println("");

        Cart cart = new Cart();

        askCustomer(cart);

        scanner.close();
    }
}
