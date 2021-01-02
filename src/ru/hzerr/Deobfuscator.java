package ru.hzerr;

public enum Deobfuscator {

    SECURITY_HELPER("launcher.KeepErJeRrY4b2"),
    LAUNCHER("launcher.keEpErjeRRYsAK");

    private final String className;

    Deobfuscator(String classname) {
        this.className = classname;
    }

    public String getClassName() { return className; }
}
