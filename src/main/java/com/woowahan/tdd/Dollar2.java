package com.woowahan.tdd;

public class Dollar2 {

    public int amount;

    public Dollar2(int amount) {
        this.amount = amount;
    }

    public Dollar2 times(int mutiplier) {

        int amount = this.amount * mutiplier;

        return new Dollar2(amount);
    }

    public boolean equals(Object object) {
        return this.amount == ((Dollar2) object).amount;
    }
}
