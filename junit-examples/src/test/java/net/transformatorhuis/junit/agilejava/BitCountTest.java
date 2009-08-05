package net.transformatorhuis.junit.agilejava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BitCountTest {

    @Test
    public void countBitsChar() {
        char a = Character.MAX_VALUE;
        
        for (int i = 0; i < 8; i++) {
            System.out.println("Char: " + Integer.toBinaryString(a));
            a = (char) (a >>> 1);
            System.out.println("Count: " + (i + 1));
        }
    }

    @Test
    public void countBitsByte() {
        byte a = Byte.MAX_VALUE;

        for (int i = 0; i < 8; i++) {
            System.out.println("Byte: " + Integer.toBinaryString(a));
            a = (byte) (a >>> 1);
            System.out.println("Count: " + (i + 1));
        }
    }

    @Test
    public void countBitsShort() {
        short a = Short.MAX_VALUE;

        for (int i = 0; i < 16; i++) {
            System.out.println("Short: " + Integer.toBinaryString(a));
            a = (short) (a >>> 1);
            System.out.println("Count: " + (i + 1));
        }
    }

    @Test
    public void countBitsInt() {
        int a = Integer.MAX_VALUE;

        for (int i = 0; i < 32; i++) {
            System.out.println("Int: " + Integer.toBinaryString(a));
            a = (int) (a >>> 1);
            System.out.println("Count: " + (i + 1));
        }
    }

    @Test
    public void countBitsLong() {
        long a = Long.MAX_VALUE;

        for (int i = 0; i < 64; i++) {
            System.out.println("Long: " + Long.toBinaryString(a));
            a = (long) (a >>> 1);
            System.out.println("Count: " + (i + 1));
        }
    }
}