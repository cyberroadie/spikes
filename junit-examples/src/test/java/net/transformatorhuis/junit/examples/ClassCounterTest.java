package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * @auther Olivier Van Acker (cyberroadie@gmail.com)
 * Date: 13-Jun-2009
 */
public class ClassCounterTest {

    @Test
    public void count() {
        ClassCounter classCounter1 = ClassCounter.createClassCounter();

        ClassCounter classCounter2 = ClassCounter.createClassCounter();

        // Counter is the same for both because it's a class variable
        assertEquals(classCounter2.getCount(), classCounter1.getCount());
        
    }
}
