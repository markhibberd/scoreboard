package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface Seed {
    String key();
    String doc();
    Applicator applicator();
}