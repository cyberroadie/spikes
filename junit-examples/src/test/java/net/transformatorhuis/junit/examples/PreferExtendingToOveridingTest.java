package net.transformatorhuis.junit.examples;

import net.transformatorhuis.junit.examples.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class PreferExtendingToOveridingTest {

    /**
     * Test of addNumbers method, of class PreferExtendingToOveriding.
     */
    @Test
    public void testAddNumbers() {
        System.out.println("addNumbers");
        PreferExtendingToOveriding instance = new PreferExtendingToOveriding();
        instance.addNumbers();
        assertEquals(10, instance.getCounter());
    }

}