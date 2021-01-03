package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.IOHelper;

import java.io.File;
import java.io.IOException;

public class TestProjectCleaner {

    public static void main(String[] args) throws IOException {
        cleanup();
    }

    public static void cleanup() throws IOException {
        FileUtils.forceDeleteOnExit(new File(IOHelper.FOLDER_FULL_NAME + File.separator + IOHelper.PROJECT_TEST_NAME));
        System.out.println("Success!");
    }
}
