package net.transformatorhuis.junit.agilejava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class PrecisionTest {

    public PrecisionTest() {
    }

    @Test
    public void floatPrecisionTest()  {
        float a = 0.9f;
        float b = 0.05f * 2.0f;
        assertEquals(a, b, 0.8);
    }

    @Test
    public void doublePrecisionTest()  {
        double a = 0.9d;
        double b = 0.05d * 2.0d;
        assertEquals(a, b, 0.8);
    }

    public void compileTest() {
//        float x = 0.01;
        float x = 0.01f;
        float y = (float) 0.01;
    }
}