package net.transformatorhuis.junit.agilejava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BitCountWithDataStream {

    @Test
    public void countBitsChar() {
        char a = Character.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        String bitString = Integer.toBinaryString(a);
        System.out.println("Char: " + bitString);
        System.out.println("Count: " + bitString.length());

        int bitCount = 0;
        while(a > 0) {
            a = (char) (a & (a - 1));
            bitCount++;
        }
        System.out.println("Bit Count: " + bitCount);
    }

    @Test
    public void countBitsByte() {
        byte a = Byte.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        String bitString = Integer.toBinaryString(a);
        System.out.println("Char: " + bitString);
        System.out.println("Count: " + bitString.length());
        
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }

        int bitCount = 0;
        while(a > 0) {
            a = (byte) (a & (a - 1));
            bitCount++;
        }
        System.out.println("Bit Count: " + bitCount);

    }

    @Test
    public void countBitsShort() {
        short a = Short.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        String bitString = Integer.toBinaryString(a);
        System.out.println("Char: " + bitString);
        System.out.println("Count: " + bitString.length());
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }

        int bitCount = 0;
        while(a > 0) {
            a = (short) (a & (a - 1));
            bitCount++;
        }
        System.out.println("Bit Count: " + bitCount);

    }

    @Test
    public void countBitsInt() {
        int a = Integer.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        String bitString = Integer.toBinaryString(a);
        System.out.println("Char: " + bitString);
        System.out.println("Count: " + bitString.length());
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }

        int bitCount = 0;
        while(a > 0) {
            a = (int) (a & (a - 1));
            bitCount++;
        }
        System.out.println("Bit Count: " + bitCount);

    }

    @Test
    public void countBitsLong() {
        long a = Long.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String bitString = Long.toBinaryString(a);
        System.out.println("Char: " + bitString);
        System.out.println("Count: " + bitString.length());
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }

        int bitCount = 0;
        while(a > 0) {
            a = (long) (a & (a - 1));
            bitCount++;
        }
        System.out.println("Bit Count: " + bitCount);

    }
}
