package leapstream.scoreboard.alien.clobber.read.parse;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface TypeMapper {
    Class map(String input);
    void add(NameMapper mapper);
}
