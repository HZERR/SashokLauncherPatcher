package ru.hzerr.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

public class JFoenixCleaner {

    public static void main(String[] args) throws ZipException {
        removeJFoenixLibrary(GradleOptions.getGradleOptions(args));
    }

    public static void removeJFoenixLibrary(GradleOptions options) throws ZipException {
        ZipFile testProjectZip = new ZipFile(options.getProjectTestFile());
        List<FileHeader> headers = new CopyOnWriteArrayList<>(testProjectZip.getFileHeaders());
        headers.stream().map(FileHeader::getFileName).forEach(System.out::println);
        Pattern jfoenixPattern = Pattern.compile("^com\\W{1,2}jfoenix\\W{1,2}$");
        headers.removeIf(header -> !jfoenixPattern.matcher(header.getFileName()).matches());
        try {
            testProjectZip.removeFile(headers.get(0));
        } catch (ZipException e) {
            HLogger.error("Error deleting the \"JFoenix\" library", e);
        }
    }
}
