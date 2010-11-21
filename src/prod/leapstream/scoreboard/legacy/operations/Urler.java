package leapstream.scoreboard.legacy.operations;

import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface Urler {
    URL get(String url);

    URL[] get(String[] urls);
}
