package net.transformtorhuis.junit.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class MyDir {

    File directory;

    public MyDir(String directoryName) throws MyDirException {
        directory = new File(directoryName);
        if (directory.isFile()) {
            throw new MyDirException("Is not a directory");
        }
    }

    public void ensureExists() {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public class MyDirException extends Exception {

        private MyDirException(String string) {
            super(string);
        }
    }

    public List<MyFile> getFiles() throws MyDirException {
        if(!directory.exists()) {
            throw new MyDirException("Directory doesn't exist");
        }
        File[] files = directory.listFiles();
        List<MyFile> myFiles = new ArrayList<MyFile>();
        for (File file : files) {
            myFiles.add(new MyFile(file.getName()));
        }
        return myFiles;
    }

    public static class Attributes {
        boolean readOnly = false;
        boolean hidden = false;

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public boolean isReadOnly() {
            return readOnly;
        }

        public void setReadOnly(boolean readOnly) {
            this.readOnly = readOnly;
        }

    }

}
