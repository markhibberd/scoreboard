package leapstream.scoreboard.core.images;

import leapstream.scoreboard.alien.gunge.Resources;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultImages implements Images {
    Resources resources;


    public URL get(String name) {
        return resources.url("leapstream/scoreboard/core/images/" + name);
    }
}
