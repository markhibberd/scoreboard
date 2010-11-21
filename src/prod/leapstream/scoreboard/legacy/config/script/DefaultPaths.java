package leapstream.scoreboard.legacy.config.script;

public final class DefaultPaths implements Paths {
    public String extension(String path) {
        String[] strings = path.split("\\.");
        return strings[strings.length - 1];
    }
}
