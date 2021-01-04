package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;
import ru.hzerr.Helper;

import java.io.IOException;

public class Unpack {

    public static void main(String[] args) throws IOException, InterruptedException { unpack(Helper.parse(args)); }

    public static void unpack(GradleOptions options) throws IOException, InterruptedException {
        String command = "cd " + options.folderFullName + " & jar xf " + options.getProjectName();
        HLogger.info("Unpack command: " + command);
        if (Helper.startNewProcessBuilderWithCmdExe(command)) HLogger.success("The project has been successfully unpacked");
        else HLogger.warning("Unpacking the project ended with an error");
    }
}
