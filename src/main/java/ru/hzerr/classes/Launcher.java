package ru.hzerr.classes;

import ru.hzerr.*;

public class Launcher extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.launcherClassName)
                .filterByNames("getResourceURL")
                .addCode("return " + options.ioHelperClassName + ".getResourceURL(\"runtime/\" + $1);")
                .insertBody();
    }
}
