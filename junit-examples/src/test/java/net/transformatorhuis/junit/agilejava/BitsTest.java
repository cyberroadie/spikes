package net.transformatorhuis.junit.agilejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BitsTest {

    public BitsTest() {
    }

    @Test
    public void bitShift() {
        assertEquals(34, 17 << 1);
    }

    @Test
    public void decimal() {
        int x = 1;
        int y = ~x;
        printXY(x, y);
        assertEquals(-2, y);
        x = 4;
        y = ~x;
        printXY(x, y);
        assertEquals(-5, y);
    }

    private void printXY(int x, int y) {
        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("y: " + Integer.toBinaryString(y));
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