package net.transformatorhuis.junit.agilejava;

import net.transformtorhuis.junit.agilejava.FactorialLoops;
import net.transformatorhuis.junit.examples.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class FactorialLoopTest {

    private static final double TOLERANCE = 0.05;

    public FactorialLoopTest() {
    }

    /**
     * Test of factorialWhile method, of class Factorial.
     */
    @Test
    public void testFactorialWhile() {
        assertEquals(6, FactorialLoops.factorialWhile(3d), TOLERANCE);
        assertEquals(24, FactorialLoops.factorialWhile(4d), TOLERANCE);
        assertEquals(1307674368000d, FactorialLoops.factorialWhile(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, FactorialLoops.factorialWhile(25d), TOLERANCE);
    }

     /**
     * Test of factorialFor method, of class Factorial.
     */
    @Test
    public void testFactorialFor() {
        assertEquals(6, FactorialLoops.factorialFor(3d), TOLERANCE);
        assertEquals(24, FactorialLoops.factorialFor(4d), TOLERANCE);
        assertEquals(1307674368000d, FactorialLoops.factorialFor(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, FactorialLoops.factorialFor(25d), TOLERANCE);
    }

     /**
     * Test of factorialDo method, of class Factorial.
     */
    @Test
    public void testFactorialDo() {
        assertEquals(6, FactorialLoops.factorialDo(3d), TOLERANCE);
        assertEquals(24, FactorialLoops.factorialDo(4d), TOLERANCE);
        assertEquals(1307674368000d, FactorialLoops.factorialDo(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, FactorialLoops.factorialDo(25d), TOLERANCE);
    }


}