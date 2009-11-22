package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface Applicators {
    Applicator bind(Object o, String method);
    // FIX CONFIG consider some generic ones, color {fg,bg} etc...
}
