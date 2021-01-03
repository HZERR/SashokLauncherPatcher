package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.File;
import java.io.IOException;

public class Builder {

    public static void main(String[] args) throws IOException, InterruptedException { build(); }

    public static void build() throws IOException, InterruptedException {
        File[] files = IOHelper.FOLDER_FILE.listFiles();
        StringBuilder namesBuilder = new StringBuilder();
        if (files != null) {
            for (File file : files) {
                if (!file.getName().equals(IOHelper.PROJECT_NAME) && !file.getName().equals(IOHelper.PROJECT_TEST_NAME)) {
                    namesBuilder.append(file.getName()).append(' ');
                }
            }
            namesBuilder.setLength(namesBuilder.length() - 1);
        }
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar cvfm " + IOHelper.PROJECT_TEST_NAME + " META-INF\\MANIFEST.MF -C " + namesBuilder.toString();
        System.out.println("Build command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }
}
