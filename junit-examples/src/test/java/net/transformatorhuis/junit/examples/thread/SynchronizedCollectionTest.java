package net.transformatorhuis.junit.examples.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class SynchronizedCollectionTest {

    private static final int MAX_LOOP = 1000;
    private int loopProgress;

    // This is how you put synchronisation around a non synchronized collection
    List<Integer> testList = Collections.synchronizedList(new ArrayList<Integer>());

    public void setTestList(int number) {
        testList.set(number, number);
    }

    public int getLoopProgress() {
        return loopProgress;
    }

    public void setLoopProgress(int loopProgress) {
        this.loopProgress = loopProgress;
    }

    @Test
    /**
     * In this method I start two thread accessing the same list
     */
    public void testSynchronizedList() throws Exception {

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
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                loop.doLoop();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                loop.doLoop();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

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
