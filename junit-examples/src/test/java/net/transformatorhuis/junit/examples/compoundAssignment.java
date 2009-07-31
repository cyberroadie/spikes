package net.transformatorhuis.junit.examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class compoundAssignment {

    public compoundAssignment() {
    }

    @Test
    public void compounAssignmentTest() {
        int x = 7;
        assertEquals(21, x *= 3);

    }
}