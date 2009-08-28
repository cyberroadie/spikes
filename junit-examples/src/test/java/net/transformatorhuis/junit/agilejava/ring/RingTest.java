package net.transformatorhuis.junit.agilejava.ring;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RingTest {

    Ring<String> ring;

    public RingTest() {
    }

    @Before
    public void before() {
        ring = new Ring<String>();
        ring.add("test1");
        ring.add("test2");
        ring.add("test3");
        ring.add("test4");
    }

    /**
     * Test of get method, of class Ring.
     */
    @Test
    public void testGet() throws Exception {
        assertEquals("test4", ring.get());
    }

    /**
     * Test of remove method, of class Ring.
     */
    @Test
    public void testRemove() throws Exception {
        ring.remove();
        assertEquals("test3", ring.get());
    }

    /**
     * Test of back method, of class Ring.
     */
    @Test
    public void testBack() throws Exception {
        ring.back();
        assertEquals("test3", ring.get());
    }

    /**
     * Test of forward method, of class Ring.
     */
    @Test
    public void testForward() throws Exception {
        ring.forward();
        assertEquals("test1", ring.get());
    }

    /**
     * Test of add method, of class Ring.
     */
    @Test
    public void testAdd() throws Exception {
        ring.add("test5");
        assertEquals("test5", ring.get());
        ring.back();
        assertEquals("test4", ring.get());
        ring.forward();
        ring.forward();
        assertEquals("test1", ring.get());
    }

    @Test
    public void testIterator() {
        List<String> testList = new ArrayList<String>();
        for (String string : ring) {
            testList.add(string);
        }
        assertEquals("test4", testList.get(0));
        assertEquals("test1", testList.get(1));
        assertEquals("test2", testList.get(2));
        assertEquals("test3", testList.get(3));
    }
}