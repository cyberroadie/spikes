package net.transformatorhuis.junit.agilejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class MathTest {

    public void wontCompile() {
        float x = 1;
        float y = (float) 1.0;
        float z = (int) 1.0;
    }

    @Test
    public void intCast() {
        int x = (int) 1.9;
        System.out.println("Int cast 1.9: " + x);
    }

    @Test
    public void valueOfRInt() {
        assertEquals(1.0d, Math.rint(1.9));
        assertTrue(2.0d == Math.rint(1.5));
        assertTrue(2.0d == Math.rint(2.5));
    }

}
