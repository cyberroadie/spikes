package net.transormatorhuis.junit.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import net.transformatorhuis.junit.util.MyFile;
import net.transformatorhuis.junit.util.MyFile.MyDoesNotFileExistException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class MyFileTest {

    public final static String FILENAME = "exercise.txt";
    public final String exerciseText =
            "Create a test to write the text of this exercise to the file system. The \n" +
            "test should read the file back in and make asseryions about the con-\n" +
            "tent. Ensure that you can run the test multiple times and have it pass.\n" +
            "Finally, make sure that there are no leftover files when the test fin-\n" +
            "ishes, even if an exception is thrown.";
    
    public MyFileTest() {
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
        }
    }

    @After
    public void deleteFile() {
        File exerciseFile = new File(FILENAME);
        if(exerciseFile.exists()) {
            exerciseFile.delete();
        }
    }

    /**
     * Test of getContentAsString method, of class MyFile.
     */
    @Test
    public void testGetContentAsStringDoesNotExistException() {
        MyFile myFile = new MyFile("null");
        try {
            myFile.getContentAsString();
            fail("Should thrown MyFileNotExistException");
        } catch (MyDoesNotFileExistException ex) {

        }
    }

    /**
     * Test of getContentAsString method, of class MyFile.
     */
    @Test
    public void testGetContentAsString() {
        MyFile myFile = new MyFile(FILENAME);
        String content = myFile.getContentAsString();
        assertEquals(320, content.length());
    }

    /**
     * Test of getContentAsList method, of class MyFile.
     */
    @Test
    public void testGetContentAsListDoesNotExistException() {
        MyFile myFile = new MyFile("null");
        try {
            myFile.getContentAsList();
            fail("Should thrown MyFileNotExistException");
        } catch (MyDoesNotFileExistException ex) {

        }
    }

    /**
     * Test of getContentAsList method, of class MyFile.
     */
    @Test
    public void testGetContentAsList() {
        MyFile myFile = new MyFile(FILENAME);
        List content = myFile.getContentAsList();
        assertEquals(5, content.size());

    }

    /**
     * Test of delete method, of class MyFile.
     */
    @Test
    public void testDelete() {
        final String TEMP_FILENAME = "test.txt";
        try {
            File file = new File(TEMP_FILENAME);
            file.createNewFile();
        } catch (IOException ex) {
            fail("Oops");
        }
        MyFile myFile = new MyFile(TEMP_FILENAME);
        myFile.delete();
        File file = new File(TEMP_FILENAME);
        assertFalse(file.exists());

    }

    /**
     * Test of overwrite method, of class MyFile.
     */
    @Test
    public void testOverwrite() {
    }

}