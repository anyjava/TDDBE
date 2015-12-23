package com.woowahan;

import com.woowahan.Bank;
import com.woowahan.Expression;
import com.woowahan.Money;
import com.woowahan.Sum;
import org.junit.Test;

import static org.junit.Assert.*;

// TODO: 5$ + 10CHF = $10
// DONE: $5 * 2
// DONE: amount 를 private 으로 만들기
// DONE: Dollar 부작용
// TODO: Money 반올림
// DONE: equals()
// TODO: hashCode()
// TODO: Equal null
// TODO: Equal Object
// DONE: 5CHF * 2 = 10CHF
// DONE: Dollar / Franc 중복 제거
// DONE: 공용 equals
// DONE: 공용 times
// DONE: Dollar / Franc 비교하기
// DONE: 통화?
// DONE: testFrancMultiplication 제거
// TODO: $5 + $5 = $10
// TODO: $5 + $5 Money 반환하기
// DONE: Bank.reduce(Money)
// DONE: Money 에 대한 통화 변환을 수행하는 Reduce
// DONE: Reduce(Bank, String)
public class Chapter1Test {

    @Test
    public void testMultiplication() {
        Money five    = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));

        // Dollar / Franc 비교하기
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void 프랑테스트() {
        Money franc = Money.franc(5);

        assertEquals(Money.franc(10), franc.times(2));
        assertEquals(Money.franc(15), franc.times(3));
    }

    @Test
    public void 통화() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {

        Money five = Money.dollar(5);

        Expression sum = five.plus(five);

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {

        Money five = Money.dollar(5);

        Expression result = five.plus(five);

        Sum sum = (Sum) result;

        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {

        Expression sum = new Sum(Money.dollar(3), Money.dollar(5));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(8), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testArrayEquals() {
        assertArrayEquals(new Object[] { "abc" }, new Object[] {"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }


    @Test
    public void testMixedAddition() {
        Money fiveBucks = Money.dollar(5);
        Money tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
}
