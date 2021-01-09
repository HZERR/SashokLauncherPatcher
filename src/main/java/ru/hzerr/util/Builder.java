package ru.hzerr.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Builder {

    public static void main(String[] args) {
        build(GradleOptions.getGradleOptions(args));
    }

    public static void build(GradleOptions options) {
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(options.getFolderFile().listFiles())));
        files.removeIf(file -> file.getName().equals(options.getProjectName()) || file.getName().equals(options.projectTestName));

        ZipFile project = new ZipFile(new File(options.getFolderFile(), options.projectTestName));
        try {
            for (File file : files) {
                if (file.isDirectory()) project.addFolder(file);
                else project.addFile(file);
            }
            HLogger.success("The assembly was successful");
        } catch (ZipException e) { HLogger.error("The build ended with an error", e); }
    }
}
