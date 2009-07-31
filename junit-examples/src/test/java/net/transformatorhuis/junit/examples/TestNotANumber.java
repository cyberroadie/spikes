package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class TestNotANumber {

    public TestNotANumber() {
    }

    @Test
    public void testNotANumber() {
        assertFalse(Double.NaN > 0);
        assertFalse(Double.NaN < 1);
        assertFalse(Double.NaN == 0);
        assertTrue(Double.isNaN(0d/0d));
    }
}
