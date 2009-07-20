package net.transformatorhuis.junitexamples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ContinueTest {

    public ContinueTest() {
    }

    /**
     * Test of getDivisibleByFiveString method, of class Continue.
     */
    @Test
    public void testGetDivisibleByFiveString() {
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Continue.getDivisibleByFiveString(12));
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12 13 14 15*", Continue.getDivisibleByFiveString(15));
        assertEquals("1 2 3 4", Continue.getDivisibleByFiveString(4));
    }

}