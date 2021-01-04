package ru.hzerr.classes;

import ru.hzerr.*;

public class ClientLauncher extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.clientLauncherClassName)
                .filterByNames("verifyHDir")
                .setEmptyBody();
    }
}
