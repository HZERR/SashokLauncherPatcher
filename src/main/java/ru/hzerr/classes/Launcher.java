package ru.hzerr.classes;

import ru.hzerr.ByteCodeBuilder;
import ru.hzerr.ByteCodeBuilderFactory;
import ru.hzerr.Deobfuscator;
import ru.hzerr.SashokClass;

public class Launcher extends SashokClass {

    private static final String className = Deobfuscator.LAUNCHER.getClassName();

    @Override
    public ByteCodeBuilder transform() {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(className)
                .filterByNames("getResourceURL")
                .addCode("return launcher.KeepErjERryKEt.getResourceURL(\"runtime/\" + $1);")
                .insertBody();
    }
}
