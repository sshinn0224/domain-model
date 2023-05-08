package com.example.domainmodel.entity;

import com.example.domainmodel.entity.vo.Money;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();

    }

    private Money calculateAmounts() {
        return price.multiply(quantity);

    }

    public Money getAmounts() {
        return amounts;

    }


    private class Product {
        private String name;

        public Product(String name) {
            this.name = name;

        }

    }
}
