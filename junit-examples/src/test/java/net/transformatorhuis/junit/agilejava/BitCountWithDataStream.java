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
        System.out.println("Char: " + Integer.toBinaryString(a));
        System.out.println("Count: " + bytes.length * 8);

    }

    @Test
    public void countBitsByte() {
        byte a = Byte.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        System.out.println("Byte: " + Integer.toBinaryString(a));
        System.out.println("Count: " + bytes.length * 8);
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void countBitsShort() {
        short a = Short.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        System.out.println("Short: " + a);
        System.out.println("Count: " + bytes.length * 8);
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void countBitsInt() {
        int a = Integer.MAX_VALUE;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(a);
        byte[] bytes = output.toByteArray();
        System.out.println("Short: " + Integer.toBinaryString(a));
        System.out.println("Count: " + bytes.length * 8);
        try {
            output.close();
        } catch (IOException ex) {
            fail();
        }
    }
}
