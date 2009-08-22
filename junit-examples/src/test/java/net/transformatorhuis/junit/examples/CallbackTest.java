package net.transformatorhuis.junit.examples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class CallbackTest {

    // Local variable to sent a message to
    private int executionCounter = 0;
    private Callback callback;
    
    public CallbackTest() {
    }

    @Before
    public void setUpClass() throws Exception {

        CallbackCounter cc = new CallbackCounter() {

            @Override
            public void executed() {
                executionCounter++;
            }

        };

        callback = new Callback(cc);

    }

    /**
     * Test of count method, of class Callback.
     */
    @Test
    public void testInnnerClassListener() {
        for (int i = 0; i < 1532; i++) {
            callback.count();
        }
        assertTrue(executionCounter == 1532);
    }

}