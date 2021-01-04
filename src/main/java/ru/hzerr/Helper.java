package ru.hzerr;

import com.google.devtools.common.options.OptionsParser;

import java.io.IOException;

public class Helper {

    public static boolean startNewProcessBuilderWithCmdExe(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        return builder.inheritIO().start().waitFor() == 0;
    }

    public static GradleOptions parse(String... args) {
        OptionsParser parser = OptionsParser.newOptionsParser(GradleOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(GradleOptions.class);
    }
}
