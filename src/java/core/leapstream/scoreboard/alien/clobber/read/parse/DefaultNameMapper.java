package leapstream.scoreboard.alien.clobber.read.parse;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultNameMapper implements NameMapper {
    private final String pkg;

    public DefaultNameMapper(String pkg) {
        this.pkg = pkg;
    }

    public String map(String input) {
        return pkg + "." + input;
    }
}
