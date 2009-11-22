package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG use or lose, expose configuration as a set of functions.
// FIX CONFIG consider config of different types. 
public interface Applicator {
    void apply(String s);
}
