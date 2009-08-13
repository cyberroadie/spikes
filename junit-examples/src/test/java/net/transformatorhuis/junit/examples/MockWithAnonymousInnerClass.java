package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class MockWithAnonymousInnerClass {

    /**
     * Test of iAmTrue method, of class MockToHidePartOfMe.
     */
    @Test
    public void testIAmTrue() {

        MockToHidePartOfMe actual = new MockToHidePartOfMe();
        // By overriding a method with an anonymous inner class
        // we can give mock it's functionality
        MockToHidePartOfMe mock = new MockToHidePartOfMe() {

            @Override
            public boolean iAmTrue() {
                return false;
            }

        };

        assertTrue(actual.iAmTrue());
        assertFalse(mock.iAmTrue());

    }

}