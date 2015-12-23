package com.woowahan;

public class Sum implements Expression {

    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String currency) {
        Money from = augend.reduce(bank, currency);
        Money to   = addend.reduce(bank, currency);
        return new Money(from.amount + to.amount, currency);
    }
}
