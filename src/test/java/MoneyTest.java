import com.woowahan.tdd.Dollar2;
import org.junit.Test;
import static org.junit.Assert.*;

// $5 * 10CHF = $10 (환율 2:1)
// (x) $5 * 2 = $10
// amount 필드를 private
// Dollar side effect => FP In Scala
// Money 반올림?
// equal --> ==, ===
// equality
// equal == null
// equal object -> dollar 가 아닌 다른게 들어오면?

// 1. red
// 2. green
// 3. refactoring(중복제거  + 의미부여)
public class MoneyTest {

    @Test
    public void testSample() {
//        assertEquals(Dollar2(5), Dollar2(5) + Fran(10));
    }

    @Test
    public void 딸라따블로() {
        Dollar2 dollar = new Dollar2(5);
        assertEquals(10, dollar.times(2).amount);
        assertEquals(15, dollar.times(3).amount);
    }

    @Test
    public void equality() {

        assertTrue(new Dollar2(10).equals(new Dollar2(5).times(2)));
        assertFalse(new Dollar2(15).equals(new Dollar2(5).times(2)));
    }
}
