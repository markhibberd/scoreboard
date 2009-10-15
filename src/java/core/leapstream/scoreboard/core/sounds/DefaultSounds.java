package leapstream.scoreboard.core.sounds;

import leapstream.scoreboard.alien.gunge.Resources;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultSounds implements Sounds {
    Resources resources;

    public URL get(String name) {
        return resources.url("leapstream/scoreboard/core/sounds/" + name);
    }
}
