package leapstream.scoreboard.core.config.script;

public interface ExtensionMaster {
    void check(String ext, String... sx);
    String extension(String... s);
}
