package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.IOHelper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Cleaner {

    public static void main(String[] args) throws IOException {
        cleanup();
    }

    public static void cleanup() throws IOException {
        for (File file : Objects.requireNonNull(IOHelper.FOLDER_FILE.listFiles())) {
            if (!file.getName().equals(IOHelper.PROJECT_NAME)) {
                if (file.isDirectory()) {
                    FileUtils.deleteDirectory(file);
                } else FileUtils.forceDelete(file);
            }
        }
        System.out.println("Success!");
    }

}
