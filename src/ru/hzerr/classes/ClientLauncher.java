package ru.hzerr.classes;

import ru.hzerr.ByteCodeBuilder;
import ru.hzerr.ByteCodeBuilderFactory;
import ru.hzerr.Deobfuscator;
import ru.hzerr.SashokClass;

public class ClientLauncher extends SashokClass {

    private static final String className = Deobfuscator.CLIENT_LAUNCHER.getClassName();

    @Override
    public ByteCodeBuilder transform() {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(className)
                .filterByNames("verifyHDir")
                .setEmptyBody();
    }
}
