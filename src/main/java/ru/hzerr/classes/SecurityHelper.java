package ru.hzerr.classes;

import ru.hzerr.*;

public class SecurityHelper extends SashokClass {

    @Override
    public ByteCodeBuilder transform(GradleOptions options) {
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(options.securityHelperClassName)
                .filterByNames("verifyCertificates", "verifySign")
                .setEmptyBody()
                .concatMethodByteCodeBuilder()
                .filterByNames("isValidSign", "isValidCertificates")
                .setBodyReturnTrue();
    }
}
