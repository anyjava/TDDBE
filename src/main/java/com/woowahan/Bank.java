package com.woowahan;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money reduce(Expression expression, String currency) {
        return expression.reduce(this, currency);
    }

    public void addRate(String from, String to, int i) {
        rates.put(new Pair(from, to), i);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return (Integer)this.rates.get(new Pair(from, to));
    }
}