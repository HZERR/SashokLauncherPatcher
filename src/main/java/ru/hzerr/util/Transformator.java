package ru.hzerr.util;

import javassist.ClassPool;
import javassist.LoaderClassPath;
import ru.hzerr.GradleOptions;
import ru.hzerr.Helper;
import ru.hzerr.SashokClasses;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class Transformator {

    public static void main(String[] args) throws IOException { doTransform(Helper.parse(args)); }

    public static void doTransform(GradleOptions options) throws IOException {
        URLClassLoader classLoader = new URLClassLoader(new URL[] {options.getProjectPath().toUri().toURL()});
        LoaderClassPath loaderClassPath = new LoaderClassPath(classLoader);
        ClassPool.getDefault().appendClassPath(loaderClassPath);
        SashokClasses.doTransform(options);
        ClassPool.getDefault().removeClassPath(loaderClassPath);
        classLoader.close();
    }
}
