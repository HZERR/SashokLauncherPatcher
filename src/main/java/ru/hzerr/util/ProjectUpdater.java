package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ProjectUpdater {

    private static final StringBuilder CHANGE_FILE_NAMES = new StringBuilder();

    public static void main(String[] args) throws IOException, InterruptedException {
        CHANGE_FILE_NAMES.append(Arrays.stream(args).map(arg -> arg + " ").collect(Collectors.joining()));
        update();
    }

    public static void update() throws IOException, InterruptedException {
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar uf " + IOHelper.PROJECT_TEST_NAME + " " + CHANGE_FILE_NAMES;
        System.out.println("Update command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }
}
