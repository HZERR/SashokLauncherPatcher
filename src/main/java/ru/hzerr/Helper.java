package ru.hzerr;

import com.google.devtools.common.options.OptionsParser;

import java.io.IOException;

public class Helper {

    public static int startNewProcessBuilderWithCmdExe(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        int exitCode;
        System.out.println("Exit code: " + (exitCode = builder.inheritIO().start().waitFor()));
        return exitCode;
    }

    public static GradleOptions parse(String... args) {
        OptionsParser parser = OptionsParser.newOptionsParser(GradleOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(GradleOptions.class);
    }
}
