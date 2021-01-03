package ru.hzerr;

public abstract class SashokClass {
    public SashokClass() {}

    public abstract ByteCodeBuilder transform();

    public void doTransform() { transform().writeFile(IOHelper.FOLDER_FULL_NAME); }
}
