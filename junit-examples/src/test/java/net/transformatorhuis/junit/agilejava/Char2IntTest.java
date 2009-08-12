package net.transformatorhuis.junit.agilejava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class Char2IntTest {

    public Char2IntTest() {
    }

    @Test
    public void char2Int() {
        for (int i = 0; i < 200; i++) {
            System.out.println("No: " + i + ": " + ((char) i));
        }
    }
}