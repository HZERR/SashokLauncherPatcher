package ru.hzerr.util;

import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;
import ru.hzerr.Helper;

import java.io.*;

public class ManifestChanger {

    public static void main(String[] args) throws IOException { change(Helper.parse(args)); }

    public static void change(GradleOptions options) throws IOException {
        File META_INF = new File(options.folderFullName + File.separator + "META-INF");
        File MANIFEST = new File(META_INF.getAbsolutePath() + File.separator + "MANIFEST.MF");
        File RSA_FILE = new File(META_INF.getAbsolutePath() + File.separator + "LAUNCHER.RSA");
        File SF_FILE  = new File(META_INF.getAbsolutePath() + File.separator + "LAUNCHER.SF");
        if (RSA_FILE.exists()) RSA_FILE.deleteOnExit();
        if (SF_FILE.exists()) SF_FILE.deleteOnExit();
        StringBuilder attributes;
        try (BufferedReader reader = new BufferedReader(new FileReader(MANIFEST))) {
            attributes = reader.lines().
                    filter(line -> line.contains("Manifest-Version:") || line.contains("Main-Class:"))
                    .map(line -> line = line.concat("\r\n"))
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MANIFEST))) {
            bufferedWriter.write(attributes.toString());
        }

        HLogger.success("The META-INF folder has been successfully patched");
    }
}
