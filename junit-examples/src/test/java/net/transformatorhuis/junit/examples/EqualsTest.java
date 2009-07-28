package net.transformatorhuis.junit.examples;

import org.junit.Before;
import org.junit.Test;
 import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class EqualsTest {

    Equals equalsA;
    Equals equalsB;
    Equals equalsC;
    
    public EqualsTest() {

    }

    @Before
    public void setup() {
        equalsA = new Equals(123, "abc");
        equalsB = new Equals(123, "abc");
        equalsC = new Equals(123, "abc");
    }

    /**
     * Test reflexivity, of class Equals.
     */
    @Test
    public void testReflexivity() {
        assertTrue(equalsA.equals(equalsA));
    }

    @Test
    public void testSymmetry() {
        assertTrue(equalsA.equals(equalsB));
        assertTrue(equalsB.equals(equalsA));
    }

    @Test
    public void testTransitivity() {
        assertTrue(equalsA.equals(equalsB));
        assertTrue(equalsB.equals(equalsC));
        assertTrue(equalsA.equals(equalsC));
    }

    @Test
    public void testConsistency() {
        for (int i = 0; i < 100000; i++) {
            assertTrue(equalsA.equals(equalsB));
        }
    }

    @Test
    public void testComparisonToNull() {
        assertFalse(equalsA.equals(null));
    }
    
}