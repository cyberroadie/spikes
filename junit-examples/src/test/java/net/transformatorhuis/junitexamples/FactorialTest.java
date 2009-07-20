package net.transformatorhuis.junitexamples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class FactorialTest {

    private static final double TOLERANCE = 0.05;

    public FactorialTest() {
    }

    /**
     * Test of factorialWhile method, of class Factorial.
     */
    @Test
    public void testFactorialWhile() {
        assertEquals(6, Factorial.factorialWhile(3d), TOLERANCE);
        assertEquals(24, Factorial.factorialWhile(4d), TOLERANCE);
        assertEquals(1307674368000d, Factorial.factorialWhile(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, Factorial.factorialWhile(25d), TOLERANCE);
    }

     /**
     * Test of factorialFor method, of class Factorial.
     */
    @Test
    public void testFactorialFor() {
        assertEquals(6, Factorial.factorialFor(3d), TOLERANCE);
        assertEquals(24, Factorial.factorialFor(4d), TOLERANCE);
        assertEquals(1307674368000d, Factorial.factorialFor(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, Factorial.factorialFor(25d), TOLERANCE);
    }

     /**
     * Test of factorialDo method, of class Factorial.
     */
    @Test
    public void testFactorialDo() {
        assertEquals(6, Factorial.factorialDo(3d), TOLERANCE);
        assertEquals(24, Factorial.factorialDo(4d), TOLERANCE);
        assertEquals(1307674368000d, Factorial.factorialDo(15d), TOLERANCE);
        assertEquals(15511210043330985984000000d, Factorial.factorialDo(25d), TOLERANCE);
    }


}