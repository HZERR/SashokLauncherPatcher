package ru.hzerr.classes;

import ru.hzerr.ByteCodeBuilder;
import ru.hzerr.ByteCodeBuilderFactory;
import ru.hzerr.Deobfuscator;
import ru.hzerr.SashokClass;

public class SecurityHelper extends SashokClass {

    private static final String className = Deobfuscator.SECURITY_HELPER.getClassName();

    @Override
    public ByteCodeBuilder transform() {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(className)
                .filterByNames("verifyCertificates", "verifySign")
                .setEmptyBody()
                .concatMethodByteCodeBuilder()
                .filterByNames("isValidSign", "isValidCertificates")
                .setBodyReturnTrue();
    }
}
