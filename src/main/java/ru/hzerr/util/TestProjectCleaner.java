package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.File;
import java.io.IOException;

public class TestProjectCleaner {

    public static void main(String[] args) {
        cleanup(GradleOptions.getGradleOptions(args));
    }

    public static void cleanup(GradleOptions options) {
        try {
            FileUtils.forceDelete(new File(options.getFolderFile(), options.getProjectTestName()));
        } catch (IOException io) {
            HLogger.error("The cleanup of the test project ended with an error", io);
        }
        HLogger.success("The built project is successfully deleted");
    }
}
