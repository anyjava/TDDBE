package com.woowahan.tdd;

public class Franc2 {

    private int amount;

    public Franc2(int amount) {
        this.amount = amount;
    }

    public Franc2 times(int mutiplier) {

        int amount = this.amount * mutiplier;

        return new Franc2(amount);
    }

    public boolean equals(Object object) {
        return this.amount == ((Franc2) object).amount;
    }
}
