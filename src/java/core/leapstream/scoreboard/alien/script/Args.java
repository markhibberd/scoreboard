package leapstream.scoreboard.alien.script;

public interface Args extends Iterable<Arg> {
    void put(String name, Object value);
}
