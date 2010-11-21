package leapstream.scoreboard.legacy.config.script;

public interface ExtensionMaster {
    void check(String ext, String... sx);
    String extension(String... s);
}
