package ru.hzerr.util;

import ru.hzerr.GradleOptions;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {
        startup(GradleOptions.getGradleOptions(args));
    }

    public static void startup(GradleOptions options) throws IOException {
        new ProcessBuilder("java", "-jar", options.getProjectTestFullName()).inheritIO().start();
    }
}
