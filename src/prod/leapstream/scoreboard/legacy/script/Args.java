package leapstream.scoreboard.legacy.script;

public interface Args extends Iterable<Arg> {
    void put(String name, Object value);
}
