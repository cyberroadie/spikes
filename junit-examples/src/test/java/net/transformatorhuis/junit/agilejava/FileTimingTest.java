package net.transformatorhuis.junit.agilejava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class FileTimingTest {

    static final String FILENAME = "test.txt";
    static final int MAX = 7;
    long start;
    long stop;
    static long[] sizes = new long[MAX];
    Writer writer;

    @BeforeClass
    public static void createSizeArray() {
        sizes[0] = 10;
        for (int i = 1; i < MAX; i++) {
            sizes[i] = sizes[i - 1] * 10;
        }
    }

    @Test
    public void perChar() {
        System.out.println("Per character:");
        for (long size : sizes) {
            try {
                writer = new FileWriter(new File(FILENAME));
                writeFileData(size);
            } catch (IOException ex) {
                fail("IOException: " + ex.toString());
            }
        }
    }

    @Test
    public void buffered() {
        System.out.println("Buffered:");
        for (long size : sizes) {
            try {
                writer = new BufferedWriter(new FileWriter(new File(FILENAME)));
                writeFileData(size);
            } catch (IOException ex) {
                fail("IOException: " + ex.toString());
            }
        }
    }

    private void writeFileData(long size) {
        try {
            System.out.println("File size: " + size);
            start();
            for (int i = 0; i < size; i++) {
                writer.write('x');
            }
            writer.close();
            stop();
            System.out.println("Elapsed time (" + size + "): " + elapsedTimeMillis());
        } catch (IOException ex) {
            delete();
            fail("IOException: " + ex.toString());
        } finally {
            delete();
        }


    }

    private void start() {
        start = System.currentTimeMillis(); // start timing
    }

    private void stop() {
        stop = System.currentTimeMillis(); // stop timing
    }

    private long elapsedTimeMillis() {
        return stop - start;
    }

    private void delete() {
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }
}
