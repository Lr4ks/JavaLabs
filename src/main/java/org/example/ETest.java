package org.example;
import org.example.Expression;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ETest {
    @Test
    public void testCalculate1() {
        assertEquals(5, Expression.calculate("2+3"));
    }

    @Test
    public void testCalculate2() {
        assertEquals(1, Expression.calculate("5-4"));
    }

    @Test
    public void testCalculate3() {
        assertEquals(2, Expression.calculate("4/2"));
    }

    @Test
    public void testCalculate4() {
        assertEquals(43, Expression.calculate("43"));
    }

    @Test
    public void testCalculate5() {
        assertEquals(9, Expression.calculate("(5-2)*3"));
    }

    @Test
    public void testCalculate6() {
        assertThrows(ArithmeticException.class, () -> {
           Expression.calculate("10/0");
        });
    }
    @Test
    public void testCalculate7() {
        assertThrows(ArithmeticException.class, () -> {
            Expression.calculate("10 0 0");
        });
    }
}
