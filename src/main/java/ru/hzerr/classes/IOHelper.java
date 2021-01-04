package ru.hzerr.classes;

import ru.hzerr.*;

public class IOHelper extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.ioHelperClassName)
                .filterByNames("getResourceURL")
                .addCode("return " + options.launcherClassName + ".class.getResource('/' + $1);")
                .insertBody();
    }
}
