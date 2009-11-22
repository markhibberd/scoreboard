package leapstream.scoreboard.core.config;

// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface Config {
    void register(String key, ConfigFunction f);
}
