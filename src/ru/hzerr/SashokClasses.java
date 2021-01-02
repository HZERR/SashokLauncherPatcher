package ru.hzerr;

import ru.hzerr.classes.Launcher;
import ru.hzerr.classes.SecurityHelper;

import java.util.Arrays;

public enum SashokClasses {
    LAUNCHER(new Launcher()),
    SECURITY_HELPER(new SecurityHelper());

    private final SashokClass sashokClass;

    SashokClasses(SashokClass sashokClass) {
        this.sashokClass = sashokClass;
    }

    public static void doTransform() {
        Arrays.stream(values()).forEach(sashokClass -> sashokClass.sashokClass.doTransform());
    }
}
