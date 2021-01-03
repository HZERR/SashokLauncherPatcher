package ru.hzerr.classes;

import ru.hzerr.*;

public class LogHelper extends SashokClass {

    private static final String className = Deobfuscator.LOG_HELPER.getClassName();

    @Override
    public ByteCodeBuilder transform() {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(className)
                .filterByNames("isDebugEnabled")
                .setBodyReturnTrue()
                .concatMethodByteCodeBuilder()
                .filterByNames("printVersion")
                .addCode("println(\"" + HPatcher.LAUNCHER_NAME + " \" + $1 + \" " + HPatcher.LAUNCHER_VERSION + " (build #\" + " + Deobfuscator.LAUNCHER.getClassName() + ".BUILD + \")\");")
                .insertBody();
    }
}
