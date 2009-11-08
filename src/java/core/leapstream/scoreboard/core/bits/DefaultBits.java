package leapstream.scoreboard.core.bits;

import leapstream.scoreboard.alien.gunge.Resources;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultBits implements Bits {
    String path = "leapstream/scoreboard/core/bits";
    Resources resources;

    public URL url(String name) {
        String full = full(name);
        return resources.url(full);
    }

    public InputStream stream(String name) {
        String full = full(name);
        return resources.stream(full);
    }

    private String full(String name) {
        return path + "/" + name;
    }
}
