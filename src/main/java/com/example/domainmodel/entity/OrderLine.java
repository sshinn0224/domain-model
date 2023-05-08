package com.example.domainmodel.entity;

public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();

    }

    private int calculateAmounts() {
        return price * quantity;

    }

    public int getAmounts() {
        return amounts;

    }


    private class Product {
        private String name;

        public Product(String name) {
            this.name = name;

        }

    }
}
