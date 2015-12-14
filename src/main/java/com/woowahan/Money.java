package com.woowahan;

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount   = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount && this.currency().equals(money.currency());
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return this.currency;
    }

    public Money times(int i) {
        return new Money(this.amount * i, this.currency);
    }

    public String toString() {
        return this.currency + "==" + this.amount;
    }
}
