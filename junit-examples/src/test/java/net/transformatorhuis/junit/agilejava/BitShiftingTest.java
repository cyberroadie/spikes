package net.transformatorhuis.junit.agilejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BitShiftingTest {

    public BitShiftingTest() {
    }

    @Test
    public void bitShift() {
        assertEquals(34, 17 << 1);
    }

    @Test
    public void decimal() {
        int x = 1;
        assertEquals(-2, ~x);
    }

    @Test
    public void shifting() {
        int x = 34;
        assertEquals(17, x >> 1);
        assertEquals(17, x >>> 1);
        assertEquals(-17, -x >> 1);
        assertEquals(2147483631, -x >>> 1);
    }
}