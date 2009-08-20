package net.transformatorhuis.junit.agilejava.proxy;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class StringDumpProxyTest {

    public StringDumpProxyTest() {
    }

    /**
     * Test of invoke method, of class StringDumpProxy.
     */
    @Test
    public void testWithProxy() throws Exception {
        StringDump stringDump = StringDumpFactory.createWithProxy();
        String output = stringDump.toString();
        System.out.println(output);
        assertTrue(output.startsWith("Field: test1 Type: String"));
        assertTrue(output.trim().endsWith("Field: test3 Type: String"));
    }

    @Test
    public void testWithoutProxy() {
        StringDump stringDump = StringDumpFactory.createWithoutProxy();
        String output = stringDump.toString();
        System.out.println(output);
        assertTrue(output.equals("Real thing"));
    }

}