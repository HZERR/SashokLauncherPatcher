package ru.hzerr.classes;

import ru.hzerr.*;

public class LogHelper extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        MethodByteCodeBuilder b = ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.logHelperClassName).filterByNames("isDebugEnabled");
        if (options.isDebugEnabled) b.setBodyReturnTrue();
        else b.setBodyReturnFalse();
        return b.concatMethodByteCodeBuilder()
                .filterByNames("printVersion")
                .addCode("println(\"" + options.launcherName + " \" + $1 + \" v" + options.launcherVersion + " (build #\" + " + options.launcherClassName + ".BUILD + \")\");")
                .insertBody();
    }
}
