package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG wire this into configurable components, e.g. board, score pylon.
// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface ExposedConfigs {
    void expose(ConfigRegistry registry);
}
