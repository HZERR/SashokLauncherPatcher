package ru.hzerr.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

public class Unpack {

    public static void main(String[] args) {
        unpack(GradleOptions.getGradleOptions(args));
    }

    public static void unpack(GradleOptions options) {
        ZipFile project = new ZipFile(options.getProjectFullName());
        try {
            project.extractAll(options.getFolderFullName());
        } catch (ZipException e) { HLogger.error("Unpacking the project ended with an error", e); }
        HLogger.success("The project has been successfully unpacked");
    }
}
