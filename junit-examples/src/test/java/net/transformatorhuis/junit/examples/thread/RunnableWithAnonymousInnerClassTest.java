package net.transformatorhuis.junit.examples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author cyberroadie
 */
public class RunnableWithAnonymousInnerClassTest {

    private static int MAX_LOOP = 1000;
    private int loopProgress;

    public RunnableWithAnonymousInnerClassTest() {
    }

    public void setLoopProgress(int progress) {
        // Example of synchronized block
        // if synchronizing method would be to big a lock
        synchronized(this) {
            this.loopProgress = progress;
        }
    }

    public int getLoopProgress() {
        return loopProgress;
    }

    /**
     * Test of doLoop method, of class Loop.
     */
    @Test
    public void testDoLoop() {

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
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                loop.doLoop();
            }
        });

        t1.start();

        int previousProgress = 0;
        while (getLoopProgress() < MAX_LOOP) {
            try {
                if (getLoopProgress() > previousProgress) {
                    System.out.println("Progress" + getLoopProgress());
//                    System.out.print("*");
                    previousProgress = getLoopProgress();
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunnableWithAnonymousInnerClassTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
