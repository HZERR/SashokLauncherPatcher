package ru.hzerr.util;

import org.apache.commons.io.FileUtils;
import ru.hzerr.GradleOptions;
import ru.hzerr.HLogger;

import java.io.*;

public class ManifestChanger {

    public static void main(String[] args) throws IOException { change(GradleOptions.getGradleOptions(args)); }

    public static void change(GradleOptions options) throws IOException {
        File META_INF = new File(options.getFolderFile(), "META-INF");
        File MANIFEST = new File(META_INF, "MANIFEST.MF");
        File RSA_FILE = new File(META_INF, "LAUNCHER.RSA");
        File SF_FILE  = new File(META_INF, "LAUNCHER.SF");
        if (RSA_FILE.exists()) FileUtils.forceDelete(RSA_FILE);
        if (SF_FILE.exists()) FileUtils.forceDelete(SF_FILE);
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
