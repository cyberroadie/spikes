package net.transformtorhuis.junit.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Test
    public void testDumpObject() {
        System.out.println(ObjectDumper.dumpObject(this));
    }

}