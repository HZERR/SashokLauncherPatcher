package ru.hzerr.util;

import javassist.ClassPool;
import javassist.LoaderClassPath;
import ru.hzerr.IOHelper;
import ru.hzerr.SashokClasses;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class Transformator {

    public static void main(String[] args) throws IOException {
        doTransform();
    }

    public static void doTransform() throws IOException {
        URLClassLoader classLoader = new URLClassLoader(new URL[] {IOHelper.PATH_TO_PROJECT.toUri().toURL()});
        LoaderClassPath loaderClassPath = new LoaderClassPath(classLoader);
        ClassPool.getDefault().appendClassPath(loaderClassPath);
        SashokClasses.doTransform();
        ClassPool.getDefault().removeClassPath(loaderClassPath);
        classLoader.close();
    }
}
