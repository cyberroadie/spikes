/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.transformatorhuis.junit.examples;

import net.transformatorhuis.junit.examples.*;
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
    private int executionCount = 10000;
    private int initilizationCount = 80000;

    @Test
    public void testKeenInitilization() {
        // Initialization time
        start();
        List<KeenInitialization> arrayList = new ArrayList(initilizationCount);
        for (int i = 0; i < initilizationCount; i++) {
            arrayList.add(new KeenInitialization());
        }
        stop();
        System.out.println("Initilizing time keen 1: " + timeToString());
        // Execution time
        start();
        for (int i = 0; i < initilizationCount; i++) {
            assertEquals(Integer.valueOf(1), arrayList.get(i).getKeenVariable());
        }
        stop();
        System.out.println("Executing time keen 1: " + timeToString());
    }

    @Test
    public void testLazyInitilization() {
        // Initialization time
        start();
        List<LazyInitilization> arrayList = new ArrayList(initilizationCount);
        for (int i = 0; i < initilizationCount; i++) {
            arrayList.add(new LazyInitilization());
        }
        stop();
        System.out.println("Initilizing time lazy 1: " + timeToString());
        // execution time
        start();
        for (int i = 0; i < initilizationCount; i++) {
            assertEquals(Integer.valueOf(1), arrayList.get(i).getLazyVariable());
        }
        stop();
        System.out.println("Executing time lazy 1: " + timeToString());
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
