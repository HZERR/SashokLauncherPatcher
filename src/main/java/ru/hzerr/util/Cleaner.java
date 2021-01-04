package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.GradleOptions;
import ru.hzerr.Helper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Cleaner {

    public static void main(String[] args) throws IOException { cleanup(Helper.parse(args)); }

    public static void cleanup(GradleOptions options) throws IOException {
        for (File file : Objects.requireNonNull(options.getFolderFile().listFiles())) {
            if (!file.getName().equals(options.getProjectName())) {
                if (file.isDirectory()) {
                    FileUtils.deleteDirectory(file);
                } else FileUtils.forceDelete(file);
            }
        }
        System.out.println("The cleaning was successful");
    }
}
