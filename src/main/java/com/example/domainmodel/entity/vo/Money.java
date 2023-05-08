package com.example.domainmodel.entity.vo;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(this.value = value + money.value);

    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);

    }
}
