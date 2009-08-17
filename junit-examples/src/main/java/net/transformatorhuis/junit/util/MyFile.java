package net.transformatorhuis.junit.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class MyFile {

    File testFile;
    Logger logger = Logger.getLogger(MyFile.class.getName());

    public MyFile(String fileName) {
        this.testFile = new File(fileName);
    }

    public String getContentAsString() {
        if (!testFile.exists()) {
            throw new MyDoesNotFileExistException();
        }
        StringBuilder contents = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testFile));
            String line;
            while((line = reader.readLine()) != null) {
                contents.append(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
        return contents.toString();
    }

    public List getContentAsList() {
        if (!testFile.exists()) {
            throw new MyDoesNotFileExistException();
        }
        List<String> contents = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testFile));
            String line;
            while((line = reader.readLine()) != null) {
                contents.add(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
            return new ArrayList();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            return new ArrayList();
        } 
        return contents;
    }

    public void delete() {
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    public void overwrite() throws IOException {
        if (testFile.exists()) {
            testFile.delete();
        }
        testFile.createNewFile();
    }

    public class MyDoesNotFileExistException extends RuntimeException {
    }
}
