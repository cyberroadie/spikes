package net.transformatorhuis.junit.util;

import org.junit.Ignore;
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
    @Ignore
    @Test
    public void testDumpObject() {
        String dump = ObjectDumper.dumpObject(this);
        System.out.println(dump);
        assertTrue(dump.startsWith("Field: test Type: int"));
        assertTrue(dump.trim().endsWith("-Field: depth Type: int (static)"));
    }

}