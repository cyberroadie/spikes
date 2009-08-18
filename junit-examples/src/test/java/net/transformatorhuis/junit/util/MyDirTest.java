package net.transformatorhuis.junit.util;

import net.transformatorhuis.junit.util.MyFile;
import java.io.File;
import java.util.List;
import net.transformatorhuis.junit.util.MyDir;
import net.transformatorhuis.junit.util.MyDir.MyDirException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class MyDirTest {

    public MyDirTest() {
    }

    /**
     * Test of ensureExists method, of class MyDir.
     */
    @Test
    public void testEnsureExists() {
        File directory = new File("test");
        File checkDirectory = null;
        directory.mkdir();
        try {
            MyDir myDir = new MyDir("test/test");
            checkDirectory = new File("test/test");
            assertTrue(!checkDirectory.exists());
            myDir.ensureExists();
            assertTrue(checkDirectory.exists());
        } catch (MyDirException ex) {
            fail(ex.toString());
        } finally {
            checkDirectory.delete();
            directory.delete();
        }
    }

    /**
     * Test of getFiles method, of class MyDir.
     */
    @Test
    public void testGetFiles() throws Exception {
        File directory = new File("test");
        directory.mkdir();
        File test1 = new File("test/test1");
        test1.createNewFile();
        File test2 = new File("test/test2");
        test2.createNewFile();
        MyDir myDir = new MyDir("test");
        List<MyFile> files = myDir.getFiles();
        assertEquals(2, files.size());
        test1.delete();
        test2.delete();
        directory.delete();
    }

    @Test
    public void testInstantiation() {
        MyDir.Attributes attributes = new MyDir.Attributes();
    }



}