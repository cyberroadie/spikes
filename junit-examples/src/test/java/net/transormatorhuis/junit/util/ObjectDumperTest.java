package net.transormatorhuis.junit.util;

import net.transformatorhuis.junit.util.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author cyberroadie
 */
public class ObjectDumperTest {

    public int test;
    private ObjectDumper test2;
    
    public ObjectDumperTest() {
    }

    /**
     * Test of dumpObject method, of class ObjectDumper.
     */
    @Ignore
    @Test
    public void testDumpObject() {
        System.out.println(ObjectDumper.dumpObject(this));
    }

}