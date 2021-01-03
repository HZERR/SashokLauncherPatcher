package ru.hzerr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOHelper {

    public static final String FOLDER_FULL_NAME = "C:\\Users\\HZERR\\Desktop\\TestHackMW";
    public static final String PROJECT_FULL_NAME = "C:\\Users\\HZERR\\Desktop\\TestHackMW\\MythicalWorld.jar";
    public static final String PROJECT_NAME = Paths.get(PROJECT_FULL_NAME).getFileName().toString();
    public static final Path PATH_TO_FOLDER = Paths.get(FOLDER_FULL_NAME);
    public static final Path PATH_TO_PROJECT = Paths.get(PROJECT_FULL_NAME);
    public static final File PROJECT_FILE = new File(PROJECT_FULL_NAME);
    public static final File FOLDER_FILE = new File(FOLDER_FULL_NAME);

    public static String PROJECT_TEST_NAME = "MythicalWorldTest.jar";

    public static void startNewProcessBuilderWithCmdExe(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        System.out.println("Exit code: " + builder.inheritIO().start().waitFor());
    }
}
