package leapstream.scoreboard.alien.clobber.read.lex;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultScanner implements Scanner {
    private final StringBuilder buffer;
    private int offset = 0;

    public DefaultScanner(StringBuilder buffer) {
        this.buffer = buffer;
    }

    public String scanPast(char marker) {
        String value = scanTo(marker);
        ++offset;
        return value;
    }

    public boolean lookahead(String regex) {
        String current = build(offset);
        return current.matches("(?s)" + regex + ".*");
    }

    private String scanTo(char marker) {
        int start = offset;
        for (;offset < buffer.length(); ++offset) {
            if (current() == marker) return build(start, offset);
        }
        throw new IllegalStateException("Expected: " + marker + " in " + build(start));
    }

    private char current() {
        return buffer.charAt(offset);
    }

    private String build(int from) {
        return build(from, buffer.length());
    }

    private String build(int from, int to) {
        String result = buffer.substring(from, to);
        return result.trim();
    }

    public String toString() {
        return "Original: " + buffer + LINE + "Current: " + build(offset);
    }
}
