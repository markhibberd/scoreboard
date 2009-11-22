package leapstream.scoreboard.core.config.exposed;

public interface ConfigBaker {
    void bake(Config config, String key, Object o, String method);
}
