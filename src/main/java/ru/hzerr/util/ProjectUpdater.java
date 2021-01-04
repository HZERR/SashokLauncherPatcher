package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.Helper;

import java.io.IOException;

public class ProjectUpdater {

    public static void main(String[] args) throws IOException, InterruptedException {
        update(Helper.parse(args));
    }

    public static void update(GradleOptions options) throws IOException, InterruptedException {
        String command = "cd " + options.folderFullName + " & jar uf " + options.projectTestName + " " + options.getFilesToBeUpdated();
        System.out.println("Update command: " + command);
        Helper.startNewProcessBuilderWithCmdExe(command);
    }
}
