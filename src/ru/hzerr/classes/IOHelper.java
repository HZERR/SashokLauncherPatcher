package ru.hzerr.classes;

import ru.hzerr.ByteCodeBuilder;
import ru.hzerr.ByteCodeBuilderFactory;
import ru.hzerr.Deobfuscator;
import ru.hzerr.SashokClass;

public class IOHelper extends SashokClass {

    private static final String className = Deobfuscator.IO_HELPER.getClassName();

    @Override
    public ByteCodeBuilder transform() {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(className)
                .filterByNames("getResourceURL")
                .addCode("return " + Deobfuscator.LAUNCHER.getClassName() + ".class.getResource('/' + $1);")
                .insertBody();
    }
}
