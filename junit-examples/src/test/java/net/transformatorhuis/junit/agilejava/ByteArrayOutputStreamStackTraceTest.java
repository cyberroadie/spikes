package net.transformatorhuis.junit.agilejava;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ByteArrayOutputStreamStackTraceTest {

    public ByteArrayOutputStreamStackTraceTest() {
    }

    @Test
    public void captureTest() {

        File file = new File("wrongdirectory/testfile.txt");
        try {
            file.createNewFile();
            fail("File creation should fail");
        } catch (IOException ex) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(baos));
            for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                try {
                    bufferedWriter.write(stackTraceElement.toString(), 0, stackTraceElement.toString().length());
                } catch (IOException ex1) {
                    fail(ex1.toString());
                }
            }

            try {
                bufferedWriter.close();
                System.out.print(baos.toString());
            } catch (IOException ex1) {
                fail(ex1.toString());
            }

        }
    }

}