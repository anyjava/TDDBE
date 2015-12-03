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
public class Chapter1Test {

    @Test
    public void testMultiplication() {
        Dollar five    = new Dollar(5);

        assertEquals(new Dollar(10), five.times(2));

        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}
