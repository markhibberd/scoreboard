package leapstream.scoreboard.legacy.resource.sounds;

import leapstream.scoreboard.legacy.resource.gunge.Resources;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public final class DefaultSounds implements Sounds {
    Resources resources;

    public URL get(String name) {
        return resources.url("leapstream/scoreboard/core/sounds/" + name);
    }
}
