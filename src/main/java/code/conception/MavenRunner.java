package code.conception;

import org.apache.maven.cli.MavenCli;

import java.io.File;
import java.io.PrintStream;

public class MavenRunner {

    private static final File PATH_TO_POM = new File(ClassLoader.getSystemResource("pom.xml").getFile());
    private static final String MVN_GOAL = "compile";
    private static final PrintStream OUTPUT = System.out;
    private static final PrintStream ERROR_OUTPUT = System.out;

    public static void useMavenCli() {
        MavenCli mavenCli = new MavenCli();
        mavenCli.doMain(new String[]{MVN_GOAL},
                getContainingFolder(PATH_TO_POM),
                OUTPUT,
                ERROR_OUTPUT);
    }

    public static void main(String[] args) {
        useMavenCli();
    }

    private static String getContainingFolder(File file) {
        return file.getParentFile().getAbsolutePath();
    }
}
