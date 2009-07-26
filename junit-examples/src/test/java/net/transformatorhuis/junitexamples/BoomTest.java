package net.transformatorhuis.junitexamples;

import java.util.logging.Logger;
import net.transformatorhuis.junitexamples.SimpleException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BoomTest {

    Logger logger = Logger.getLogger(BoomTest.class.getName());
    
    public BoomTest() {
    }

    /**
     * Test of blowsUp method, of class Boom.
     */
    @Test (expected=SimpleException.class)
    public void testBlowsUp() {
            Boom.blowsUp();
            fail("Runtime excpetion expected");
    }

    /**
     * Test of reThrows method, of class Boom.
     */
    @Test
    public void testReThrows() {
        try {
            Boom.reThrows();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e.getCause().getMessage().endsWith("Booooom!"));
        }
    }

}