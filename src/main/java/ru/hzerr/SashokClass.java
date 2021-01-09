package ru.hzerr;

public abstract class SashokClass {

    public SashokClass() {}

    public abstract ByteCodeBuilder transform(GradleOptions options);

    public void doTransform(GradleOptions options) { transform(options).writeFile(options.getFolderFullName()); }
}
