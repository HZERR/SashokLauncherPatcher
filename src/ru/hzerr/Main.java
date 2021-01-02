package ru.hzerr;

import ru.hzerr.util.*;

import java.io.IOException;

@Deprecated
public class Main {

    @Deprecated
    public static void main(String[] args) throws IOException, InterruptedException {
        Unpack.unpack();
        ManifestChanger.change();
        Builder.build();
        ProjectUpdater.update();
        Starter.startup();
    }
}
