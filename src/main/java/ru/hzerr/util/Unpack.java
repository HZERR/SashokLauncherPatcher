package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.IOException;

public class Unpack {

    public static void main(String[] args) throws IOException, InterruptedException { unpack(); }

    public static void unpack() throws IOException, InterruptedException {
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar xf " + IOHelper.PROJECT_NAME;
        System.out.println("Unpack command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }
}
