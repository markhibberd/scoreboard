package leapstream.scoreboard.legacy.config.script;

import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface ConfiguratorLibraries {
    void add(String ext, URL url);
    URL[] get(String extension);
}
