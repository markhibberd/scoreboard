package leapstream.scoreboard.alien.clobber.read.parse;

import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface Parser {
    Object parse(TokenStream tokens);
}
