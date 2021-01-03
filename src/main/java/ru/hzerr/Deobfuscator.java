package ru.hzerr;

public enum Deobfuscator {

    SECURITY_HELPER("launcher.KeepErJeRrY4b2"),
    CLIENT_LAUNCHER("launcher.keEpErjeRRYsAK"),
    IO_HELPER("launcher.KeepErjERryKEt"),
    LAUNCHER("launcher.keepErJErRy6HE"),
    LOG_HELPER("launcher.KEePErJeRRygYU");

    private final String className;

    Deobfuscator(String classname) {
        this.className = classname;
    }

    public String getClassName() { return className; }
}
