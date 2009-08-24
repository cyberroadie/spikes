package net.transformatorhuis.junit.examples.thread;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ThreadLocalTest {

    private int MAX_LOOP = 10;
    private static ThreadLocal<List<String>> threadLog = new ThreadLocal<List<String>>() {

        @Override
        protected List<String> initialValue() {
            return new ArrayList<String>();
        }

    };

    @Test
    public void test1() {
        threadLog.get().add("test1");
    }

    @Test
    public void test2() {
        final Loop loop = new Loop(new LoopCallback() {

            @Override
            public int getMaxLoop() {
                return MAX_LOOP;
            }

            @Override
            public void setProgress(int progress) {
                // This won't work
                threadLog.get().add("Loop: " + 1);
            }
        });

        Thread loopThread = new Thread(new Runnable() {

            @Override
            public void run() {
                loop.doLoop();
            }
        });

        loopThread.start();

        // Only the local thread gets counted
        assertEquals(1, threadLog.get().size());

    }

}
