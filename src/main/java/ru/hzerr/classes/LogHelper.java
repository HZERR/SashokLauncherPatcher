package ru.hzerr.classes;

import ru.hzerr.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class LogHelper extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        MethodByteCodeBuilder b = ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.logHelperClassName).filterByNames("isDebugEnabled");
        if (options.isDebugEnabled) b.setBodyReturnTrue();
        else {
            b.addCode("          java.lang.reflect.Field[] fields = " + options.logHelperClassName + ".class.getDeclaredFields();\n" +
                    "            for (int i = 0; i < fields.length; i++) {\n" +
                    "                if (fields[i].getType().equals(java.util.concurrent.atomic.AtomicBoolean.class)) {\n" +
                    "                    try {\n" +
                    "                        return ((java.util.concurrent.atomic.AtomicBoolean) fields[i].get(null)).get();\n" +
                    "                    } catch (java.lang.IllegalAccessException e) { e.printStackTrace(); }\n" +
                    "                }\n" +
                    "            }\n" +
                    "            return false;").addBlockPoints().insertBody();
        }
        return b.concatMethodByteCodeBuilder()
                .filterByNames("printVersion")
                .addCode("println(\"" + options.launcherName + " \" + $1 + \" v" + options.launcherVersion + " (build #\" + " + options.launcherClassName + ".BUILD + \")\");")
                .insertBody();
    }
}
