package ru.hzerr;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class HLogger {

    public static void success(String message) {
        System.out.println(Ansi.ansi().bold().fg(Ansi.Color.GREEN).a(message).reset());
    }

    public static void warning(String message) {
        System.out.println(Ansi.ansi().bold().fg(Ansi.Color.RED).a(message).reset());
    }

    public static void info(String message) {
        System.out.println(Ansi.ansi().bold().fg(Ansi.Color.BLUE).a(message).reset());
    }

    public static void error(String message, Exception e) {
        System.out.println(Ansi.ansi().bold().fg(Ansi.Color.RED).a(message).reset());
        e.printStackTrace();
    }

    static {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();
    }
}
