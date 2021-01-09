package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Cleaner {

    public static void main(String[] args) throws IOException {
        cleanup(GradleOptions.getGradleOptions(args));
    }

    public static void cleanup(GradleOptions options) throws IOException {
        File[] files = options.getFolderFile().listFiles();
        boolean completed = false;
        if (files != null) {
            for (File file : files) {
                if (!file.getName().equals(options.getProjectName())) {
                    completed = true;
                    if (file.isDirectory()) {
                        FileUtils.deleteDirectory(file);
                    } else FileUtils.forceDelete(file);
                }
            }
            if (completed) HLogger.success("The cleaning was successful");
            else HLogger.info("There's nothing to clean up");
        } else HLogger.info("There's nothing to clean up");
    }
}
