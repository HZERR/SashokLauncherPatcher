package ru.hzerr.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.File;

public class ProjectUpdater {

    public static void main(String[] args) {
        update(GradleOptions.getGradleOptions(args));
    }

    public static void update(GradleOptions options) {
        ZipFile projectTestZip = new ZipFile(options.getProjectTestFile());
        try {
            for (String name : options.getFilesToBeUpdated()) {
                File file = new File(options.getFolderFile(), name);
                if (file.isDirectory()) projectTestZip.addFolder(file);
                else projectTestZip.addFile(file);
            }
            HLogger.success("The project has been successfully updated");
        } catch (ZipException e) {
            HLogger.error("The update of the project ended with an error", e);
        }
    }
}
