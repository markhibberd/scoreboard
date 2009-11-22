package leapstream.scoreboard.core.config.exposed;

// FIX CONFIG use or lose, expose configuration as a set of functions.
// FIX CONFIG fu'oramer. This is basically a facade, how does it fit with pattern?
public interface ConfigRegistry {
    void register(String key, String doc, Object target, String method);
    void register(String key, Object target, String method);
    void register(String key, String doc, Applicator applicator);
    void register(String key, Applicator applicator);
}
