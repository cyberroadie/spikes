/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.transformatorhuis.junitexamples;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Lazy initilization is much faster!!
 * @author cyberroadie
 */
public class KeenAndLazyInitilizationTest {

    private long start;
    private long stop;

    @Test
    public void testKeenInitilization() {
        start();
        List<KeenInitialization> arrayList = new ArrayList(10000);
        for (int i = 0; i < 10000; i++) {
            arrayList.add(new KeenInitialization());
        }
        stop();
        System.out.println(timeToString());
        assertEquals(Integer.valueOf(1), arrayList.get(500).getKeenVariable());
    }

    @Test
    public void testLazyInitilization() {
        start();
        List<LazyInitilization> arrayList = new ArrayList(10000);
        for (int i = 0; i < 10000; i++) {
            arrayList.add(new LazyInitilization());
        }
        stop();
        System.out.println(timeToString());
        assertEquals(Integer.valueOf(1), arrayList.get(500).getLazyVariable());
    }

    public void start() {
        start = System.currentTimeMillis(); // start timing
    }

    public void stop() {
        stop = System.currentTimeMillis(); // stop timing
    }

    public long elapsedTimeMillis() {
        return stop - start;
    }

    public String timeToString() {
        return "elapsedTimeMillis: " + Long.toString(elapsedTimeMillis()); // print execution time
    }


}
