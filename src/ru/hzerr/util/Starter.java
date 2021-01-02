package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException, InterruptedException { startup(); }

    public static void startup() throws IOException, InterruptedException {
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & java -jar " + IOHelper.PROJECT_TEST_NAME;
        System.out.println("Start command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }
}
