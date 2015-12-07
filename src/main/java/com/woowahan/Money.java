package com.woowahan;

public class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money times(int i) {
        return new Money(this.amount * i);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount;
    }
}
