package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class JFoenixAppender {

    public static void main(String[] args) throws IOException, InterruptedException {
        addJFoenixLibrary();
    }

    public static void addJFoenixLibrary() throws IOException, InterruptedException {
        File jfoenix8 = new File(IOHelper.FOLDER_FULL_NAME + File.separator + "jfoenix-8.0.10.jar");
        Files.copy(JFoenixAppender.class.getResourceAsStream("/jfoenix-8.0.10.jar"), jfoenix8.toPath(), StandardCopyOption.REPLACE_EXISTING);
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar xf jfoenix-8.0.10.jar";
        System.out.println("Unpack command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
        command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar uf " + IOHelper.PROJECT_TEST_NAME + " com";
        System.out.println("Update command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
        jfoenix8.deleteOnExit();
    }
}
