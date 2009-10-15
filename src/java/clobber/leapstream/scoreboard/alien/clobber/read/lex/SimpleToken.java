package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface SimpleToken extends Struct {
    enum Type {STRING, OPEN, EQUALS, NEWLINE, CLOSE
    }
    Type type();
    String lexeme();
}
