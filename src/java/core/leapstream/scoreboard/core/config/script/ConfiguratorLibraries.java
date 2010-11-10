package leapstream.scoreboard.core.config.script;

import leapstream.scoreboard.edge.java.net.URL;

public interface ConfiguratorLibraries {
    void add(String ext, URL url);
    URL[] get(String extension);
}
