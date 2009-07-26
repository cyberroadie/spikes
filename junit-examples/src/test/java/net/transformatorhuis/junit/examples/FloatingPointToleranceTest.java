package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class FloatingPointToleranceTest {

    private static final double TOLERANCE = 0.05;
    
    @Test
    public void testWithTolerance() {
        assertNotNull(0.9 - 3 * 0.3);
        assertEquals(0.9, 3 * 0.3, TOLERANCE);
    }
}
