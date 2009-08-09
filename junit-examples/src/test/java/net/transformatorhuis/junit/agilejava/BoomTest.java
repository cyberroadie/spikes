package net.transformatorhuis.junit.agilejava;

import net.transformatorhuis.junit.examples.*;
import java.util.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static net.transformatorhuis.junit.agilejava.Boom.*;

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
            blowsUp();
            fail("Runtime excpetion expected");
    }

    /**
     * Test of rethrows method, of class Boom.
     */
    @Test
    public void testRethrows() {
        try {
            rethrows();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e.getCause().getMessage().endsWith("Booooom!"));
        }
    }

    @Ignore
    @Test
    public void testExceptionOrder1() {
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        } catch (SimpleException e) {
            fail("caught wrong exception");
        } catch (RuntimeException success) {
            
        }
    }

    @Ignore
    @Test
    public void testExceptionOrder2() {
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        } catch (SimpleException success) {

        } catch (RuntimeException failure) {
            fail("caught wrong exception");
        }
    }

    @Ignore
    @Test
    public void testExceptionOrder3() {
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        } catch (RuntimeException success) {
        
        } // catch (SimpleException failure) {
//
//        }
    }

    @Ignore
    @Test
    public void testExceptionOrder4() {
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        } catch (RuntimeException success) {

        } // catch (SimpleException failure) {
//
//        } finally {
//            return;
//        }
    }

    @Ignore
    @Test
    public void testExceptionOrder5() {
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        } catch (SimpleException yours) {
            fail("caught wrong exception");
        } catch (RuntimeException success) {

        }
    }

    @Test
    public void testExceptionOrder6() {
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        } catch (SimpleException e) {
            fail("caught wrong exception");
        } catch (RuntimeException success) {

        }
    }

    @Ignore
    @Test
    public void testExceptionOrder7() {
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        } catch (SimpleException success) {
            
        } catch (RuntimeException fail) {
            fail("caught wrong exception");
        }
    }

    @Test
    public void testErrorException1() {
        try {
            throw new RuntimeException("fail");
        } catch (Exception success) {

        }
    }

    @Test
    public void testErrorException2() {
        try {
            new Dyer();
        } catch (Exception success) {

        }
    }

    @Ignore
    @Test
    public void testErrorException3() {
        try {
            new Dyer();
        } catch (Error success) {

        }
    }

    @Test
    public void testErrorException4() {
        try {
            new Dyer();
        } catch (Throwable success) {

        }
    }

    @Ignore
    @Test
    public void testErrorException5() {
        try {
            new Dyer();
        } catch (Throwable fail) {
            fail("caught exception in wrong place");
        } // catch (Error success) {
//        }
    }


    @Test
    public void testErrorException6() {
        try {
            new Dyer();
        } catch (Error fail) {
            fail("caught exception in wrong place");
        } catch (Throwable success) {

        }
    }


    @Test
    public void testErrorException7() {
        try {
            new Dyer();
        } catch (Error fail) {
            fail("caught exception in wrong place");
        } catch (Throwable success) {

        } finally {
            return;
        }
    }


    class Dyer {

        public Dyer() {
            throw new RuntimeException("oops");
        }

    }

}