package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.IOException;

public class ProjectUpdater {

    private static final String CHANGE_FILE_NAMES = "com buildnumber";

    public static void main(String[] args) throws IOException, InterruptedException { update(); }

    public static void update() throws IOException, InterruptedException {
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar uf " + IOHelper.PROJECT_TEST_NAME + " " + CHANGE_FILE_NAMES;
        System.out.println("Update command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }

    private static class LauncherUpdater {

        public static void main(String[] args) throws IOException, InterruptedException { update(); }

        public static void update() throws IOException, InterruptedException {
            String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar uf " + IOHelper.PROJECT_TEST_NAME + " launcher";
            System.out.println("Update command: " + command);
            IOHelper.startNewProcessBuilderWithCmdExe(command);
        }
    }
}
