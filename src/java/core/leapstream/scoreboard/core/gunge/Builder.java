package leapstream.scoreboard.core.gunge;

import leapstream.scoreboard.core.model.Build;

public interface Builder {
    Build get(String name, String url);
}
