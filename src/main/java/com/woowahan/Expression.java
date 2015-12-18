package com.woowahan;

public interface Expression {

    Money reduce(Bank bank, String to);
}
