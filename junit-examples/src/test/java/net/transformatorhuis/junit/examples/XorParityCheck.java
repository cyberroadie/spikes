package net.transformatorhuis.junit.examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Parity check: when XOR all data;
 * If the number of 1s is even parity is even
 * If the number of 1s is odd parity is odd
 *
 * @author cyberroadie
 */
public class XorParityCheck {

    @Test
    public void testParity() {
        assertEquals(0, xorAll(1, 1, 1, 1));
        assertEquals(1, xorAll(1, 1, 0, 1));
        int result = xorAll(7, 1, 1); // 7 binary: 0111
        assertTrue(result%2 > 0); // test for odd number
        result = xorAll(7, 1, 0);
        assertTrue(result%2 == 0); // test for even number
    }

    private int xorAll(int first, int... rest) {
        int parity = first;
        for (int i : rest) {
            parity ^= i;
        }
        return parity;
    }
}