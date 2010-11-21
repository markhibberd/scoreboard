package leapstream.scoreboard.legacy.operations;

import leapstream.scoreboard.legacy.model.Build;

public interface Builder {
    Build get(String name, String url);
}
