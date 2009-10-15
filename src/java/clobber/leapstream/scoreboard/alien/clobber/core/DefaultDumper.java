package leapstream.scoreboard.alien.clobber.core;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
// FIX 375 Think about replacing this with customized to string.
public final class DefaultDumper implements Dumper {
    public String dump(Object ref) {
        return ref.toString();
    }
}
