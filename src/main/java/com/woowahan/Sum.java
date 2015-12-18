package com.woowahan;

public class Sum implements Expression {

    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String currency) {
        return Money.dollar(this.augend.amount + this.addend.amount);
    }
}
