package ru.hzerr;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;
import com.google.devtools.common.options.OptionsParser;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GradleOptions extends OptionsBase {

    @Option(name = "folder.full.name", defaultValue = "")
    public String folderFullName;

    @Option(name = "project.full.name", defaultValue = "")
    public String projectFullName;

    @Option(name = "project.test.name", defaultValue = "")
    public String projectTestName;

    @Option(name = "security.helper.class.name", defaultValue = "")
    public String securityHelperClassName;

    @Option(name = "client.launcher.class.name", defaultValue = "")
    public String clientLauncherClassName;

    @Option(name = "io.helper.class.name", defaultValue = "")
    public String ioHelperClassName;

    @Option(name = "launcher.class.name", defaultValue = "")
    public String launcherClassName;

    @Option(name = "log.helper.class.name", defaultValue = "")
    public String logHelperClassName;

    @Option(name = "debug.force.enabled", defaultValue = "false")
    public boolean isDebugForceEnabled;

    @Option(name = "launcher.name", defaultValue = "")
    public String launcherName;

    @Option(name = "launcher.version", defaultValue = "")
    public String launcherVersion;

    @Option(name = "launcher.build", defaultValue = "")
    public String launcherBuild;

    @Option(name = "files.to.be.updated", allowMultiple = true, defaultValue = "")
    public List<String> filesToBeUpdated;

    private String normalizeFolderFullName;
    private String normalizeProjectFullName;
    private String normalizeProjectTestFullName;

    private Path pathToFolder;
    private Path pathToProject;
    private Path pathToProjectTest;

    private File folderFile;
    private File projectFile;
    private File projectTestFile;

    // require "folderFullName"
    public File getFolderFile() {
        if (folderFile != null) return folderFile;
        return folderFile = new File(getFolderFullName());
    }

    // require "projectFullName"
    public File getProjectFile() {
        if (projectFile != null) return projectFile;
        return projectFile = new File(getProjectFullName());
    }

    // require projectTestName, folderFullName
    public File getProjectTestFile() {
        if (projectTestFile != null) return projectTestFile;
        return projectTestFile = new File(getFolderFile(), getProjectTestName());
    }

    // require "folderFullName"
    public Path getFolderPath() {
        if (pathToFolder != null) return pathToFolder;
        return pathToFolder = Paths.get(getFolderFullName());
    }

    // require "projectFullName"
    public Path getProjectPath() {
        if (pathToProject != null) return pathToProject;
        return pathToProject = Paths.get(getProjectFullName());
    }

    // require projectTestName, folderFullName
    public Path getProjectTestPath() {
        if (pathToProjectTest != null) return pathToProjectTest;
        return pathToProjectTest = getProjectTestFile().toPath();
    }

    // require folderFullName
    public String getFolderFullName() {
        if (normalizeFolderFullName != null) return normalizeFolderFullName;
        if (folderFullName.isEmpty()) throw new NullPointerException("Argument folderFullName should not be empty");
        return normalizeFolderFullName = new String(
                folderFullName.getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
    }

    // require projectFullName
    public String getProjectFullName() {
        if (normalizeProjectFullName != null) return normalizeProjectFullName;
        if (projectFullName.isEmpty()) throw new NullPointerException("Argument projectFullName should not be empty");
        return normalizeProjectFullName = new String(
                projectFullName.getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
    }

    // require projectTestName, folderFullName
    public String getProjectTestFullName() {
        if (normalizeProjectTestFullName != null) return normalizeProjectTestFullName;
        return normalizeProjectTestFullName = getProjectTestFile().getAbsolutePath();
    }

    // require projectTestName
    public String getProjectTestName() {
        if (projectTestName.isEmpty()) throw new NullPointerException("Argument projectTestName should not be empty");
        return projectTestName;
    }

    // require "projectFullName"
    public String getProjectName() {
        return getProjectFile().getName();
    }

    // require "filesToBeUpdated"
    public List<String> getFilesToBeUpdated() {
        if (filesToBeUpdated.isEmpty()) throw new NullPointerException("Argument filesToBeUpdated should not be empty");
        return filesToBeUpdated;
    }

    public static GradleOptions getGradleOptions(String... args) {
        final OptionsParser parser = OptionsParser.newOptionsParser(GradleOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(GradleOptions.class);
    }
}
