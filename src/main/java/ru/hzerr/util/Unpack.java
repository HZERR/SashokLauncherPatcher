package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.Helper;

import java.io.IOException;

public class Unpack {

    public static void main(String[] args) throws IOException, InterruptedException { unpack(Helper.parse(args)); }

    public static void unpack(GradleOptions options) throws IOException, InterruptedException {
        String command = "cd " + options.folderFullName + " & jar xf " + options.getProjectName();
        System.out.println("Unpack command: " + command);
        Helper.startNewProcessBuilderWithCmdExe(command);
    }
}
