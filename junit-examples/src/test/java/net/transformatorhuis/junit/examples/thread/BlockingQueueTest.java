package net.transformatorhuis.junit.examples.thread;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BlockingQueueTest {

    Server server = null;
    String callbackMessage = null;

    @Before
    public void before() {
        server = new Server(new Logic("First logic"));
    }

    @After
    public void after() throws Exception {
        assertTrue(server.isAlive());
        server.shutdown();
        server.join(3000);
        assertFalse(server.isAlive());
    }

    /**
     * Test of run method, of class Server.
     */
    @Test
    public void testRun() throws Exception {
        server.start();
        Thread.sleep(100);
        assertEquals("First logic Test", callbackMessage);

        server.add(new Logic("Second logic"));
        Thread.sleep(100);
        assertEquals("Second logic Test", callbackMessage);

    }

    public class Logic implements ServerLogic<String> {

        String fixedMessage = null;

        public Logic(String fixedMessage) {
            this.fixedMessage = fixedMessage;
        }

        @Override
        public void execute(String message) {
            callbackMessage = fixedMessage + " " + message;
        }

    }

}