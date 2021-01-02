package ru.hzerr.util;

import ru.hzerr.IOHelper;

import java.io.IOException;

public class RuntimeReplacer {

    public static void main(String[] args) throws IOException, InterruptedException { replace(); }

    public static void replace() throws IOException, InterruptedException {
        String command = "cd " + IOHelper.FOLDER_FULL_NAME + " & jar uf " + IOHelper.PROJECT_TEST_NAME + " runtime";
        System.out.println("Runtime replace command: " + command);
        IOHelper.startNewProcessBuilderWithCmdExe(command);
    }
}
