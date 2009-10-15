package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface Token extends Struct {
    enum Type { CLASS, END, VALUE, FIELD, LIST_START, LIST_ELEMENT, LIST_END }
    Type type();
    String lexeme();
}
