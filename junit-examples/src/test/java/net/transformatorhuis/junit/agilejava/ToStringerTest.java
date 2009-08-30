package net.transformatorhuis.junit.agilejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ToStringerTest {

    public ToStringer toStringer;
    @Dump(order = 2, outputMethod={"toSimpleType"})
    public String test1 = "test1";
    @Dump(order = 1)
    public String test2 = "test2";
    @Dump(outputMethod={"toType","toString"})
    public String test3 = "test3";
    @Dump
    public String test4 = "test4";
    @Dump(order = 5, quote = true)
    public String test5 = "test5";

    public ToStringerTest() {
    }

    @Before
    public void setup() {
        toStringer = new ToStringer();
    }

    /**
     * Test of analyze method, of class ToStringer.
     */
    @Test
    public void testAnalyze() throws IOException {
        toStringer.analyze(this);
        String out = toStringer.toString();
        System.out.println(out);
        assertTrue(out.length() > 0);
        BufferedReader br = new BufferedReader(new StringReader(out));
        List<String> lines = new ArrayList<String>();
        String line;
        while((line = br.readLine()) != null) {
            lines.add(line);
        }
        assertTrue(lines.get(0).trim().endsWith("test2"));
        assertTrue(lines.get(1).equals("String type."));
        assertTrue(lines.get(2).trim().endsWith("test5'"));
        assertTrue(lines.get(2).startsWith("'"));
        assertTrue(lines.get(3).trim().endsWith("test3"));
        assertTrue(lines.get(3).trim().startsWith("java.lang.String type."));
        assertTrue(lines.get(4).trim().endsWith("test4"));

    }

}