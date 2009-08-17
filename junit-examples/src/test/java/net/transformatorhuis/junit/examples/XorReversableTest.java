package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * XOR is reversible.
 * @author cyberroadie
 */
public class XorReversableTest {

    public XorReversableTest() {
    }

    @Test
    public void testReversibility() {
        int x = 7; // 0000 0111
        int y = 41; // 0010 1001
        int xPrime = x ^ y; // 0011 1110
        assertEquals(46, xPrime);
        assertEquals(x, xPrime ^ y);
    }
}