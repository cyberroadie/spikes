package net.transformatorhuis.junit.agilejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class WriteTextToFileTest {

    public final static String FILENAME = "exercise.txt";
    public final String exerciseText =
            "Create a test to write the text of this exercise to the file system. The \n" +
            "test should read the file back in and make asseryions about the con-\n" +
            "tent. Ensure that you can run the test multiple times and have it pass.\n" +
            "Finally, make sure that there are no leftover files when the test fin-\n" +
            "ishes, even if an exception is thrown.";


    public WriteTextToFileTest() {
    }

    @BeforeClass
    public static void deleteFile() {
        File exerciseFile = new File(FILENAME);
        if(exerciseFile.exists()) {
            exerciseFile.delete();
        }

    }

    @AfterClass
    public static void cleanup() {
        deleteFile();
    }

    @Before
    public void fileWriteTest() {
        try {
            File exerciseFile = new File(FILENAME);
            FileWriter fw = new FileWriter(exerciseFile);
            fw.write(exerciseText);
            fw.close();
        } catch (IOException ex) {
            fail("File not written: " + ex.toString());
            deleteFile();
        } 
    }

    @Test
    public void checkFile() {
        FileReader fr = null;
        try {
            File exerciseFile = new File(FILENAME);
            assertTrue(exerciseFile.exists());
            fr = new FileReader(exerciseFile);
            BufferedReader br = new BufferedReader(fr);
            List<String> lines = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            assertEquals(5, lines.size());
        } catch (FileNotFoundException ex) {
            fail("File not found: " + ex.toString());
        } catch (IOException ex) {
            fail("IO exception: " + ex.toString());
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                fail("Error closing: " + ex.toString());
            }
        }
    }

}