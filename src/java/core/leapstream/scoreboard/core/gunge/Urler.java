package leapstream.scoreboard.core.gunge;

import leapstream.scoreboard.edge.java.net.URL;

public interface Urler {
    URL get(String url);

    URL[] get(String[] urls);
}
