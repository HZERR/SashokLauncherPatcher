package ru.hzerr.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class JFoenixAppender {

    public static void main(String[] args) {
        addJFoenixLibrary(GradleOptions.getGradleOptions(args));
    }

    public static void addJFoenixLibrary(GradleOptions options) {
        File jfoenix8 = new File(options.getFolderFile(), "jfoenix-8.0.10.jar");
        try {
            Files.copy(JFoenixAppender.class.getResourceAsStream("/jfoenix-8.0.10.jar"), jfoenix8.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException io) {
            HLogger.error("The copying of the \"JFoenix\" library ended with an error", io);
        }
        ZipFile jfoenix8Zip = new ZipFile(jfoenix8);
        try {
            jfoenix8Zip.extractAll(options.getFolderFullName());
            HLogger.success("The \"JFoenix\" library was successfully unpacked");
        } catch (ZipException e) {
            HLogger.error("The \"JFoenix\" library was added to the project in error", e);
        }
        ZipFile projectTestZipFile = new ZipFile(options.getProjectTestFile());
        try {
            projectTestZipFile.addFolder(new File(options.getFolderFile(), "com"));
            HLogger.success("The \"JFoenix\" library was successfully added to the project");
        } catch (ZipException e) {
            HLogger.error("The \"JFoenix\" library was added to the project in error", e);
        }
        jfoenix8.deleteOnExit();
    }
}
