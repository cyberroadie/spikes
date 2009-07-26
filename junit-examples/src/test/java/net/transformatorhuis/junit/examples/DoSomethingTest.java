package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class DoSomethingTest {

    public DoSomethingTest() {
    }

    @Test
    public void testWithProblems() {
        try {
            doSomething();
            fail("no exception");
        } catch (Exception success) {
        }
    }

    void doSomething() throws Exception {
        throw new Exception("blah");
    }

}