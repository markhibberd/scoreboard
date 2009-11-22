package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface Seeds extends Iterable<String> {
    void put(Seed seed);
    Seed get(String key);
}
