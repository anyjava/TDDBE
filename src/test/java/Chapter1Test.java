import com.woowahan.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
// TODO: 공용 times
// DONE: Dollar / Franc 비교하기
// DONE: 통화?
// TODO: testFrancMultiplication 제거
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
}
