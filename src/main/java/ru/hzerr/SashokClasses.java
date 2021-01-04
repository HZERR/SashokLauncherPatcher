package ru.hzerr;

import ru.hzerr.classes.*;
import ru.hzerr.classes.IOHelper;

import java.util.Arrays;

public enum SashokClasses {

    CLIENT_LAUNCHER(new ClientLauncher()),
    SECURITY_HELPER(new SecurityHelper()),
    IO_HELPER(new IOHelper()),
    LAUNCHER(new Launcher()),
    LOG_HELPER(new LogHelper());

    private final SashokClass sashokClass;

    SashokClasses(SashokClass sashokClass) {
        this.sashokClass = sashokClass;
    }

    public static void doTransform(GradleOptions options) {
        Arrays.stream(values()).forEach(sashokClass -> sashokClass.sashokClass.doTransform(options));
    }
}
