package datastructures.algorithms.util;

import algorithms.util.GenericMath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GenericMathTest {
    @Test
    public void testGcd() {
        assertEquals(4,GenericMath.gcd(8,12));
        assertEquals(4,GenericMath.gcd(12,8));
        assertEquals(5,GenericMath.gcd(25,15));
        assertEquals(1,GenericMath.gcd(26,25));
    }

    @Test
    public void testLCM() {
        assertEquals(24,GenericMath.lcm(8,12));
        assertEquals(35,GenericMath.lcm(7,5));
        assertEquals(36,GenericMath.lcm(12,18));
    }

    @Test
    public void testIsPrime() {
        assertTrue(GenericMath.isPrime(13));
        assertTrue(GenericMath.isPrime(2));
        assertFalse(GenericMath.isPrime(15));
        assertFalse(GenericMath.isPrime(28));
    }

    @Test
    public void testDecimalToBinary() {
       assertEquals("101",GenericMath.decimalToBinary(5));

       assertEquals("10011",GenericMath.decimalToBinary(19));
    }
}
