package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;
import ru.hzerr.Helper;

import java.io.File;
import java.io.IOException;

public class Builder {

    public static void main(String[] args) throws IOException, InterruptedException { build(Helper.parse(args)); }

    public static void build(GradleOptions options) throws IOException, InterruptedException {
        File[] files = options.getFolderFile().listFiles();
        StringBuilder namesBuilder = new StringBuilder();
        if (files != null) {
            for (File file : files) {
                if (!file.getName().equals(options.getProjectName()) && !file.getName().equals(options.projectTestName)) {
                    namesBuilder.append(file.getName()).append(' ');
                }
            }
            namesBuilder.setLength(namesBuilder.length() - 1);
        }

        String command = "cd " + options.folderFullName + " & jar cvfm " + options.projectTestName + " META-INF\\MANIFEST.MF -C " + namesBuilder.toString();
        HLogger.info("Build command: " + command);
        if (Helper.startNewProcessBuilderWithCmdExe(command)) HLogger.success("The assembly was successful");
        else HLogger.warning("The build ended with an error");
    }
}
