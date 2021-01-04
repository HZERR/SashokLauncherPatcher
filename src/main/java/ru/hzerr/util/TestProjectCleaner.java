package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.GradleOptions;
import ru.hzerr.Helper;

import java.io.File;
import java.io.IOException;

public class TestProjectCleaner {

    public static void main(String[] args) throws IOException { cleanup(Helper.parse(args)); }

    public static void cleanup(GradleOptions options) throws IOException {
        FileUtils.forceDeleteOnExit(new File(options.folderFullName + File.separator + options.projectTestName));
        System.out.println("The cleaning was successful");
    }
}
