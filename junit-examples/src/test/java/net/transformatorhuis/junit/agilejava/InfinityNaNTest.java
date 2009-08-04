package net.transformatorhuis.junit.agilejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class InfinityNaNTest {

    public InfinityNaNTest() {
    }

    @Test
    public void testNaN() {
        Double nan = 0d / 0d;
        assertTrue(Double.isNaN(nan));
    }

    @Test
    public void testInfinity() {
        Double inf = 1d / 0d;
        assertTrue(Double.isInfinite(inf));
    }
}