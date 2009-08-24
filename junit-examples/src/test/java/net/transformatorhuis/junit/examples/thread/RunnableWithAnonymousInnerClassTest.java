package net.transformatorhuis.junit.examples.thread;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RunnableWithAnonymousInnerClassTest {

    private static int MAX_LOOP = 20;
    private int loopProgress = 0;
    private Object monitor = new Object();
    private Thread server;

    public RunnableWithAnonymousInnerClassTest() {
    }

    public void setLoopProgress(int progress) {
        // Example of synchronized block
        // if synchronizing method would be to big a lock
        synchronized(this) {
            this.loopProgress = progress;
        }

        System.out.println("Progress: " + progress);
        // Start test thread again
        if (getLoopProgress() >= MAX_LOOP) {
            System.out.println("Notify monitor");

            // Have to get a lock on monitor object before
            // we can send notifyAll message
            synchronized(monitor) {
                monitor.notifyAll();
            }
        }


    }

    public int getLoopProgress() {
        return loopProgress;
    }

    /**
     * Test of doLoop method, of class Loop.
     */
    @Test
    public void testDoLoop() throws InterruptedException {

        // Create loop with a callback
        final Loop loop = new Loop(new LoopCallback() {

            @Override
            public int getMaxLoop() {
                return MAX_LOOP;
            }

            @Override
            public void setProgress(int progress) {
                setLoopProgress(progress);
            }
        });

        // Create thread with Runnable anonymous inner class
        server = new Thread(new Runnable() {

            @Override
            public void run() {
                loop.doLoop();
            }
        });

        server.start();

        // Wait test thread
        synchronized(monitor) {
            if (getLoopProgress() < MAX_LOOP) {
                // By putting it into wait all locks (synchronized) will be removed
                // and this thread will be put in a rest state
                monitor.wait();
            }
        }
        
    }
}
