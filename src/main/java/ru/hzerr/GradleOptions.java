package ru.hzerr;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.io.File;
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

    @Option(name = "debug.enabled", defaultValue = "false")
    public boolean isDebugEnabled;

    @Option(name = "launcher.name", defaultValue = "")
    public String launcherName;

    @Option(name = "launcher.version", defaultValue = "")
    public String launcherVersion;

    @Option(name = "files.to.be.updated", allowMultiple = true, defaultValue = "")
    public List<String> filesToBeUpdated;

    private Path pathToFolder;
    private Path pathToProject;

    private File folderFile;
    private File projectFile;

    // require "folderFullName"
    public File getFolderFile() {
        if (folderFile != null) return folderFile;
        if (!folderFullName.isEmpty()) return folderFile = new File(folderFullName);
        return null;
    }

    // require "projectFullName"
    public File getProjectFile() {
        if (projectFile != null) return projectFile;
        if (!projectFullName.isEmpty()) return projectFile = new File(projectFullName);
        return null;
    }

    // require "folderFullName"
    public Path getFolderPath() {
        if (pathToFolder != null) return pathToFolder;
        if (!folderFullName.isEmpty()) return pathToFolder = Paths.get(folderFullName);
        return null;
    }

    // require "projectFullName"
    public Path getProjectPath() {
        if (pathToProject != null) return pathToProject;
        if (!projectFullName.isEmpty()) return pathToProject = Paths.get(projectFullName);
        return null;
    }

    // require "projectFullName"
    public String getProjectName() {
        if (projectFullName.isEmpty()) return null;
        return getProjectFile().getName();
    }

    // require "filesToBeUpdated"
    public String getFilesToBeUpdated() {
        if (!filesToBeUpdated.isEmpty())
            return filesToBeUpdated.stream()
                    .map(filename -> filename + " ")
                    .collect(Collectors.joining());
        return null;
    }
}
