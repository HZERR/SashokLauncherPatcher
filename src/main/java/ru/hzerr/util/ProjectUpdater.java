package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;
import ru.hzerr.Helper;

import java.io.IOException;

public class ProjectUpdater {

    public static void main(String[] args) throws IOException, InterruptedException {
        update(Helper.parse(args));
    }

    public static void update(GradleOptions options) throws IOException, InterruptedException {
        String command = "cd " + options.folderFullName + " & jar uf " + options.projectTestName + " " + options.getFilesToBeUpdated();
        HLogger.info("Update command: " + command);
        if (Helper.startNewProcessBuilderWithCmdExe(command)) HLogger.success("The project has been successfully updated");
        else HLogger.warning("The update of the project ended with an error");
    }
}
